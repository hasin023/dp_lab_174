package strategies;

public class SFTPStorage implements IStorage {

    public SFTPStorage(String host, String port, String username, String privateKey) {
        System.out.println("Connecting to SFTP with host " + host + " and port " + port + " and username " + username
                + " and private key " + privateKey);
    }

    public void upload(String attachment) {
        System.out.println("Uploading " + attachment + " to SFTP");
    }

    public void download(String attachment) {
        System.out.println("Downloading " + attachment + " from SFTP");
    }

}
