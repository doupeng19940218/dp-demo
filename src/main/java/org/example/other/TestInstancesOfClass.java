package org.example.other;

import com.liubs.findinstances.jvmti.InstancesOfClass;

import java.util.List;

/**
 * @author walker.dou
 */
public class TestInstancesOfClass {
    public static void main(String[] args) {
        helloJni();

        final Demo demo = new Demo();
        final List<Demo> instanceList = InstancesOfClass.getInstanceList(Demo.class);
        System.out.println(instanceList);


    }
    public static native String helloJni();


    public static class Demo{

    }
}
