package org.example.leetcode.medium;

/**
 * @author walker.dou
 */
public class Class2 {
    public static void main(String[] args) {
        final ListNode listNode = new ListNode(8);
        final ListNode listNode1 = new ListNode(9);
        listNode.next = listNode1;

        final ListNode listNode2 = new ListNode(9);
//        final ListNode listNode3 = new ListNode(1);
//        listNode2.next = listNode3;
        final Class2 class2 = new Class2();
        final ListNode listNode4 = class2.addTwoNumbers(listNode, listNode2);
        System.out.println(listNode4);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int moreThan9 = 0;
        boolean firstLoop = true;

        ListNode result = null;
        ListNode firstNode = null;

        while (l1 != null || l2 != null) {
            int first = 0;
            if (l1 != null) {
                first = l1.val;
                l1 = l1.next;
            }
            int second = 0;
            if (l2 != null) {
                second = l2.val;
                l2 = l2.next;
            }
            int i = first + second + moreThan9;
            if (i > 9) {
                moreThan9 = 1;
                i = i % 10;
            } else {
                moreThan9 = 0;
            }

            ListNode temp = new ListNode(i);
            if (firstLoop) {
                firstNode = result = temp;
                firstLoop = false;
            } else {
                result.next = temp;
                result = result.next;
            }
        }
        if (moreThan9 == 1) {
            result.next =  new ListNode(1);
        }
        return firstNode;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
