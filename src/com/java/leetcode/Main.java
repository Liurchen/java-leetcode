package com.java.leetcode;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {

        Tag_Array array = new Tag_Array();
        Tag_LinkedList linkedList = new Tag_LinkedList();
        Tag_Queue queue = new Tag_Queue();
        Tag_Stack stack = new Tag_Stack();
        Tag_Greedy greedy = new Tag_Greedy();
        Tag_String str = new Tag_String();
        Tag_Math math = new Tag_Math();
        Tag_DP dp = new Tag_DP();
        Tag_Bitwise bit = new Tag_Bitwise();
        Tag_Binary binary = new Tag_Binary();
        Tag_BackTracking backTracking = new Tag_BackTracking();
        Tag_BinaryTree binaryTree = new Tag_BinaryTree();

        TreeNode r = new TreeNode(1);
        TreeNode r1 = new TreeNode(2);
        TreeNode r2 = new TreeNode(3);
        TreeNode r3 = new TreeNode(4);
        TreeNode r4 = new TreeNode(5);

        r.left = r1;
        r.right = r2;

        r1.left = r3;
        r1.right = r4;

        System.out.println(binaryTree.levelOrder_32_3(r));


    }
}



