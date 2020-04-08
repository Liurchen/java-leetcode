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

        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(0);
        TreeNode t6 = new TreeNode(8);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(4);

        root.left = t1;
        root.right = t2;

        t1.left = t3;
        t1.right = t4;

        t2.left = t5;
        t2.right = t6;

        t4.left = t7;
        t4.right = t8;

        binaryTree.lowestCommonAncestor(root, t1, t2);


    }
}



