package org.example.leetcode.easy;

/**
 * @author walker.dou
 */
public class Class268 {
    public static void main(String[] args) {
        final Class268 class268 = new Class268();
        int[] nums = {3, 0, 1};
        class268.missingNumber(nums);
    }

    public int missingNumber(int[] nums) {
        final int length = nums.length;
        byte[] temp = new byte[length + 1];
        for (int i = 0; i < length; i++) {
            temp[nums[i]] = 1;
        }
        for (int i = 0; i < length + 1; i++) {
            if (temp[i] == 0) {
                return i;
            }
        }
        return 0;
    }
}
