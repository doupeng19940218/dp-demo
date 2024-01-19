package org.example.leetcode.easy;

import java.util.Arrays;
import java.util.Map;

/**
 * @author walker.dou
 */
public class Class1046 {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1){
            return stones[0];
        }
        Arrays.sort(stones);
        while (stones[stones.length - 2] != 0){
            int first = stones[stones.length - 1];
            int second =  stones[stones.length - 2];
            final int left = Math.abs(first - second);
            stones[stones.length - 1] = left;
            stones[stones.length - 2] = 0;
            Arrays.sort(stones);
        }
        return stones[stones.length - 1];
    }
}
