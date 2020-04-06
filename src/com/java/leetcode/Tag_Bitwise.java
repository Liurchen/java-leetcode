package com.java.leetcode;

public class Tag_Bitwise {

    public int countOne(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }

    // id 137
    public int singleNumber(int[] nums) {
        // 真jr难
        return 0;
    }

    // id 461
    public int hammingDistance(int x, int y) {
        // idea xor then count 1
        int n = x ^ y;
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }
}
