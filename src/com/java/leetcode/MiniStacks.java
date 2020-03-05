package com.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MiniStacks<T> {

    private List<T> stack;

    public MiniStacks() {
        this.stack = new ArrayList<T>();
    }

    public T getTop() {
        if (this.size() > 0) {
            return this.stack.get(this.size() - 1);
        } else {
            return null;
        }
    }

    public void clearStack() {
        this.stack.clear();
    }

    public int size() {
        return this.stack.size();
    }

    public void push(T elem) {
        this.stack.add(elem);
    }

    public T pop() {
        if (this.size() > 0) {
            return this.stack.remove(this.size() - 1);
        } else {
            return null;
        }
    }

    public T getElem(int index) {
        if (this.size() >= index + 1) {
            return this.stack.get(this.size() - 1 - index);
        } else {
            return null;
        }
    }

    public void printStack() {
        for (int i = 0; i < this.size(); i++) {
            System.out.println(this.stack.get(i));
        }
    }
}
