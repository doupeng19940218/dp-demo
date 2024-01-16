package org.example.leetcode;

public class Class206 {
    public static void main(String[] args) {
        Class206 class206 = new Class206();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        class206.reverseList(listNode1);

    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode temp;
        ListNode lastHead = head;

        while (next != null) {
            temp = next.next;
            next.next = head;
            head = next;
            next = temp;
        }
        lastHead.next = null;
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
