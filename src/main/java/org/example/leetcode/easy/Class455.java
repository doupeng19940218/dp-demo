package org.example.leetcode.easy;

import java.util.Arrays;

/**
 * @author walker.dou
 */
public class Class455 {
    public static void main(String[] args) {
        int[] a = {10, 9, 8, 7};
        int[] b = {5, 6, 7, 8};
        final Class455 class455 = new Class455();
        class455.findContentChildren(a, b);
    }
        /**
         * 输入: g = [1,2,3], s = [1,1]
         * 输出: 1
         * 解释:
         * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
         * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
         * 所以你应该输出1。
         */
        public int findContentChildren ( int[] g, int[] s){
            Arrays.sort(g);
            Arrays.sort(s);
            int used = 0;
            for (int i = 0; i < s.length; i++) {
                if (g[used] <= s[i]) {
                    used++;
                }
                if (used == g.length) {
                    return used;
                }
            }
            return used;
        }
    }
