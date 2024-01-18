package org.example.leetcode.easy;

/**
 * @author walker.dou
 */
public class ClassLCP06 {
    public static void main(String[] args) {
        final ClassLCP06 classLCP06 = new ClassLCP06();
        int[] a = {1, 5, 5, 6};
        System.out.println(classLCP06.minCount(a));
    }
    public int minCount(int[] coins) {
        int count = 0;
        int oddCount = 0;
        for (int i = 0; i < coins.length; i++) {
            count = count + coins[i] / 2;
            oddCount = oddCount + coins[i] % 2;
        }
        return count + oddCount;
    }
}
