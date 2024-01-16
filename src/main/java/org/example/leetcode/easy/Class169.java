package org.example.leetcode.easy;

import java.util.Arrays;

/**
 * @author walker.dou
 */
public class Class169 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
