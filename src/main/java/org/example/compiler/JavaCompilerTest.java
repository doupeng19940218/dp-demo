package org.example.compiler;

import org.junit.jupiter.api.Test;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author walker.dou
 */
public class JavaCompilerTest {

    @Test
    public void demo() throws IOException {
        //JavaCompiler编译类
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, null, null, "d:/myC/HelloWorld.java");
        System.out.println(result == 0 ? "编译成功" : "编译失败");


        String str = "public class HelloWorld{\n" +
                "\tpublic static void main(String[] args){\n" +
                "\t\tSystem.out.println(\"helloworld\");\n" +
                "\t}\n" +
                "}";
        final File htmlFile = File.createTempFile("tmp", ".java");//创建临时文件
        System.out.println("临时文件所在的本地路径：" + htmlFile.getCanonicalPath());
        BufferedWriter bw = new BufferedWriter(new FileWriter(htmlFile));
        result = compiler.run(null, null, null, htmlFile.getCanonicalPath());
        System.out.println(result == 0 ? "编译成功" : "编译失败");
        try {
            bw.write(str);
            bw.flush();
        } finally {
            bw.close();
            htmlFile.deleteOnExit();//程序退出时删除临时文件
        }

        //Runtime调用编译类
        Runtime run = Runtime.getRuntime();
        Process process = run.exec("java -cp d:/myC/HelloWorld");
        InputStream in = process.getInputStream();
        BufferedReader bw1 = new BufferedReader(new InputStreamReader(in));
        String info = "";
        while ((info = bw1.readLine()) != null) {
            System.out.println(info);
        }
    }

    @Test
    public void run() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, MalformedURLException {
        URL[] urls = new URL[] {new URL("file:/"+"d:/myC/")};
        URLClassLoader loader = new URLClassLoader(urls);
        Class c = loader.loadClass("HelloWorld");
        //调用加载类的main方法
        c.getMethod("main",String[].class).invoke(null, (Object)new String[]{});
    }

}
