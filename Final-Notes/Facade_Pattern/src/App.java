import facade.VideoConversionFacade;

public class App {
    public static void main(String[] args) throws Exception {
        // Client code only interacts with the Facade
        VideoConversionFacade converter = new VideoConversionFacade();

        // Converting mp4 to ogg
        converter.convertVideo("birthday-video.mp4", "ogg");

        // Converting ogg to mp4
        converter.convertVideo("lecture.ogg", "mp4");
    }
}
