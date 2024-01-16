package org.example.leetcode.easy;

/**
 * @author walker.dou
 */
public class Class392 {
    /**
     * 输入：s = "abc", t = "ahbgdc"
     * 输出：true
     */
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int y = 0;
        for (int x = 0; x < s.length(); x++) {

            for (; y < t.length(); y++) {
                if (s.charAt(x) == t.charAt(y)) {
                    if (x == s.length() - 1) {
                        return true;
                    }
                    y++;
                    break;
                }
                if (y == t.length() - 1) {
                    return false;
                }

            }
        }
        return false;
    }
}
