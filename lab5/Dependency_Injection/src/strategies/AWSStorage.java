package strategies;

public class AWSStorage implements IStorage {

    public AWSStorage(String accessKey, String secretKey) {
        System.out.println("Connecting to AWS with access key " + accessKey + " and secret key " + secretKey);
    }

    public void upload(String attachment) {
        System.out.println("Uploading " + attachment + " to AWS");
    }

    public void download(String attachment) {
        System.out.println("Downloading " + attachment + " from AWS");
    }

}
