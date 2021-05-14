package com.java.leetcode;

import java.util.*;

public class Tag_LinkedList {

    public Def_ListNode addTwoNumbers(Def_ListNode l1, Def_ListNode l2) {
        Def_ListNode p1 = l1;
        Def_ListNode p2 = l2;
        Def_ListNode l3 = new Def_ListNode(0);
        Def_ListNode p3 = l3;
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
                p1.next = new Def_ListNode(0);
            } else if (p2.next == null && p1.next != null) {
                p2.next = new Def_ListNode(0);
            }
            p1 = p1.next;
            p2 = p2.next;
            if (p1 != null) {
                p3.next = new Def_ListNode(0);
                p3 = p3.next;
            } else if (add) {
                p3.next = new Def_ListNode(1);
                add = false;
            }
        }

        return l3;
    }

    // id 面试题 25
    // id 21
    public Def_ListNode mergeTwoLists(Def_ListNode l1, Def_ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        Def_ListNode l3 = new Def_ListNode(0);
        if (l1.val < l2.val) {
            l3.val = l1.val;
            l1 = l1.next;
        } else {
            l3.val = l2.val;
            l2 = l2.next;
        }
        Def_ListNode l3ptr = l3;
        while (l1 != null || l2 != null) {
            Def_ListNode tmp = new Def_ListNode(0);
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

    public Def_ListNode removeNthFromEnd(Def_ListNode head, int n) {
        Def_ListNode h = head;
        HashMap<Integer, Def_ListNode> map = new HashMap<>();
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

    // id 203
    public Def_ListNode removeElements(Def_ListNode head, int val) {
        if (head == null) return null;
        if (head.next == null && head.val == val) return null;
        if (head.next == null) return head;
        Def_ListNode p1 = head;
        Def_ListNode p2 = new Def_ListNode(0);
        p2.next = p1;
        Def_ListNode newHead = p2;
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
    public void deleteNode(Def_ListNode node) {
        Def_ListNode p = node;
        while (node.next != null) {
            p = node;
            node.val = node.next.val;
            node = node.next;
        }
        p.next = null;
    }

    // id 876
    public Def_ListNode middleNode(Def_ListNode head) {
        Def_ListNode fast = head;
        Def_ListNode slow = head;
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
    public Def_ListNode detectCycle(Def_ListNode head) {
        Def_ListNode fast = head;
        Def_ListNode slow = head;
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
    public int[] reversePrint(Def_ListNode head) {
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
    public int kthToLast(Def_ListNode head, int k) {
        Def_ListNode fast = head;
        Def_ListNode slow = head;
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
    public Def_ListNode reverseList(Def_ListNode head) {
        return reverseListRecursion(head);
    }

    // 不太懂递归的解法
    private Def_ListNode reverseListRecursion(Def_ListNode head) {
        if (head == null || head.next == null) return head;
        Def_ListNode node = reverseListRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    private Def_ListNode reverseListIteration(Def_ListNode head) {
        if (head == null) return null;
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        Def_ListNode res = new Def_ListNode(stack.pop());
        Def_ListNode copy = res;
        while (!stack.isEmpty()) {
            copy.next = new Def_ListNode(stack.pop());
            copy = copy.next;
        }
        return res;
    }

    // id 面试题 18
    // 删除链表的节点
    public Def_ListNode deleteNode(Def_ListNode head, int val) {
        Def_ListNode ptr = new Def_ListNode(-1);
        ptr.next = head;
        while (ptr.next != null) {
            if (ptr.next.val == val) {
                if (head.val == val) {
                    head = head.next;
                    break;
                }
                ptr.next = ptr.next.next;
                break;
            }
            ptr = ptr.next;
        }
        return head;
    }

    // id 面试题 52
    // id 160
    // 两个链表的第一个公共节点
    public Def_ListNode getIntersectionNode(Def_ListNode headA, Def_ListNode headB) {
        if (headA == null || headB == null) return null;
        Def_ListNode p1 = headA;
        Def_ListNode p2 = headB;
        while (p1 != null || p2 != null) {
            if (p1 == null) {
                p1 = headB;
            }
            if (p2 == null) {
                p2 = headA;
            }
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }

    public void printLinkedListReverse(Def_ListNode head) {
        if (head != null) {
            if (head.next != null) {
                printLinkedListReverse(head.next);
            }
            System.out.println(head.val);
        }
    }

    public Def_ListNode reverseList(Def_ListNode head) {
        if (head == null || head.next == null) return head;
        Def_ListNode newHead = reverseList(head.next);
        newHead.next = head;
        head.next = null;
        return newHead;
    }

}
