package com.java.leetcode;

public class TagHashmap {
    // id 560 和为 k 的子数组
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = k;
            int j = i;
            while (j < nums.length) {
                tmp -= nums[j];
                if (tmp == 0) {
                    ans++;
                    int idx = j + 1;
                    while (idx < nums.length) {
                        if (nums[idx] == 0) ans++;
                        idx++;
                    }
                    break;
                }
                j++;
            }
        }
        return ans;
    }
}
