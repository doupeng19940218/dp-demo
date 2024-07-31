package org.example.jni;

/**
 * @author walker.dou
 */
public class HeicConverter {
    static {
        System.loadLibrary("HeicConverter");
    }

    public native boolean convertHeicToJpeg(String heicFilePath, String jpegFilePath);

    public static void main(String[] args) {
        HeicConverter converter = new HeicConverter();
        boolean success = converter.convertHeicToJpeg("path/to/input.heic", "path/to/output.jpg");
        if (success) {
            System.out.println("Conversion successful.");
        } else {
            System.out.println("Conversion failed.");
        }
    }
}