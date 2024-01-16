package org.example.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author walker.dou
 */
public class Class205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        final Map<Character, Character> tempMap = new HashMap<>();
        final Map<Character, Character> reverseMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!tempMap.containsKey(s.charAt(i))) {
                if (reverseMap.containsKey(t.charAt(i))){
                    return false;
                }
                tempMap.put(s.charAt(i), t.charAt(i));
                reverseMap.put(t.charAt(i), s.charAt(i));
            } else {
                final Character character = tempMap.get(s.charAt(i));
                if (!character.equals(t.charAt(i))) {
                    return false;
                }

            }
        }
        return true;
    }
}
