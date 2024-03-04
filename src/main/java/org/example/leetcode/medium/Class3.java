package org.example.leetcode.medium;

/**
 * @author walker.dou
 */
public class Class3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int max = 0, x = 0, y = 1;
        while (y < s.length()) {
            int equalIndex = equalIndex(s, x, y);
            if (equalIndex == -1) {
                max = Math.max(max, y - x + 1);
                y++;
            } else {
                x = equalIndex;
                max = Math.max(max, y - x + 1);
            }
        }
        return max;
    }

    private int equalIndex(String s, int x, int y) {
        final char c2 = s.charAt(y);
        for (; x < y; x++) {
            final char c1 = s.charAt(x);
            if (c1 == c2) {
                return ++x;
            }
        }
        return -1;
    }
}
