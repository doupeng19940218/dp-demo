package org.example.leetcode.easy;

import org.jetbrains.annotations.NotNull;

/**
 * @author walker.dou
 */
public class Class1047 {

    public static void main(String[] args) {
        final Class1047 class1047 = new Class1047();
        System.out.println(class1047.removeDuplicates("aaaaaaaaa"));
    }

    /**
     * 理解错题目了，应该用栈写
     * 目前这种写法会超时，sad
     */

    public String removeDuplicates(String s) {
        boolean flag = true;
        while (flag) {
            final Model model = doRemove(s);
            flag = model.hasChanged;
            s = model.result;
        }
        return s;
    }

    private static Model doRemove(String s) {
        if (s.isEmpty()) {
            return new Model(false, s);
        }
        byte[] flag = new byte[s.length()];

        boolean hasChanged = false;
        for (int i = 1; i < s.length(); i++) {
            Character first = s.charAt(i - 1);
            Character second = s.charAt(i);
            if (second.equals(first)) {
                flag[i - 1] = 1;
                flag[i] = 1;
                hasChanged = true;
                i++;
            }
        }
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (flag[i] != 1) {
                stringBuilder.append(s.charAt(i));
            }
        }
        return new Model(hasChanged, stringBuilder.toString());
    }

    public static class Model {
        boolean hasChanged;
        String result;

        public Model(boolean hasChanged, String result) {
            this.hasChanged = hasChanged;
            this.result = result;
        }
    }
}
