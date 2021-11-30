package com.java.leetcode;

public class TagQueue {

    public int getKthMagicNumber(int k) {
        if (k <= 0) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        int pow = (k - 1) / 3;
        int ord = (k - 1) % 3;
        if (ord == 0) {
            pow -= 1;
            ord = 3;
        }
        int[] prime = {3, 5, 7};
        return prime[ord - 1] * (int) Math.pow(3, pow);
    }
}
