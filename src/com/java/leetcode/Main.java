package com.java.leetcode;

import com.sun.source.tree.Tree;

import java.util.*;

import com.ja.leetcode.Son;

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
        Tag_BFS bfs = new Tag_BFS();
        Tag_Interview interview = new Tag_Interview();
        Tag_Sort sort = new Tag_Sort();
        LeetcodeWeeklyContest contest = new LeetcodeWeeklyContest();
        LRUCache cache = new LRUCache(2);

//        List<Integer> r1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
//        List<Integer> r2 = new ArrayList<>(Arrays.asList(6, 7));
//        List<Integer> r3 = new ArrayList<>(Collections.singletonList(8));
//        List<Integer> r4 = new ArrayList<>(Arrays.asList(9, 10, 11));
//        List<Integer> r5 = new ArrayList<>(Arrays.asList(12, 13, 14, 15, 16));
//        List<List<Integer>> matrix = new ArrayList<>();
//        matrix.add(r1);
//        matrix.add(r2);
//        matrix.add(r3);
//        matrix.add(r4);
//        matrix.add(r5);
//        contest.findDiagonalOrder(matrix);

        contest.maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3);

        Son s = new Son();
        System.out.println(s.a);
    }
}



