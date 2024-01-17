package org.example.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author walker.dou
 */
public class Class860 {
    public static void main(String[] args) {
        int[] bills = {5, 5, 10, 10, 20};
        final Class860 class860 = new Class860();
        System.out.println(class860.lemonadeChange(bills));
    }

    // 20 10 5
    // 15 5 0
    public boolean lemonadeChange(int[] bills) {
        if (bills[0] == 10 || bills[0] == 20) {
            return false;
        }
        final List<Integer> cache = new ArrayList<>();
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                cache.add(5);
            } else if (bills[i] == 10) {
                cache.add(10);
                if (cache.contains(5)) {
                    cache.remove(new Integer(5));
                } else {
                    return false;
                }
            } else {
                //3个5 或者 1个10和1个5
                boolean flag;
                flag = cache.remove(new Integer(5));
                if (!flag) {
                    return false;
                }
                flag = cache.remove(new Integer(10));
                if (flag){
                    continue;
                }
                flag = cache.remove(new Integer(5));
                if (!flag) {
                    return false;
                }
                flag = cache.remove(new Integer(5));
                if (!flag) {
                    return false;
                }
//                treeSet.add(20);
            }
        }
        return true;
    }
}
