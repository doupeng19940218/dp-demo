package org.example.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author walker.dou
 */
public class Class290 {

    /**
     * 输入: pattern = "abba", s = "dog cat cat dog"
     * 输出: true
     */
    public boolean wordPattern(String pattern, String s) {
        final Map<Character, String> cache = new HashMap<>();
        final String[] aims = s.split(" ");
        if (aims.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            final char c = pattern.charAt(i);
            if (!cache.containsKey(c)) {
                final boolean hasValue = cache.containsValue(aims[i]);
                if (hasValue) {
                    return false;
                }
                cache.put(c, aims[i]);
            } else {
                final String s1 = cache.get(c);
                if (!s1.equals(aims[i])) {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean wordPattern2(String pattern, String s) {
        List<String> strList = Arrays.asList(s.split(" "));
        if (pattern.length() != strList.size()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.indexOf(pattern.charAt(i)) != strList.indexOf(strList.get(i))) {
                return false;
            }
        }
        return true;
    }


}
