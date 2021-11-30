package com.java.leetcode;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        TagArray array = new TagArray();
        TagLinkedList linkedList = new TagLinkedList();
        TagQueue queue = new TagQueue();
        TagStack stack = new TagStack();
        TagGreedy greedy = new TagGreedy();
        TagString str = new TagString();
        TagMath math = new TagMath();
        TagDP dp = new TagDP();
        TagBitwise bit = new TagBitwise();
        TagBinarySearch binarySearch = new TagBinarySearch();
        TagBackTracking backTracking = new TagBackTracking();
        TagBinaryTree binaryTree = new TagBinaryTree();
        TagDFS dfs = new TagDFS();
        TagBFS bfs = new TagBFS();
        TagSort sort = new TagSort();
        LeetcodeWeeklyContest contest = new LeetcodeWeeklyContest();
        LRUCache cache = new LRUCache(2);
        TagHashmap hashmap = new TagHashmap();

        Class<?> c1 = Class.forName("com.java.leetcode.User");
        Class<?> c2 = Class.forName("com.java.leetcode.User");
        Class<?> c3 = Class.forName("com.java.leetcode.User");

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());

    }
}

