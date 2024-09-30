package helpers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import context.EncryptionContext;

import java.io.IOException;
import java.io.OutputStream;

public class DecryptHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("POST".equals(exchange.getRequestMethod())) {
            String requestBody = new String(exchange.getRequestBody().readAllBytes());

            // Extract encryptedData and encryptionType from the request body
            String[] parts = requestBody.split(",");
            String encryptedData = parts[0].split(":")[1].replace("\"", "").trim();
            String encryptionType = parts[1].split(":")[1].replace("\"", "").replace("}", "").trim();

            // Set the decryption strategy based on the type
            EncryptionContext context = new EncryptionContext();
            context.setEncryptionStrategy(encryptionType);

            String decryptedData = context.decryptData(encryptedData);

            // Respond to the client
            String response = "{\"decryptedData\":\"" + decryptedData + "\"}";
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        } else {
            exchange.sendResponseHeaders(405, -1); // Method Not Allowed
        }
    }
}
