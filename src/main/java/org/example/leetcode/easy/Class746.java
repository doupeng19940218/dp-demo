package org.example.leetcode.easy;

import java.util.Arrays;

/**
 * @author walker.dou
 */
public class Class746 {
    public static void main(String[] args) {
        final Class746 class746 = new Class746();
        int[] a = new int[]{10, 15, 20};
        System.out.println(class746.minCostClimbingStairs(a));
    }

    public int minCostClimbingStairs(int[] cost) {
        final int[] cache = new int[cost.length];
        Arrays.fill(cache, -1); // -1 表示没有计算过
        return Math.min(climb(cost, 0, cache), climb(cost, 1, cache));
    }

    private int climb(int[] cost, int i, int[] cache) {
        final int length = cost.length;
        if (i >= length) {
            return 0;
        }
        if (cache[i] != -1) {
            return cache[i];
        }
        int curr = cost[i];
        final int a = climb(cost, i + 1, cache);
        final int b = climb(cost, i + 2, cache);
        return cache[i] = Math.min(curr + a, curr + b);
    }
}
