package org.example.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author walker.dou
 */
public class Class771 {
    /**
     * 输入：jewels = "aA", stones = "aAAbbbb"
     * 输出：3
     */
    public int numJewelsInStones(String jewels, String stones) {
        final Set<Character> cache = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            cache.add(jewels.charAt(i));
        }
        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            final char c = stones.charAt(i);
            if (cache.contains(c)){
                count++;
            }
        }
        return count;
    }
}
