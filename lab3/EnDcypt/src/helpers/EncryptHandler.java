package helpers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import context.EncryptionContext;

import java.io.IOException;
import java.io.OutputStream;

public class EncryptHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("POST".equals(exchange.getRequestMethod())) {
            String requestBody = new String(exchange.getRequestBody().readAllBytes());

            // Extract data and encryptionType from the request body
            String[] parts = requestBody.split(",");
            String data = parts[0].split(":")[1].replace("\"", "").trim();
            String encryptionType = parts[1].split(":")[1].replace("\"", "").replace("}", "").trim();

            // Set the encryption strategy based on the type
            EncryptionContext context = new EncryptionContext();
            context.setEncryptionStrategy(encryptionType);

            String encryptedData = context.encryptData(data);

            // Respond to the client
            String response = "{\"encryptedData\":\"" + encryptedData + "\"}";
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        } else {
            exchange.sendResponseHeaders(405, -1); // Method Not Allowed
        }
    }
}