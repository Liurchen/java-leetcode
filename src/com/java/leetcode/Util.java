package com.java.leetcode;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Util<T> {
    public static void print(int[] nums) {
        for (int i : nums) {
            System.out.println(i);
        }
    }

    public static void print(@NotNull List<Integer> nums) {
        for (Integer i : nums) {
            System.out.println(i);
        }
    }
}
