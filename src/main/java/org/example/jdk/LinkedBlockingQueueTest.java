package org.example.jdk;

import org.junit.jupiter.api.Test;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author walker.dou
 */
public class LinkedBlockingQueueTest {

    //unlinkFirst help GC
    @Test
    public void test() {
        final LinkedBlockingQueue<String> l = new LinkedBlockingQueue<>();
        l.add("1");
        l.add("2");
        l.add("3");
        System.out.println(l);
        l.remove();
        System.out.println(l);
    }
}
