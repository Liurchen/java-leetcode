package com.java.leetcode;

import java.util.*;

public class Tag_String {

    public String replaceSpace(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                s = s.substring(0, i) + "%20" + s.substring(i + 1, s.length());
            }
        }
        return s;
    }

    public int countSegments(String s) {
        return s.split(" ").length;
    }

    // id 443
    public int compress(char[] chars) {
        if (chars.length == 0) return 0;
        if (chars.length == 1) return 2;
        List<List<Character>> arr = new ArrayList<>();
        List<Character> tmp = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (i != 0) {
                if (tmp.get(tmp.size() - 1) == chars[i]) {
                    tmp.add(chars[i]);
                } else {
                    List<Character> copy = new ArrayList<>(tmp);
                    arr.add(copy);
                    tmp.clear();
                    tmp.add(chars[i]);
                }
            } else {
                tmp.add(chars[i]);
            }
        }
        arr.add(tmp);
        char[] res = new char[2 * arr.size()];
        int i = 0;
        for (List<Character> l : arr) {
            res[i] = l.get(0);
            String num = String.valueOf(l.size());
            char[] tmpNum = num.toCharArray();
            res[i + 1] = tmpNum[0];
            i += 2;
        }
        chars = res;
        return chars.length;
    }

    // id 151
    public String reverseWords(String s) {
        if (s.length() <= 1) return s;
        StringBuilder res = new StringBuilder();
        String[] S = s.split(" ");
        Stack<String> stack = new Stack<>();
        for (String str : S) {
            if (!str.equals("")) {
                stack.push(str);
            }
        }
        while (!stack.isEmpty()) {
            res.append(stack.pop());
            res.append(" ");
        }
        System.out.println(res.toString().trim());
        return res.toString().trim();
    }

    // id 1108
    public String invalidIPAddr(String address) {
        return address.replace(".", "[.]");
    }

    // id 557
    public String reverseWords_2(String s) {
        if (s.length() == 0) return "";
        if (s.equals(" ")) return "";
        String[] S = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String str : S) {
            Stack<Character> tmp = new Stack<>();
            StringBuilder stmp = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                tmp.push(str.charAt(i));
            }
            while (!tmp.isEmpty()) {
                stmp.append(tmp.pop());
            }
            res.append(stmp.toString());
            res.append(" ");
        }
        return res.toString().trim();
    }

    // id 412
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        int i = 1;
        while (i <= n) {
            if (i % 3 == 0 && i % 5 != 0) {
                res.add("Fizz");
            } else if (i % 5 == 0 && i % 3 != 0) {
                res.add("Buzz");
            } else if (i % 3 == 0) {
                res.add("FizzBuzz");
            } else {
                res.add(Integer.valueOf(i).toString());
            }
            i++;
        }
        return res;
    }

    // id 面试题 58-II
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    // id 3
    // id 面试题 48
    // 无重复最长字串
    // 优化一下 使用hashmap
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();
        int len = 1;
        int start = 0;
        int end = 1;
        if (s.charAt(start) != s.charAt(end)) {
            len++;
            end++;
        } else {
            start++;
        }
        while (end < s.length()) {
            int pos = s.substring(start, end).indexOf(s.substring(end, end + 1));
            if (pos == -1) {
                end++;
                len = Math.max(len, end - start);
            } else {
                start = pos + 1 + start;
                end = start + 1;
            }
        }
        return len;
    }

    // id 451
    // 字符出现的频率排序
    public String frequencySort(String s) {
        int[] chs = new int[127];
        for (char ch : s.toCharArray()) {
            chs[ch]++;
        }
        int maxCount = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            //记录出现最大次数的索引位置
            int idx = 0;
            for (int i = 0; i < 127; i++) {
                if (chs[i] > maxCount) {
                    maxCount = chs[i];
                    idx = i;
                }
            }
            //如果全部为 0，那么表示添加完毕，退出循环
            if (maxCount == 0) {
                break;
            }
            //次数置 0
            chs[idx] = 0;
            //索引位置同时也是字符大小，因此直接转为 (char) 即可
            while (maxCount-- > 0) {
                sb.append((char) idx);
            }
            maxCount = 0;
        }
        return sb.toString();
    }

    // id 面试题 01 06
    // 滑动窗口
    public String compressString(String S) {
        if (S.equals("")) return "";
        if (S.length() == 1) return S;
        int head = 0, tail = 0;
        StringBuilder sb = new StringBuilder();
        while (head < S.length()) {
            char tmp = S.charAt(head);
            int num = 0;
            while (tail < S.length()) {
                if (S.charAt(tail) == tmp) {
                    num++;
                    tail++;
                } else {
                    head = tail;
                    break;
                }
            }
            sb.append(tmp);
            sb.append(num);
            if (tail == S.length()) {
                break;
            }
        }
        return sb.length() >= S.length() ? S : sb.toString();
    }

    // id 面试题 50
    // 第一个只出现一次的字符
    public char firstUniqChar(String s) {
        if (s.equals("")) return ' ';
        char[] chs = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chs[i] = s.charAt(i);
        }
        Map<Character, Integer> map = new LinkedHashMap<>();
        List<Character> once = new ArrayList<>();
        for (char ch : chs) {
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
                once.add(ch);
            } else {
                map.put(ch, map.get(ch) + 1);
                for (int j = 0; j < once.size(); j++) {
                    if (once.get(j) == ch) once.remove(j);
                }
            }
        }
        if (once.size() == 0) return ' ';
        return once.get(0);
    }

}
