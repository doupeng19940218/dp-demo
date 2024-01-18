package org.example.leetcode.easy;

import java.util.Arrays;

/**
 * @author walker.dou
 */
public class Class575 {
    public static void main(String[] args) {
        int[] a = {1000, 1000, 2, 1, 2, 5, 3, 1};
        final Class575 class575 = new Class575();
        System.out.println(class575.distributeCandies(a));
    }

    public int distributeCandies(int[] candyType) {
        int max = candyType.length / 2;
        int count = 0;
        Arrays.sort(candyType);
        for (int i = 0; i < candyType.length; i++) {
            max = max - candyType[i];
            if (max == 1) {
                count = count + 2;
                return count;
            } else if (max <= 0) {
                count = count + 1;
                return count;
            } else {
                count++;
            }
        }
        return count;
    }
}
