package org.example.leetcode.easy;

import org.example.rule.QLExpress.QLExpressDemo;

/**
 * @author walker.dou
 */
public class Class367 {
    public static void main(String[] args) {
        final Class367 class367 = new Class367();
        class367.isPerfectSquare(2147483647);

    }

    public boolean isPerfectSquare(int num) {
        int min = 0;
        int max = num;

        while (min <= max) {
            int mid = (max - min) / 2 + min;;
            long square = (long) mid * mid;
            if ( square > num) {
                max = mid - 1;
            } else if (square < num) {
                min = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
