package org.example.leetcode.easy;

/**
 * @author walker.dou
 */
public class Class415 {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        final int length1 = num1.length();
        final int length2 = num2.length();
        int dif = Math.abs(length1 - length2);
        if (length1 < length2) {
            for (int i = 0; i < dif; i++) {
                num1 = "0" + num1;
            }
        } else if (length1 > length2) {
            for (int i = 0; i < dif; i++) {
                num2 = "0" + num2;
            }
        }
        boolean carry = false;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int first = num1.charAt(i) - '0';
            int second = num2.charAt(i) - '0';
            int temp = first + second + (carry ? 1 : 0);
            if (temp >= 10) {
                sb.append((temp % 10));
                carry = true;
            } else {
                sb.append(temp);
                carry = false;
            }
        }
        if (carry) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        int n = 1;
        char ch = (char) (n + '0');

        char ch2 = '9';
        int n2 = ch2 - '0';

        System.out.println(ch);
        System.out.println(n2);
    }

}
