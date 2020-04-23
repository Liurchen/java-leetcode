package com.java.leetcode;

class MinStack {

    private ListNode head;
    private ListNode tail;
    private ListNode min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        ListNode tmp = new ListNode(x);
        if (head != null) {
            head.next = tmp;
        }
        head = tmp;
    }

    public void pop() {

    }

    public int top() {
        return 0;
    }

    public int min() {
        return 0;
    }
}
