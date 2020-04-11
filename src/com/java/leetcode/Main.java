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
        Tag_DFS dfs = new Tag_DFS();

        TreeNode p1 = new TreeNode(3);
        TreeNode p2 = new TreeNode(9);
        TreeNode p3 = new TreeNode(20);
        TreeNode p4 = new TreeNode(15);
        TreeNode p5 = new TreeNode(7);

        p2.left = p5;
        p2.right = p3;
        p5.left = p1;
        p3.left = p4;

        binaryTree.findMode(p2);
    }
}



