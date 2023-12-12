package org.example.lombok;

/**
 * @author walker.dou
 */

@lombok.experimental.ExtensionMethod(Extensions.class)
public class ExtensionMethod {

    public void test() {
        Integer a = 1;
        final int i = a.compare2(2);

    }


    public static void main(String[] args) {
        String a = "1";
        a.toString();
        a = null;
        a.toString();

    }
}

class Extensions {
    public static int compare2(Integer a, Integer b) {
        return a.compareTo(b);
    }

    public static void toString(String a) {
        System.out.println(a);
    }
}