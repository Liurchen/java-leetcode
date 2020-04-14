package com.java.leetcode;

import java.util.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Tag_Array array = new Tag_Array();
        Tag_LinkedList linkedList = new Tag_LinkedList();
        Tag_Queue queue = new Tag_Queue();
        Tag_Stack stack = new Tag_Stack();
        Tag_Greedy greedy = new Tag_Greedy();
        Tag_String str = new Tag_String();
        Tag_Math math = new Tag_Math();
        Tag_DP dp = new Tag_DP();
        Tag_Bitwise bit = new Tag_Bitwise();
        Tag_BinarySearch binarySearch = new Tag_BinarySearch();
        Tag_BackTracking backTracking = new Tag_BackTracking();
        Tag_BinaryTree binaryTree = new Tag_BinaryTree();
        Tag_DFS dfs = new Tag_DFS();

        ListNode p1 = new ListNode(7);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(4);
        ListNode p4 = new ListNode(3);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;

        ListNode p5 = new ListNode(5);
        ListNode p6 = new ListNode(6);
        ListNode p7 = new ListNode(4);
        p5.next = p6;
        p6.next = p7;

        stack.addTwoNumbers(p1, p5);

    }
}



