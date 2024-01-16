package org.example.leetcode.easy;

/**
 * @author walker.dou
 */
public class Class35 {
    public static void main(String[] args) {
        int[] a = {1, 3,5,6};
        final Class35 class35 = new Class35();
        System.out.println(class35.searchInsert(a, 2));
    }

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums[0] > target) {
            return 0;
        }
        if (nums[nums.length - 1] == target) {
            return nums.length - 1;
        }

        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        int start = 0;
        int end = nums.length - 1;
        int middle = -1;
        while (start <= end) {
            middle = (start + end) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return start;
    }
}
