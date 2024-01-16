package org.example.leetcode.easy;

/**
 * @author walker.dou
 */
public class Class27 {

    public static void main(String[] args) {
        final Class27 class27 = new Class27();
        int[] intArr = {3, 2, 2, 4};

        final int i = class27.removeElement(intArr, 3);
        System.out.println(i);
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0){
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        int temp = 0;
        while (start != end + 1) {
            if (nums[start] != val) {
                start++;
            } else {
                temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                end--;
            }
        }
        return start;
    }
}
