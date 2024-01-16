package org.example.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author walker.dou
 */
public class Class118 {

    public static void main(String[] args) {

    }

    /**
     * 输入: numRows = 5
     * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
     */
    public List<List<Integer>> generate(int numRows) {
        final List<List<Integer>> result = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                final List<Integer> temp = new ArrayList<>();
                temp.add(1);
                result.add(temp);
            } else if (i == 1) {
                final List<Integer> temp = new ArrayList<>();
                temp.add(1);
                temp.add(1);
                result.add(temp);
            } else {
                final List<Integer> temp = new ArrayList<>();
                final List<Integer> lastLayer = result.get(i - 1);
                for (int j = 0; j <= i; j++) {
                    if (j == 0) {
                        temp.add(1);
                    } else if (j == i) {
                        temp.add(1);
                    } else {
                        temp.add(lastLayer.get(j - 1) + lastLayer.get(j));
                    }
                }
                result.add(temp);
            }
        }
        return result;
    }
}
