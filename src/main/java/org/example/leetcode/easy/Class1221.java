package org.example.leetcode.easy;

/**
 * @author walker.dou
 */
public class Class1221 {
    /**
     * 输入：s = "RLRRLLRLRL"
     * 输出：4
     * 解释：s 可以分割为 "RL"、"RRLL"、"RL"、"RL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
     */
    public static void main(String[] args) {

    }

    public int balancedStringSplit(String s) {
        int count = 0;
        int start = 0;
        int end = 0;
        char curr = 0;
        int charCount = 0;
        for (int i = 0; i < s.length(); i++) {
            final char c1 = s.charAt(i);
            if (charCount == 0) {
                end++;
                charCount++;
                curr = c1;
            } else if (curr == c1) {
                end++;
                charCount++;
//                curr = c1;
            } else {
                start ++ ;
                end++;
                charCount --;
                if (charCount == 0){
                    count++;
                    curr = 0;
                }
            }

        }
        return count;

    }
}
