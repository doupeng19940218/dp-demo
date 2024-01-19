package org.example.leetcode.easy;

/**
 * @author walker.dou
 */
public class Class434 {
    public int countSegments(String s) {
        int count = 0;
        boolean previousSpace = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                previousSpace = true;
            } else {
                if (previousSpace){
                    count++;
                    previousSpace = false;
                }
            }
        }
        return count;
    }
}
