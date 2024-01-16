package org.example.leetcode.easy;

/**
 * @author walker.dou
 */
public class Class28 {
    public static void main(String[] args) {
        final Class28 class28 = new Class28();
        System.out.println(class28.strStr("mississippi", "issipi"));
    }

    /**
     * 输入：haystack = "sadbutsad", needle = "sad"
     * 输出：0
     * 解释："sad" 在下标 0 和 6 处匹配。
     * 第一个匹配项的下标是 0 ，所以返回 0
     *
     * @link https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/
     */
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int x = 0; x < haystack.length() - needle.length() + 1; x++) {
            for (int y = 0; y < needle.length(); y++) {
                if (haystack.charAt(x + y) != needle.charAt(y)) {
                    break;
                } else if (y == needle.length() - 1) {
                    return x;
                }
            }
        }
        return -1;
    }
}
