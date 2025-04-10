package ComplexSystem;

public class CodecFactory {
    public static Codec getCodec(String format) {
        if (format.equals("mp4")) {
            return new MPEG4Codec();
        } else {
            return new OggCodec();
        }
    }
}
