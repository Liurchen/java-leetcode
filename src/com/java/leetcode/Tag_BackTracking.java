package com.java.leetcode;

import java.util.*;

public class Tag_BackTracking {

    // id 46
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int[] visited = new int[nums.length];
        backtrack46(path, visited, result, nums);
        return result;
    }

    private void backtrack46(List<Integer> path, int[] visited, List<List<Integer>> result, int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            path.add(nums[i]);
            visited[i] = 1;
            backtrack46(path, visited, result, nums);
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
    List<String> res = new ArrayList<String>();
    StringBuilder tmp = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits == null) return null;
        process(digits, 0);
        return res;
    }

    private void process(String digits, int index) {
        if (index >= digits.length()) {
            res.add(tmp.toString());
            return;
        }
        String letter = digitsMap.get(digits.substring(index, index + 1));
        for (int i = 0; i < letter.length(); i++) {
            tmp.append(letter, i, i + 1);
            process(digits, index + 1);
            //去掉添加的字母，开始回溯
            tmp.replace(tmp.length() - 1, tmp.length(), "");
        }
    }

    // id 784
    // 我太菜了
    public List<String> letterCasePermutation(String S) {
        List<String> ret = new ArrayList<>();
        backtrack784(S.toCharArray(), ret, new StringBuilder(), 0);
        return ret;
    }

    private void backtrack784(char[] s, List<String> ret, StringBuilder sb, int i) {
        if (i == s.length) {
            ret.add(sb.toString());
            return;
        }
        char c = s[i];
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            sb.append(Character.toLowerCase(c));
            backtrack784(s, ret, sb, i + 1);
            sb.deleteCharAt(sb.length() - 1);

            sb.append(Character.toUpperCase(c));
            backtrack784(s, ret, sb, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(c);
            backtrack784(s, ret, sb, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // id 22
    // 好难
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder tmp = new StringBuilder();

        return result;
    }

    private void backtrack22() {
    }


}
