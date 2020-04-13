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

    // id 1009
    // 不会
    public int bitwiseComplement(int N) {
        int num = 1;
        while (num < N) {
            num = (num << 1) + 1;
        }
        return N ^ num;
    }

    // id 191
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>= 1;
        }
        return res;
    }

    // id 371
    // 不会 需要理解 + - 操作符如何实现
    public int getSum(int a, int b) {

        return 0;
    }
}
