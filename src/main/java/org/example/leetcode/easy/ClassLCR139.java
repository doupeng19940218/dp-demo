package org.example.leetcode.easy;

/**
 * @author walker.dou
 */
public class ClassLCR139 {
    /**
     * 输入：actions = [1,2,3,4,5]
     * 输出：[1,3,5,2,4]
     * 解释：为正确答案之一
     */
    public int[] trainingPlan(int[] actions) {
        if (actions.length == 0) {
            return actions;
        }
        int start = 0;
        int end = actions.length - 1;
        while (start != end) {
            if (actions[start] % 2 == 0) {
                int temp = actions[end];
                actions[end] = actions[start];
                actions[start] = temp;
                end--;
            } else {
                start++;
            }
        }
        return actions;
    }
}
