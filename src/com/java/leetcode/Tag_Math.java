package com.java.leetcode;

public class Tag_Math {

    public int mySqrt(int x) {
        if (x <= 1) return x;
        int res = x;
        while (res > x / res) {
            res = (res + x / res) / 2;
        }
        System.out.println(res);
        return (int) res;
    }

    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }

    public int arrangeCoins(int n) {
        if (n == 1) return n;
        int k = 1;
        while ((k + Math.pow(k, 2)) / 2 < n) {
            k++;
        }
        if ((k + Math.pow(k, 2)) / 2 == n) {
            k++;
        }
        return k - 1;
    }

    public boolean checkPerfectNumber(int num) {
        if (num == 0) return false;
        int a = num, i = 1;
        while (i <= a / 2) {
            if (a % i == 0)
                num -= i;
            i++;
        }
        return num == 0;
    }
}
