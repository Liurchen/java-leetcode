package com.java.leetcode;

import java.util.*;

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
    // id 53
    // 最大和连续子数组
    public int maxSubArray(int[] nums) {
        if (nums.length <= 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        int end = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            if (dp[i] > max) {
                max = dp[i];
                end = i;
            }
        }
        // 找出和最大的子序列
        // idea 从最大的索引开始
        // 倒序寻找 因为是连续的
        int start = end;
        while (max > 0) {
            max -= nums[start];
            start--;
        }
        System.out.println(start + 1);
        System.out.println(end);
        return dp[end];
    }

    // id 面试题 17.16
    public int massage(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[nums.length - 1];
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

    // id 62
    public int uniquePaths(int m, int n) {
        // 二维dp
        // dp[i][j]代表到达(i,j)所有路径的数目
        int[][] dp = new int[m][n];
        //状态转移方程 到达(i,j)有两种办法，一种是从(i-1,j)向右一步，一种是从(i,j-1)向下一步

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    // id 64
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if (col == 0) return 0;
        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0) {
                    if (j < 1) {
                        dp[i][j] = grid[i][j];
                    } else {
                        dp[i][j] = dp[i][j - 1] + grid[i][j];
                    }
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
                }
            }
        }
        return dp[row - 1][col - 1];
    }

    // id 338
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        for (int i = 0; i <= num / 2; i++) {
            dp[i * 2] = dp[i];
            if (i * 2 + 1 <= num)
                dp[i * 2 + 1] = dp[i] + 1;
        }
        return dp;
    }

    // id 647
    // 不会
    public int countSubstrings(String s) {
        int length = s.length();
        int[] dp = new int[length];
        int count = 0;

        for (int i = 0; i < length; i++) {
            dp[i] = 1;
            count++;
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j) && dp[j + 1] == 1) {
                    dp[j] = 1;
                    count++;
                } else {
                    dp[j] = 0;
                }
            }
        }
        return count;
    }

    // id 279
    // 不会
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int val = i;
            for (int j = 1; i - j * j >= 0; j++) {
                val = Math.min(val, dp[i - j * j] + 1);
            }
            dp[i] = val;
        }
        return dp[n];
    }

    // id 309
    // 不太会
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        //由于可以无限次交易，所以只定义两个维度，第一个维度是天数，第二个维度表示是否持有股票，0表示不持有，1表示持有，2表示过渡期
        int[][] dp = new int[prices.length][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {
            //第i天不持有股票的情况有两种
            //a.第i-1天也不持有股票
            //b.第i-1天是过渡期
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            //第i天持有股票有两种情况
            //a.第i-1天也持有股票，第i天不操作，
            //b.第i-1天不持有股票，在第i天买入
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            //第i天是冷冻期只有一种情况，第i-1天持有股票且卖出
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        //最后最大利润为最后一天，不持有股票或者进入冷冻期的情况
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][2]);
    }

    // id 509
    public int fib(int N) {
        if (N == 0) return 0;
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < N + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }

    // id 1137
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    // id 873
    public int lenLongestFibSubsequence(int[] A) {

        return 0;
    }

    // id 322 零钱兑换
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = amount + 1;
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }

    // id 面试题 08 11
    public int waysToChange(int n) {
        final int MOD = 1000000007;
        int[] dp = new int[n + 1];
        int[] coins = new int[]{1, 5, 10, 25};
        dp[0] = 1;
        // dp[i]代表 组成i面值的表示法数
        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                // dp[6] = dp[6] + dp[6-1] + dp[6-5]
                // dp[11] = dp[11] + dp[11-10] + dp[11-5] + dp[11-1]
                dp[i] += dp[i - coin];
                dp[i] %= MOD;
            }
        }
        return dp[n];
    }

    // id 120 三角形最小路径和
    public int minimumTotal(List<List<Integer>> triangle) {
        // dp[i][j] 代表什么
        return 0;
    }

    // id 面试题 10-II
    // 跳台阶
    public int numWays(int n) {
        if (n <= 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }

    // id 5 最长回文子串
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int len = 1;
        String ans = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else {
                    boolean eql = s.charAt(i) == s.charAt(j);
                    if (i == j - 1) {
                        dp[i][j] = eql;
                    } else {
                        dp[i][j] = eql && dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && len <= j - i + 1) {
                    len = j - i + 1;
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }

    public boolean isPalindrome(String s) {
        int mid = s.length() / 2;
        for (int i = 0; i < s.length(); i++) {
            int last = s.length() - 1 - i;
            if (i <= mid) {
                if (s.charAt(i) != s.charAt(last)) {
                    return false;
                }
            } else {
                break;
            }
        }
        return true;
    }

}
