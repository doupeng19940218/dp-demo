package org.example.jni;

import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * @author walker.dou
 */
public class HelloNative {

    static {
//        System.loadLibrary("Dll1");
//        System.load("/C:\\Users\\walker.dou\\source\\repos\\Dll1\\x64\\Debug\\Dll1.dll");
//                System.loadLibrary("findins");

        System.load("C:\\Users\\walker.dou\\IdeaProjects\\dp-demo\\src\\main\\resources\\findins.dll");

//        String nativeLib = null;
//        String osName = System.getProperty("os.name").toLowerCase();
//        String osArch = System.getProperty("os.arch");  //x86 & arm架构标识
//        if (osName.contains("mac")) {
//            if (null != osArch && osArch.toLowerCase().contains("aarch")) {
//                nativeLib = "findins_arm.dylib";
//            } else {
//                nativeLib = "findins.dylib";
//            }
//        } else if (osName.contains("linux")) {
//            if (null != osArch && osArch.toLowerCase().contains("aarch")) {
//                nativeLib = "findins_arm.so";
//            } else {
//                nativeLib = "findins.so";
//            }
//        } else if (osName.contains("windows")) {
//            nativeLib = "Dll1.dll";
//        }
//        if (null == nativeLib) {
//            throw new UnsupportedOperationException("not support" + osName);
//        }
//        URL nativeLibURL = HelloNative.class.getClassLoader().getResource(nativeLib);
//        if (null == nativeLibURL) {
//            System.out.println("cannot find" + nativeLib);
//        } else if ("jar".equals(nativeLibURL.getProtocol())) {
//
//            loadLibraryFromJar(nativeLibURL, nativeLib);
//
//        } else {
//            System.load(nativeLibURL.getPath());
//        }
    }

    private static void loadLibraryFromJar(URL nativeLibURL, String nativeLib) {

        String path = nativeLibURL.getPath();

        //[jar] file:/Users/liubs/.m2/repository/io/github/liubsyy/FindInstancesOfClass/1.0.1/FindInstancesOfClass-1.0.2.jar!/findins.dylib
        //[SpringBoot jar] file:/Users/liubs/IdeaProjects/TestSpring/bin/TestSpring.jar!/BOOT-INF/lib/FindInstancesOfClass-1.0.2.jar!/findins.dylib
        String jarPath = path.substring("file:".length(), path.indexOf("jar!") + "jar".length());

        try {
            jarPath = URLDecoder.decode(jarPath, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        File curDir = new File(jarPath);
        curDir = curDir.getParentFile();

        File nativeLibFile = new File(curDir.getAbsolutePath(), nativeLib);
        nativeLibFile.deleteOnExit();

        try (InputStream is = nativeLibURL.openStream(); OutputStream os = Files.newOutputStream(nativeLibFile.toPath())) {
            byte[] buffer = new byte[1024];
            int readBytes;
            while ((readBytes = is.read(buffer)) != -1) {
                os.write(buffer, 0, readBytes);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.load(nativeLibFile.getAbsolutePath());
    }


    public static native void greeting();

    public static void main(String[] args) {
        HelloNative.greeting();
    }
}
