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

    // id 160
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

//         * 设链表A不公共部分为a,公共部分为c；链表B不公共部分为b，公共部分为c
//         * 即链表A：aaccc；链表B：bbbbbbbbbccc  （由题意可知c个数可能为0）
//         * 在headA处设一个flagA，让它沿着a->c->b移动
//         * 在headB处设一个flagB，让它沿着b->c->a移动
//         * 则有：a + b + c = b + c + a（其中由于A和B可能没有公共点，所以c可能为0）
//         * 所以当flagA == flagB时，此时的节点一定为公共点
//         *
//         * @param headA 链表A
//         * @param headB 链表B
//         * @return 相交的节点或null

        // 定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
        // 两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        // 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头
        // 而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    // id 203
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        if (head.next == null && head.val == val) return null;
        if (head.next == null) return head;
        ListNode p1 = head;
        ListNode p2 = new ListNode(0);
        p2.next = p1;
        ListNode newHead = p2;
        while (p1.next != null) {
            if (p1.val == val) {
                p2.next = p1.next;
                p1 = p2.next;
            } else {
                p2 = p1;
                p1 = p1.next;
            }
        }
        if (p1.val == val) {
            p2.next = null;
        }
        return newHead.next;
    }

    // id 237
    public void deleteNode(ListNode node) {
        ListNode p = node;
        while (node.next != null) {
            p = node;
            node.val = node.next.val;
            node = node.next;
        }
        p.next = null;
    }

    // id 876
    public ListNode middleNode(ListNode head) {
        
        return new ListNode(2);
    }
}
