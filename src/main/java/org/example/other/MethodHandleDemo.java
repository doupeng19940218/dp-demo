package org.example.other;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @author walker.dou
 */
public class MethodHandleDemo {

    public void print(String s) {
        System.out.println("hello, " + s);
    }

    public static void main(String[] args) throws Throwable {
        // 创建MethodType对象，指定方法的返回值类型和参数类型
        MethodType methodType = MethodType.methodType(void.class, String.class);

        // MethodHandles.lookup()静态方法返回 MethodHandles.Lookup 对象，这个对象表示查找的上下文
        // findVirtual查找方法签名为methodType的方法句柄
        MethodHandle methodHandle = MethodHandles.lookup().findVirtual(MethodHandleDemo.class, "print", methodType);
        // 进行方法调用
        MethodHandleDemo methodHandleDemo = new MethodHandleDemo();
        methodHandle.invokeExact(methodHandleDemo, "world");
    }

}