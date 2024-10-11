package strategies;

public class WebDavStorage implements IStorage {

    public WebDavStorage(String uri, String authKey) {
        System.out.println("Connecting to WebDav with uri " + uri + " and auth key " + authKey);
    }

    public void upload(String attachment) {
        System.out.println("Uploading " + attachment + " to WebDav");
    }

    public void download(String attachment) {
        System.out.println("Downloading " + attachment + " from WebDav");
    }

}
