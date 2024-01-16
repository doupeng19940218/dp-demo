package org.example.leetcode.easy;

/**
 * @author walker.dou
 */
public class Class66 {

    public static void main(String[] args) {
        final int[] ints = {9, 9, 9};
        final Class66 class66 = new Class66();
        class66.plusOne(ints);
    }

    /**
     * 输入：digits = [1,2,3]
     * 输出：[1,2,4]
     * 解释：输入数组表示数字 123。
     * <p>
     * 输入：digits = [1,2,9]
     * 输出：[1,3,0]
     * <p>
     * 输入：digits = [9,9,9]
     * 输出：[1,0,0,0]
     */
    public int[] plusOne(int[] digits) {
        int curr = digits.length - 1;
        while (curr >= 0) {
            if (digits[curr] == 9) {
                digits[curr] = 0;
                if (curr == 0) {
                    int[] result = new int[digits.length + 1];
                    for (int i = digits.length - 1; i >= 0; i--) {
                        result[i + 1] = digits[i];
                    }
                    result[0] = 1;
                    return result;
                }
                curr--;
            } else {
                digits[curr] = digits[curr] + 1;
                return digits;
            }
        }
        return digits;
    }
}
