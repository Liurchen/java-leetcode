package com.java.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;

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
            if (hm.get(ch) == null) {
                hm.put(ch, 1);
            } else {
                hm.put(ch, hm.get(ch) + 1);
            }
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

    public int compress(char[] chars) {
        // 不会
        return 0;
    }

    public boolean repeatedSubstringPattern(String s) {
        return false;
    }

}
