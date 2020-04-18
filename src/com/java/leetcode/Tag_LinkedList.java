package com.java.leetcode;

import java.util.*;

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

    // id 面试题 25
    // id 21
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode l3 = new ListNode(0);
        if (l1.val < l2.val) {
            l3.val = l1.val;
            l1 = l1.next;
        } else {
            l3.val = l2.val;
            l2 = l2.next;
        }
        ListNode l3ptr = l3;
        while (l1 != null || l2 != null) {
            ListNode tmp = new ListNode(0);
            if (l1 == null) {
                tmp.val = l2.val;
                l2 = l2.next;
                l3ptr.next = tmp;
                l3ptr = l3ptr.next;
                continue;
            }
            if (l2 == null) {
                tmp.val = l1.val;
                l1 = l1.next;
                l3ptr.next = tmp;
                l3ptr = l3ptr.next;
                continue;
            }
            if (l1.val < l2.val) {
                tmp.val = l1.val;
                l1 = l1.next;
            } else {
                tmp.val = l2.val;
                l2 = l2.next;
            }
            l3ptr.next = tmp;
            l3ptr = l3ptr.next;
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
            assert head != null;
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
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null) {
            if (fast.next.next != null) {
                fast = fast.next.next;
            } else {
                fast = fast.next;
            }
            slow = slow.next;
        }
        return slow;
    }

    // id 142
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (slow != null && slow.next != null) {
                slow = slow.next;
            } else {
                return null;
            }
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                fast = head;
                break;
            }
        }
        if (slow == fast) {
            return slow;
        }
        while (true) {
            slow = slow.next;
            fast = fast.next;
            if (slow == fast) {
                return slow;
            }
        }
    }

    // id 面试题06
    public int[] reversePrint(ListNode head) {
        Stack<Integer> s = new Stack<>();
        while (head != null) {
            s.push(head.val);
            head = head.next;
        }
        int[] res = new int[s.size()];
        int i = 0;
        while (!s.isEmpty()) {
            res[i] = s.pop();
            i++;
        }
        return res;
    }

    // id 面试题 02.02
    public int kthToLast(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            k--;
            if (k < 0) {
                slow = slow.next;
            }
        }
        assert slow != null;
        return slow.val;
    }

    // id 面试题 24
    // id 206
    // 反转链表
    public ListNode reverseList(ListNode head) {
        return reverseListRecursion(head);
    }

    // 不太懂递归的解法
    private ListNode reverseListRecursion(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = reverseListRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    private ListNode reverseListIteration(ListNode head) {
        if (head == null) return null;
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        ListNode res = new ListNode(stack.pop());
        ListNode copy = res;
        while (!stack.isEmpty()) {
            copy.next = new ListNode(stack.pop());
            copy = copy.next;
        }
        return res;
    }
}
