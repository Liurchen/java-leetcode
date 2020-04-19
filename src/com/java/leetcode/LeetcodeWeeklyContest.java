package com.java.leetcode;

import java.util.*;

public class LeetcodeWeeklyContest {

    // 周赛 185
    // ac
    public String reformat(String s) {
        if (s.length() == 1) return s;
        List<Character> alpha = new ArrayList<>();
        List<Character> digit = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLowerCase(s.charAt(i))) {
                alpha.add(s.charAt(i));
            } else {
                digit.add(s.charAt(i));
            }
        }
        if (alpha.size() == 0 || digit.size() == 0) return "";
        StringBuilder res = new StringBuilder();
        if (alpha.size() > digit.size()) {
            for (int i = 0; i < alpha.size(); i++) {
                res.append(alpha.get(i));
                if (i < digit.size()) {
                    res.append(digit.get(i));
                } else {
                    if (i < alpha.size() - 1) {
                        return "";
                    }
                }
            }
        } else {
            for (int i = 0; i < digit.size(); i++) {
                res.append(digit.get(i));
                if (i < alpha.size()) {
                    res.append(alpha.get(i));
                } else {
                    if (i < digit.size() - 1) {
                        return "";
                    }
                }
            }
        }

        return res.toString();
    }

    // ac
    public List<List<String>> displayTable(List<List<String>> orders) {
        if (orders.size() == 0) return new ArrayList<>();
        Map<String, Map<String, Integer>> map = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1) - Integer.parseInt(o2);
            }
        });
        Set<String> foods = new TreeSet<>();
        for (List<String> order : orders) {
            foods.add(order.get(order.size() - 1));
        }
        for (List<String> order : orders) {
            Map<String, Integer> tmp = new TreeMap<>();
            for (String food : foods) {
                tmp.put(food, 0);
            }
            map.put(order.get(1), tmp);
        }
        for (List<String> order : orders) {
            Map<String, Integer> tmp = map.get(order.get(1));
            tmp.put(order.get(2), tmp.get(order.get(2)) + 1);
        }
        List<List<String>> res = new ArrayList<>();
        List<String> res1 = new ArrayList<>();
        res1.add("Table");
        res1.addAll(foods);
        res.add(res1);
        for (Map.Entry<String, Map<String, Integer>> entry : map.entrySet()) {
            List<String> res2 = new ArrayList<>();
            res2.add(entry.getKey());
            for (Map.Entry<String, Integer> entr1 : entry.getValue().entrySet()) {
                res2.add(entr1.getValue().toString());
            }
            res.add(res2);
        }
        return res;
    }

    // wrong answer
    public int minNumberOfFrogs(String croakOfFrogs) {
        int len = croakOfFrogs.length();
        if (len % 5 != 0 || croakOfFrogs.charAt(0) != 'c' || croakOfFrogs.charAt(len - 1) != 'k') return -1;
        char[] ch = croakOfFrogs.toCharArray();
        int[] num = new int[127];
        int count = 1;
        for (char c : ch) {
            num[c]++;
            //如果数组不是非递增的，那么就是无效数据
            if (!(num['c'] >= num['r'] && num['r'] >= num['o'] && num['o'] >= num['a'] && num['a'] >= num['k']))
                return -1;
            //显然，当字符串为c时，青蛙数量才会增加
            if (c == 'c') {
                count = Math.max(count, num['c'] - num['k']);
            }
        }
        return count;
    }
}
