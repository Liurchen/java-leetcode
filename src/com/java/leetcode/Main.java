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
        Tag_String str = new Tag_String();
        Tag_Math m = new Tag_Math();

        int n = 5;
        System.out.println(m.arrangeCoins(n));
    }
}



