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

    public int firstUniqChar(String s) {
        if (s.length() == 1) return 0;
        LinkedHashMap<Character, Integer> hm = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hm.merge(ch, 1, Integer::sum);
        }
        for (char ch : hm.keySet()) {
            if (hm.get(ch) == 1) {
                return s.indexOf(ch);
            }
        }
        return -1;
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

}
