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

    // id 633
    public boolean judgeSquareSum(int c) {
        //这里强制类型转换，做一个截断
        int i = 0, j = (int) Math.sqrt(c);
        while (i <= j) {
            int sum = i * i + j * j;
            if (sum < c) {
                i++;
            } else if (sum > c) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }

    // id 面试题 16.05
    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }

    // id 292
    public boolean canWinNim(int n) {
        // 巴什博弈问题
        // 如果n%(m+1)等于0 那么必然后手获胜
        // 否则先手获胜
        return n % 4 != 0;
    }

    // id 面试题 64
    // 不能用乘除法
    // 用递归
    public int sumNums(int n) {
        if (n == 1) return n;
        return n + sumNums(n - 1);
    }
}
