package org.example.lombok;

import lombok.experimental.Delegate;

/**
 * @author walker.dou
 */
public class DelegateExample {

    @Delegate(types = A.class)
    private final A a = new A();

    public static void main(String[] args) {
        final DelegateExample delegateExample = new DelegateExample();
        delegateExample.walk();
    }
}

class A {
    public void walk() {
        System.out.println("walk");
    }
}