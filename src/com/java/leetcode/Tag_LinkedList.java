package com.java.leetcode;

import java.util.HashMap;
import java.util.List;

public class Tag_LinkedList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode l3 = new ListNode(0);
        ListNode p3 = l3;
        boolean add = false;

        while (p1 != null && p2 != null) {
            int tmp = p1.val + p2.val;
            if (add) {
                tmp += 1;
                add = false;
            }
            if (tmp >= 10) {
                tmp = tmp - 10;
                add = true;
            }
            p3.val = tmp;
            if (p1.next == null && p2.next != null) {
                p1.next = new ListNode(0);
            } else if (p2.next == null && p1.next != null) {
                p2.next = new ListNode(0);
            }
            p1 = p1.next;
            p2 = p2.next;
            if (p1 != null) {
                p3.next = new ListNode(0);
                p3 = p3.next;
            } else if (add) {
                p3.next = new ListNode(1);
                add = false;
            }
        }

        return l3;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode l3 = new ListNode(0);

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p3 = l3;

        while (p1 != null || p2 != null) {
            if (p1 == null) {
                p3.val = p2.val;
                p2 = p2.next;
            } else if (p2 == null) {
                p3.val = p1.val;
                p1 = p1.next;
            } else {
                if (p1.val >= p2.val) {
                    p3.val = p2.val;
                    p2 = p2.next;
                } else {
                    p3.val = p1.val;
                    p1 = p1.next;
                }
            }
            if (p1 != null || p2 != null) {
                p3.next = new ListNode(0);
                p3 = p3.next;
            }
        }

        return l3;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode h = head;
        HashMap<Integer, ListNode> map = new HashMap<>();
        int idx = 0;
        while (h != null) {
            map.put(idx, h);
            idx++;
            h = h.next;
        }
        if (n > 0 && n < idx) {
            map.get(idx - n - 1).next = map.get(idx - n + 1);
        } else if (n == idx) {
            return head.next;
        }
        return head;
    }
}
