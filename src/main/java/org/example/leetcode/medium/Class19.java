package org.example.leetcode.medium;

/**
 * @author walker.dou
 */
public class Class19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int target = count - n + 1;
        if (target == 1) {
            ListNode temp4 = head.next;
            head.next = null;
            head = temp4;
            return head;
        }
        int index = 1;
        ListNode temp2 = head;
        while (temp2 != null) {
            if ((index + 1) == target) {
                temp2.next = temp2.next.next;
                return head;
            } else {
                temp2 = temp2.next;
                index++;
            }
        }
        return head;
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
