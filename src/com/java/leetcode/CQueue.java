package com.java.leetcode;

import java.util.Stack;

// id 面试题 09
public class CQueue {

    private final Stack<Integer> s1;
    private final Stack<Integer> s2;

    public CQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void appendTail(int value) {
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        s1.push(value);
    }

    public int deleteHead() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        if (!s2.isEmpty()) {
            return s2.pop();
        } else {
            return -1;
        }
    }
}
