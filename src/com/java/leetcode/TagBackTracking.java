package com.java.leetcode;

import java.util.*;

public class TagBackTracking {

    // id 46
    // 标准回溯
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result_permute = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int[] visited = new int[nums.length];
        bt_permute(nums, path, visited, result_permute);
        return result_permute;
    }

    private void bt_permute(int[] nums, List<Integer> path, int[] visited, List<List<Integer>> result_permute) {
        if (path.size() == nums.length) {
            result_permute.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            // make choice
            path.add(nums[i]);
            visited[i] = 1;

            // back track
            bt_permute(nums, path, visited, result_permute);

            // withdraw choice
            path.remove(path.size() - 1);
            visited[i] = 0;
        }
    }

    // id 17
    Map<String, String> digitsMap = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    List<String> res = new ArrayList<>();
    StringBuilder tmp = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits == null) return null;
        bt_letterCombinations(digits, 0);
        return res;
    }

    private void bt_letterCombinations(String digits, int index) {
        if (index >= digits.length()) {
            res.add(tmp.toString());
            return;
        }
        String letter = digitsMap.get(digits.substring(index, index + 1));
        for (int i = 0; i < letter.length(); i++) {
            tmp.append(letter, i, i + 1);
            bt_letterCombinations(digits, index + 1);
            //去掉添加的字母，开始回溯
            tmp.replace(tmp.length() - 1, tmp.length(), "");
        }
    }

    // id 401
    // easy
    // 二进制手表
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        return null;
    }

    // id 78
    // medium
    // subset 子集
    public List<List<Integer>> subsets(int[] nums) {
        return null;
    }
}
