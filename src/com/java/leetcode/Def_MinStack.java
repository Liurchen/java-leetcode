package com.java.leetcode;

class Def_MinStack {

    private Def_ListNode head;
    private Def_ListNode tail;
    private Def_ListNode min;

    /**
     * initialize your data structure here.
     */
    public Def_MinStack() {

    }

    public void push(int x) {
        Def_ListNode tmp = new Def_ListNode(x);
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
