package com.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TagGreedy {

    public int leastInterval(char[] tasks, int n) {
        int totalTime = 0;
        // copy tasks
        List<Character> tasksCopy = new ArrayList<Character>();
        for (char task : tasks) {
            tasksCopy.add(task);
        }
        // 执行的任务队列
        List<Character> runList = new ArrayList<>();
        // 先执行第一个任务
        runList.add(tasksCopy.remove(0));
        totalTime++;


        while (tasksCopy.size() > 0) {
            // 计算每个任务的时间 hashMap保证了无重复计数
            int time = 1;
            // 建立一个HashMap 贪心取时间最小的任务加入任务队列
            HashMap<Character, Integer> c2time = new HashMap<>();
            // 初始化
            for (char task : tasksCopy) {
                c2time.putIfAbsent(task, -1);
            }

            for (char task : tasksCopy) {
                if (c2time.get(task) != -1) {
                    continue;
                }
                for (int i = 1; i < n + 1; i++) {
                    if (i > runList.size()) continue;
                    if (runList.get(runList.size() - i).equals(task)) {
                        time += n + 1 - i;
                        c2time.put(task, time);
                        time = 1;
                    }
                }
                if (c2time.get(task) == -1) {
                    c2time.put(task, time);
                }
            }
            // 选一个时间最小的
            char minTime = c2time.keySet().iterator().next();
            for (char task : c2time.keySet()) {
                if (c2time.get(task) < c2time.get(minTime)) {
                    minTime = task;
                }
            }
            for (int i = 0; i < c2time.get(minTime) - 1; i++) {
                runList.add('1');
            }
            tasksCopy.remove(minTime);
            runList.add(minTime);
            totalTime += c2time.get(minTime);
        }

        System.out.println(totalTime);
        return totalTime;
    }

    // id 392
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            while (idx < t.length()) {
                if (t.charAt(idx) == s.charAt(i)) {
                    System.out.printf("idx is %d, t is %c   ", idx, t.charAt(idx));
                    System.out.printf("i is %d, s is %c\n", i, s.charAt(i));
                    if (i == s.length() - 1) {
                        return true;
                    }
                    idx++;
                    break;
                }
                idx++;
            }
        }
        return false;
    }

    // id 455
    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0) return 0;
        if (g.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        int cnt = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                j++;
                cnt++;
                i++;
            } else {
                j++;
            }
        }
        return cnt;
    }

    // id 55
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        if (nums.length == 2) return nums[0] != 0;
        // idea 倒着走
        int i = nums.length - 1;
        int p = nums.length - 2;
        while (i > 0) {
            if (p < 0) return false;
            if (nums[p] >= i - p) {
                i = p;
            }
            p--;
        }
        return true;
    }

    // id 1221
    public int balancedStringSplit(String s) {
        int cnt = 0;
        if (s.length() <= 1) return 0;
        int numL = 0;
        int numR = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                numL++;
            } else {
                numR++;
            }
            if (numL == numR) {
                cnt++;
                numL = 0;
                numR = 0;
            }
        }
        return cnt;
    }

    // id 1403
    public List<Integer> minSubsequence(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int idx = nums.length - 1;
        int subSum = 0;
        while (sum >= subSum) {
            sum -= nums[idx];
            subSum += nums[idx];
            res.add(nums[idx]);
            idx--;
        }
        return res;
    }

    // id 1217
    public int minCostToMoveChips(int[] chips) {
        // 因为奇数移动到奇数，偶数移动到偶数，都是没有代价的
        // 所以代价就是奇数移动到偶数的次数
        // 比如有5对奇数，6对偶数，那最小的代价就是把5对奇数移动到偶数
        int odd = 0, even = 0;
        for (int chip : chips) {
            if (chip % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(even, odd);
    }
}
