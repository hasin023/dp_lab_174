package ComplexSystem;

public class VideoFile {
    private String name;
    private String format;

    public VideoFile(String name) {
        this.name = name;
        this.format = name.substring(name.indexOf(".") + 1);
    }

    public String getFormat() {
        return format;
    }

    public String getName() {
        return name;
    }
}