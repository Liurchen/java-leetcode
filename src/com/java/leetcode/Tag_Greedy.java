package com.java.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tag_Greedy {

    public int leastInterval(char[] tasks, int n) {
        List<Character> tasksCopy = new ArrayList<Character>();
        for (char task : tasks) {
            tasksCopy.add(task);
        }
        List<Character> runList = new ArrayList<>();
        runList.add(tasksCopy.remove(0));
        // 建立一个HashMap 贪心取时间最小的加入任务队列
        HashMap<Character, Integer> c2time = new HashMap<>();
        while (tasksCopy.size() > 0) {
            // 计算每个任务的时间 重复跳过

        }

        return 0;
    }
}
