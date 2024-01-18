package org.example.leetcode.easy;

/**
 * @author walker.dou
 */
public class Class520 {
    public static void main(String[] args) {
        final Class520 class520 = new Class520();
        System.out.println(class520.detectCapitalUse("Usa"));
    }

    public boolean detectCapitalUse(String word) {
        final int length = word.length();
        if (length == 1) {
            return true;
        }
        int lowerCaseCount = 0;
        int upperCaseCount = 0;
        for (int i = 0; i < word.length(); i++) {
            final char c = word.charAt(i);
            if (c >= 'a' && c <= 'z') {
                lowerCaseCount++;
            } else {
                upperCaseCount++;
            }
        }
        return lowerCaseCount == length || upperCaseCount == length || (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z' && upperCaseCount == 1 && lowerCaseCount == length - 1);
    }
}
