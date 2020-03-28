package com.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Tag_Greedy {

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
            tasksCopy.remove(tasksCopy.indexOf(minTime));
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
    // TBD
    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0) return 0;
        if (g.length == 0) return 0;
        Arrays.sort(g);
        int sum = 0;
        int idx = 0;
        for (int num : s) {
            if (idx == g.length) {
                return idx;
            }
            if (num < g[idx]) {
                return idx;
            } else {
                idx++;
            }
        }
        return idx;
    }
}
