package org.example.other;

/**
 * @author walker.dou
 */
public class TernaryOperator {
    /**
     * 1）如果第二个和第三个操作数具有相同的类型(可能是null类型)，那么这就是条件表达式的类型。
     *
     * 2）如果第二个和第三个操作数中的一个是基本类型T，而另一个操作数的类型是对T应用装箱转换(§5.1.7)的结果，则条件表达式的类型为T。
     *
     * 3）如果第二个和第三个操作数中的一个是空类型，而另一个操作数的类型是引用类型，则条件表达式的类型就是该引用类型。
     * ————————————————
     * 版权声明：本文为CSDN博主「头秃的程序员小王」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/qq_39326472/article/details/128738405
     * @param args
     */
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = null;
        Boolean flag = true;
//a*b的结果是int类型,那么c会强制拆箱成int类型,抛出NPE异常
        Integer result = (flag ?  c:a * b);
    }
}
