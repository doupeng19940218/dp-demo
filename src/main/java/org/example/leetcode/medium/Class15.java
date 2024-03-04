package org.example.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author walker.dou
 */
public class Class15 {

    //todo 超时了，需要优化
    public static void main(String[] args) {
        int[] arr = {-2, 0, 1, 1, 2};
        final Class15 class15 = new Class15();
        final List<List<Integer>> lists = class15.threeSum(arr);
        System.out.println(lists);

    }

    /**
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 解释：
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
     * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
     * 注意，输出的顺序和三元组的顺序并不重要。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        final HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums) {
            Integer i = numMap.get(num);
            if (i == null) {
                numMap.put(num, 1);
            } else if (i > 2) {
            } else {
                i = i + 1;
                numMap.put(num, i);
            }
        }
        final ArrayList<Integer> numList = new ArrayList<>();
        numMap.entrySet().forEach(entry -> {
            Integer count = entry.getValue();
            final Integer num = entry.getKey();
            while (count > 0){
                count--;
                numList.add(num);
            }
        });
        final Integer[] ints = new Integer[numList.size()];

        final Integer[] array = numList.toArray(ints);

        Arrays.sort(array);
        final int length = nums.length;
        final List<List<Integer>> result = new ArrayList<>();
        int[][] cache = new int[length + 1][length + 1];
        int start = 0;
        int end = array.length - 1;
        handle(cache, array, result, start, end);
        return result.stream().distinct().collect(Collectors.toList());
    }

    private void handle(int[][] cache, Integer[] nums, List<List<Integer>> result, int start, int end) {
        final int i = cache[start][end];
        if (i == 1) {
            return;
        }
        cache[start][end] = 1;

        if (start >= end) {
            return;
        }
        final int firstValue = nums[start];
        final int secondValue = nums[end];
        if (firstValue > 0 || secondValue < 0) {
            return;
        }
        int target = -(firstValue + secondValue);

        int index = findMatchIndex(nums, target, start, end);
        if (index != -1) {
            result.add(Arrays.asList(firstValue, nums[index], secondValue));
            handle(cache, nums, result, ++start, end);
            handle(cache, nums, result, --start, --end);
        } else {
            handle(cache, nums, result, ++start, end);
            handle(cache, nums, result, --start, --end);
        }
    }

    private int findMatchIndex(Integer[] nums, int target, int start, int end) {
        int i = start + 1;
        while (i < end) {
            if (nums[i] == target) {
                return i;
            } else {
                i++;
            }
        }
        return -1;
    }
}
