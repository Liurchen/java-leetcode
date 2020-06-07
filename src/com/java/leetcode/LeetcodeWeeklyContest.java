package com.java.leetcode;

import java.util.*;

public class LeetcodeWeeklyContest {

    // 周赛 184
    // ac 前缀和
    public int minStartValue(int[] nums) {
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int min = 0;
        for (int sum : preSum) {
            if (min > sum) min = sum;
        }
        return Math.abs(min) + 1;
    }

    // id 1414
    // 和为 K 的最少斐波那契数字数目
    public int findMinFibonacciNumbers(int k) {
        // 有个问题 这个dp数组设为多大才行？？？
        int[] dp = new int[1000];
        dp[0] = 1;
        dp[1] = 1;
        int idx = 2;
        while (true) {
            dp[idx] = dp[idx - 1] + dp[idx - 2];
            if (dp[idx] > k) break;
            idx++;
        }
        int num = 0;
        for (int i = idx; i >= 0; i--) {
            if (k >= dp[i]) {
                k -= dp[i];
                num++;
            }
            if (k == 0) return num;
        }
        return num;
    }

    // id 1415
    // 长度为 n 的开心字符串中字典序第 k 小的字符串
    // 回溯问题
    public String getHappyString(int n, int k) {
        String[] abc = new String[]{"a", "b", "c"};
        List<String> result = new ArrayList<>();
        int[] visited = new int[]{1, 1, 1};
        for (int i = 0; i < abc.length; i++) {
            StringBuilder path = new StringBuilder(abc[i]);
            for (int j = 0; j < abc.length; j++) {
                if (j != i) {
                    visited[j] = 1;
                } else {
                    visited[j] = 0;
                }
            }
            backTrack(path, visited, n, result, abc);
        }
        return "";
    }

    private void backTrack(StringBuilder path, int[] visited, int n, List<String> result, String[] abc) {
        if (path.length() == n) {
            result.add(path.toString());
            return;
        }
        for (int i = 0; i < abc.length; i++) {
            if (visited[i] != 0) {
                path.append(abc[i]);
                for (int j = 0; j < abc.length; j++) {
                    if (j != i) {
                        visited[j] = 1;
                    } else {
                        visited[j] = 0;
                    }
                }
                backTrack(path, visited, n, result, abc);
                if (path.charAt(path.length() - 1) == 'a') {
                    visited[0] = 1;
                } else if (path.charAt(path.length() - 1) == 'b') {
                    visited[1] = 1;
                } else {
                    visited[2] = 1;
                }
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

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

    // 周赛 186
    // ac
    public int maxScore(String s) {
        int res = 0, cnt1 = 0, cnt0 = 0;        // cnt1统计右边1的个数，同理cnt0左边0的个数
        for (int i = 0; i < s.length(); i++) {
            cnt1 += s.charAt(i) - '0';            // 先统计1的个数
        }                                       // 由于左右区域的数至少为1，所以i不能等于len-1
        for (int i = 0; i < s.length() - 1; i++) {  // 点i分为左右两个区域
            if (s.charAt(i) == '0') cnt0++;      // 遇到01就统计，动态更新左右区域01个数
            else cnt1--;
            res = Math.max(res, cnt0 + cnt1);
        }
        return res;
    }

    // id 5393
    // 前缀和
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length, scoreR = 0, scoreL = 0;
        for (int i = 0; i < k; i++)
            scoreL += cardPoints[i];
        int res = scoreL;
        for (int l = 1; l <= k; l++) {
            scoreL -= cardPoints[k - l];
            scoreR += cardPoints[n - l];
            res = Math.max(res, scoreR + scoreL);
        }
        return res;
    }

    // id 1424
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        if (nums.size() == 0) return null;
        List<Integer> res = new ArrayList<>();
        int row = nums.size();
        for (List<Integer> num : nums) {
            if (num.size() > row) row = num.size();
        }
        int rowIdx = 1;
        while (rowIdx < row + 1) {
            int l = rowIdx;
            int r = 1;
            if (l == 1) {
                if (l - 1 < nums.size() && r - 1 < nums.get(l - 1).size()) {
                    res.add(nums.get(l - 1).get(r - 1));
                    System.out.println(nums.get(l - 1).get(r - 1));
                }
                rowIdx++;
                continue;
            }
            while (r < rowIdx && l > 1) {
                if (l - 1 < nums.size() && r - 1 < nums.get(l - 1).size()) {
                    res.add(nums.get(l - 1).get(r - 1));
                    System.out.println(nums.get(l - 1).get(r - 1));
                }
                r++;
                l--;
            }
            if (l - 1 < nums.size() && r - 1 < nums.get(l - 1).size()) {
                res.add(nums.get(l - 1).get(r - 1));
                System.out.println(nums.get(l - 1).get(r - 1));
            }
            rowIdx++;
        }
        int s = rowIdx - 1;
        int e = 2;
        while (e < row + 1) {
            int l = rowIdx - 1;
            int r = e;
            while (r < s + 1) {
                if (l - 1 < nums.size() && r - 1 < nums.get(l - 1).size()) {
                    res.add(nums.get(l - 1).get(r - 1));
                    System.out.println(nums.get(l - 1).get(r - 1));
                }
                l--;
                r++;
            }
            e++;
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    // 周赛 187
    // ac
    public String destCity(List<List<String>> paths) {
        List<String> st = new ArrayList<>();
        List<String> end = new ArrayList<>();
        for (List<String> pair : paths) {
            st.add(pair.get(0));
            end.add(pair.get(1));
        }
        end.removeIf(st::contains);
        return end.get(0);
    }

    // ac
    public boolean kLengthApart(int[] nums, int k) {
        if (nums.length == 1) return true;
        if (k == 0) return true;
        if (k >= nums.length) return false;
        int idx = 0;
        while (idx < nums.length) {
            if (nums[idx] == 1) {
                int n = k;
                int p = idx + 1;
                if (p == nums.length) return true;
                while (n > 0) {
                    if (nums[p] == 0) {
                        n--;
                        p++;
                    } else {
                        return false;
                    }
                }
                idx = p;
            } else {
                idx++;
            }
        }
        return true;
    }

    // 数组越界
    public int longestSubarray(int[] nums, int limit) {
        if (nums.length == 1) return 1;
        int head = 0;
        int tail = 1;
        int min = -1, max = -1;
        if (nums[head] >= nums[tail]) {
            max = head;
            min = tail;
        } else {
            max = tail;
            min = head;
        }
        int maxLen = -1;
        while (tail < nums.length) {
            if (nums[max] - nums[min] > limit) {
                head++;
                if (head == tail) tail++;
                min = head;
                max = tail;
                for (int i = head; i <= tail; i++) {
                    if (nums[i] >= nums[max]) max = i;
                    if (nums[i] <= nums[min]) min = i;
                }
            } else {
                tail++;
                if (tail - head > maxLen) maxLen = tail - head;
                if (tail == nums.length) break;
                if (nums[tail] >= nums[max]) max = tail;
                if (nums[tail] <= nums[min]) min = tail;
            }
        }
        return maxLen;
    }

    // 周赛 188
    // ac
    public List<String> buildArray(int[] target, int n) {
        int[] nums = new int[n + 1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        int idx = 0;
        List<String> res = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (idx >= target.length) return res;
            if (target[idx] == nums[i]) {
                res.add("Push");
                idx++;
            } else {
                res.add("Push");
                res.add("Pop");
            }
        }
        return res;
    }

    public int countTriplets(int[] arr) {
        if (arr.length < 2) return 0;
        int i = 0;
        int j = 1;
        int k = 1;


        return 0;
    }

    public String plus(String num1, String num2) {
        int dig1 = 0;
        for (int i = 0; i < num1.length(); i++) {
            int tmp = num1.charAt(i) - '0';
            dig1 += tmp * Math.pow(3, num1.length() - i - 1);
        }
        int dig2 = 0;
        for (int i = 0; i < num2.length(); i++) {
            int tmp = num2.charAt(i) - '0';
            dig2 += tmp * Math.pow(3, num2.length() - i - 1);
        }
        int res = dig1 + dig2;
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (res / 3 != 0) {
            list.add(res % 3);
            res = res / 3;
        }
        list.add(res % 3);
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public Integer[] find(Integer[] nums) {
        if (nums.length != 10) return new Integer[]{};
        Integer[] res = new Integer[3];
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += nums[i];
        }
        double avg = ((double) sum) / 10;
        Arrays.sort(nums);
        double dis = Math.abs(nums[0] - avg);
        int idx = 0;
        for (int i = 1; i < 10; i++) {
            double tmp = Math.abs(nums[i] - avg);
            if (tmp < dis) {
                dis = tmp;
                idx = i;
            }
        }
        res[0] = nums[idx];
        if (Math.abs(nums[idx - 1] - avg) > Math.abs(nums[idx + 1] - avg)) {
            res[1] = nums[idx + 1];
            res[2] = nums[idx - 1];
        } else {
            res[1] = nums[idx - 1];
            res[2] = nums[idx + 1];
        }
        return res;
    }
}










