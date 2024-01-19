package org.example.leetcode.easy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author walker.dou
 */
public class Class697 {
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3, 1, 4, 2};
        final Class697 class697 = new Class697();
        class697.findShortestSubArray(a);
    }

    // 我只求了度
    //输入：nums = [1,2,2,3,1]
    //输出：2
    public int findShortestSubArray(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int max = 0;
        int start = 0;
        int end = 1;
        Arrays.sort(nums);
        for (; end < nums.length; end++) {
            if (nums[end] != nums[start]) {
                max = Math.max(max, end - start);
                start = end;
            }
        }
        return max;
    }
}
