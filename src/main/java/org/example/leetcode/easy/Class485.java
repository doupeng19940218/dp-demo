package org.example.leetcode.easy;

/**
 * @author walker.dou
 */
public class Class485 {

    public static void main(String[] args) {
        int[] a = {1,1,0,1,1,1};
        final Class485 class485 = new Class485();
        class485.findMaxConsecutiveOnes(a);

    }

    /**
     * 输入：nums = [1,1,0,1,1,1]
     * 输出：3
     * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxZero = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                maxZero = Math.max(i - start, maxZero);
                start = i + 1;
            }
        }
        return Math.max(nums.length - start, maxZero);
    }
}
