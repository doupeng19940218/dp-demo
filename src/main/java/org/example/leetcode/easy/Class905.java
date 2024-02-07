package org.example.leetcode.easy;

/**
 * @author walker.dou
 */
public class Class905 {
    public int[] sortArrayByParity(int[] nums) {
        final int length = nums.length;
        if (length == 1) {
            return nums;
        }
        int start = 0;
        int end = length - 1;
        while (start < end) {
            int value = nums[start];
            if (value % 2 == 0) {
                start++;
            } else {
                int temp = nums[end];
                nums[end] = nums[start];
                nums[start] = temp;
                end--;
            }
        }
        return nums;
    }
}
