package ComplexSystem;

public class VideoConverter {
    public VideoFile convert(VideoFile file, Codec codec) {
        System.out.println("Converting video from " + file.getFormat() +
                " to " + codec.getType());
        // Conversion logic would go here
        return new VideoFile(file.getName().replace(file.getFormat(), codec.getType()));
    }
}