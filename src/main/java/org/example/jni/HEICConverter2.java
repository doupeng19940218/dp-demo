package org.example.jni;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Iterator;

public class HEICConverter2 {

    public static void main(String[] args) {
        String inputFilePath = "C:\\Users\\walker.dou\\Downloads\\a.heic";
        String outputFilePath = "C:\\Users\\walker.dou\\Downloads\\a.jpg";
        convertHEICtoJPEG(inputFilePath, outputFilePath);
    }

    public static void convertHEICtoJPEG(String inputFilePath, String outputFilePath) {
        try {
            // Register TwelveMonkeys HEIF ImageReader and ImageWriter
            ImageIO.scanForPlugins();

            // Read HEIC image
            FileImageInputStream input = new FileImageInputStream(new File(inputFilePath));
            Iterator<ImageReader> readers = ImageIO.getImageReaders(input);
            ImageReader reader = readers.next();
            reader.setInput(input);

            BufferedImage image = reader.read(0);

            // Write JPEG image
            File output = new File(outputFilePath);
            FileImageOutputStream outputFile = new FileImageOutputStream(output);
            Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpeg");
            ImageWriter writer = writers.next();
            writer.setOutput(outputFile);

            writer.write(image);

            // Cleanup
            input.close();
            outputFile.close();
            reader.dispose();
            writer.dispose();

            System.out.println("Conversion complete.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
