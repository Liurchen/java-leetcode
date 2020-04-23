package com.java.leetcode;

import java.util.HashMap;
import java.util.Map;

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

    // id 1342
    public int numberOfSteps(int num) {
        int step = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num >>= 1;
            } else {
                num -= 1;
            }
            step++;

        }
        return step;
    }

    // id 709
    public String toLowerCase(String str) {
        char[] ch = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            ch[i] = (char) (str.charAt(i) | 32);
        }
        StringBuilder res = new StringBuilder();
        for (char c : ch) {
            res.append(c);
        }
        return res.toString();
    }

    // id 面试题 01 02
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.equals("")) return true;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (!map1.containsKey(s1.charAt(i))) {
                map1.put(s1.charAt(i), 1);
            } else {
                map1.put(s1.charAt(i), map1.get(s1.charAt(i)) + 1);
            }
            if (!map2.containsKey(s2.charAt(i))) {
                map2.put(s2.charAt(i), 1);
            } else {
                map2.put(s2.charAt(i), map2.get(s2.charAt(i)) + 1);
            }
        }
        if (map1.size() != map2.size()) return false;
        for (Character key : map1.keySet()) {
            if (!map1.get(key).equals(map2.get(key))) return false;
        }
        return true;
    }
}
