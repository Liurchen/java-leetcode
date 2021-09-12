package com.java.leetcode;

import java.util.List;

public class Util<T> {
    public static void print(int[] nums) {
        for (int i : nums) {
            System.out.println(i);
        }
    }

    public static void print(List<Integer> nums) {
        for (Integer i : nums) {
            System.out.println(i);
        }
    }
}
