import strategies.*;

public class App {
    public static void main(String[] args) throws Exception {
        IStorage AWSStorage = new AWSStorage("someKey", "someSecret");
        AWSStorage.upload("someFile");

        IStorage SFTPStorage = new SFTPStorage("local", "7700", "hasin", "1234");
        SFTPStorage.upload("someFile");

        IStorage WebDavStorage = new WebDavStorage("http://webdav.com", "1234");
        WebDavStorage.upload("someFile");
    }
}
