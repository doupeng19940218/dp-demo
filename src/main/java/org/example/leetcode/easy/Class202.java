package org.example.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author walker.dou
 */
public class Class202 {
    public static void main(String[] args) {
        final Class202 class202 = new Class202();
        System.out.println(class202.isHappy(19));

    }

    /**
     * 输入：n = 19
     * 输出：true
     * 解释：
     * 12 + 92 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1
     */
    public boolean isHappy(int n) {
        int result = n;
        final Set<Integer> cachae = new HashSet<>();
        while (result != 1 && !cachae.contains(result)) {
            cachae.add(result);
            result = getSum(result);
        }
        return result == 1;
    }

    private int getSum(int result) {
        int sum = 0;
        int temp = 0;
        while (result > 0) {
            temp = result % 10;
            sum = sum + temp * temp;
            result = result / 10;
        }
        return sum;
    }
}
