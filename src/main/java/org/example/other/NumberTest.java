package org.example.other;

/**
 * @author walker.dou
 */
public class NumberTest {
    public static void main(String[] args) {
        double a = -6.6;
        double b = 0;
        final double calculate = calculate(a, b);
        if (calculate < 1){
            System.out.println(true);
        }
        System.out.println(calculate);

    }
    private static double calculate(double a, double b) {
        return a / b;
    }
}
