package org.example.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author walker.dou
 */
public class Class78 {
    public static void main(String[] args) {
        int[] nums = {1,2};
        final Class78 class78 = new Class78();
        final List<List<Integer>> subsets = class78.subsets(nums);
        System.out.println(subsets);
    }

//    public List<List<Integer>> subsets(int[] nums) {
//        return collect(nums, 0);
//    }
//
//    public List<List<Integer>> collect(int[] nums, int index) {
//        final List<List<Integer>> result = new ArrayList<>();
//        if (nums.length == index) {
//            final List<Integer> empty = new ArrayList<>();
//            result.add(empty);
//            return result;
//        }
//        final int num = nums[index];
//        final List<List<Integer>> collect = collect(nums, ++index);
//        final List<List<Integer>> temp = new ArrayList<>();
//        collect.forEach(a -> {
//            final List<Integer> collect1 = new ArrayList<>(a);
//            temp.add(collect1);
//        });
//
//        result.addAll(temp);
//
//        collect.forEach(a -> a.add(num));
//        result.addAll(collect);
//        return result;
//    }



    List<List<Integer>> ret = new ArrayList<>();
    List<Integer> item = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        back(nums,0);
        return ret;
    }
    public void back(int[] nums,int index){
        ret.add(new ArrayList<>(item));
        for(int i = index;i < nums.length;i++){
            item.add(nums[i]);
            back(nums,i + 1);
            item.remove(item.size() - 1);
        }
    }
}
