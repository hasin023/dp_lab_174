package facade;

import ComplexSystem.*;

public class VideoConversionFacade {
    /**
     * Converts a video file to the specified format
     * 
     * @param filename the input video file name
     * @param format   the target format
     * @return true if conversion was successful
     */

    public boolean convertVideo(String filename, String targetFormat) {
        System.out.println("\nVideoConversionFacade: Starting conversion...");

        VideoFile videoFile = new VideoFile(filename);
        System.out.println("Loading video file: " + filename);

        // Get the source codec based on the video format
        Codec sourceCodec = CodecFactory.getCodec(videoFile.getFormat());
        System.out.println("Source format: " + sourceCodec.getType());

        // Get the target codec based on the target format
        Codec destinationCodec = CodecFactory.getCodec(targetFormat);
        System.out.println("Target format: " + destinationCodec.getType());

        // Convert the video using the converter subsystem
        VideoConverter converter = new VideoConverter();
        VideoFile convertedVideo = converter.convert(videoFile, destinationCodec);

        // Fix audio in the converted video
        AudioMixer audioMixer = new AudioMixer();
        audioMixer.fixAudio(convertedVideo);

        System.out.println("VideoConversionFacade: Conversion completed successfully!");
        return true;
    }
}
