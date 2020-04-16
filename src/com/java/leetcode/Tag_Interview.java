package com.java.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Tag_Interview {

    public String map2string(Map<String, String> map) {
        Set<String> ks = map.keySet();
        String[] ka = ks.toArray(new String[0]);
        for (String k : ka) {
            System.out.println(k);
        }
        StringBuilder sb = new StringBuilder();
        for (String s : ka) {
            sb.append(s).append(":").append(map.get(s)).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public Map<String, String> string2map(String str) {
        Map<String, String> map = new HashMap<>();
        String[] sa = str.split(",");
        for (String s : sa) {
            String[] tmp = s.split(":");
            map.put(tmp[0], tmp[1]);
        }
        return map;
    }
}
