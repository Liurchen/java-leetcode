package com.java.leetcode;

import java.util.Arrays;

public class Tag_DP {

    // id 70
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // id 198
    public int rob(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n == 0 ? 0 : nums[0];
        int[] memo = new int[n];
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++)
            memo[i] = Math.max(memo[i - 1], nums[i] + memo[i - 2]);
        return memo[n - 1];
    }

    // id 746
    public int minCostClimbingStairs(int[] cost) {
        //我是这样理解的,感觉比较好理解
        //dp数组的每一个元素表示到达当前楼层所需的最小花费
        //也就是dp的第i个值是不包含cost[i]的，因为还没从第i层走出去，没消耗体力
        //dp的长度=cost+1，dp的最后一个元素就是到达楼顶所需的最小花费
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;//因为最开始可以选择起点，而选择起点是不消耗体力的
        for (int i = 2; i < dp.length; i++) {
            //要么从第i-2层走到第i层，从要么第i-1层走到第i层
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }

        return dp[dp.length - 1];
    }

    // id 1025
    public boolean divisorGame(int N) {
        // 不会
        return false;
    }

    // id 面试题 42
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }
        Arrays.sort(dp);
        return dp[dp.length - 1];
    }

    // id 面试题 17.16
    public int massage(int[] nums) {
        
        return 0;
    }

    // id 面试题 08.01
    public int waysToStep(int n) {
        if (n <= 2) return n;
        long[] dp = new long[n];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000007;
        }

        return (int) dp[dp.length - 1];
    }

}