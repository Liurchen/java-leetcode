package com.java.leetcode;

import java.util.Locale;
import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        Tag_Array a = new Tag_Array();
        Tag_LinkedList l = new Tag_LinkedList();
        Tag_Queue q = new Tag_Queue();
        Tag_Stack s = new Tag_Stack();
        Tag_Greedy g = new Tag_Greedy();

        int[] arr = new int[]{1, 2, 5, 9, 5, 9, 5, 5, 5};
        a.majorityElement(arr);
    }
}



