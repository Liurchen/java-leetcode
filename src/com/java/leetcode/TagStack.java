package com.java.leetcode;

import java.util.*;

public class TagStack {

    public String simplifyPath(String path) {
        if (path.equals("/") || path.equals("")) {
            return "/";
        }
        String[] paths = path.trim().split("/");
        Stack<String> stack = new Stack<>();
        for (String str : paths) {
            if (str.equals("..")) {
                //出栈
                stack.pop();
            } else if (!str.equals(".") && !str.equals("")) {
                //别动
                stack.push(str);
            }
        }
        if (stack.size() == 0) {
            return "/";
        }
        StringBuilder res = new StringBuilder();
        for (int i = stack.size() - 1; i >= 0; i--) {
            res.append("/");
            res.append(stack.pop());
        }
        return res.toString();
    }

    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        if (tokens.length == 0) {
            return 0;
        }
        Stack<String> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                Integer a = Integer.parseInt(stack.pop());
                Integer b = Integer.parseInt(stack.pop());
                int c = 0;
                switch (s) {
                    case "+":
                        c = a + b;
                        break;
                    case "-":
                        c = b - a;
                        break;
                    case "*":
                        c = a * b;
                        break;
                    case "/":
                        c = b / a;
                        break;
                }
                stack.push(Integer.toString(c));
            } else {
                stack.push(s);
            }
        }
//        stack.printStack();
        return Integer.parseInt(stack.pop());
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer, Integer> hasMap = new HashMap<Integer, Integer>();

        int[] result = new int[nums1.length];

        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                hasMap.put(stack.pop(), num);
            }
            stack.push(num);
        }

        for (int i = 0; i < nums1.length; i++) result[i] = hasMap.getOrDefault(nums1[i], -1);

        return result;
    }

    public boolean isValidSerialization(String preorder) {
        String[] str = preorder.split(",");
        int count = 1;
        for (int i = 0; i < str.length; i++) {
            if (count == 0) return false;
            if (str[i].equals("#"))
                count--;
            else if (i != str.length - 1) {
                count++;
            }
        }
        System.out.println(count);
        return count == 0;
    }

    // id 739
    public int[] dailyTemperatures(int[] T) {

        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];

        for (int i = 0; i < T.length; i++) {
            while (!stack.empty() && T[i] > T[stack.peek()]) {
                int temp = stack.pop();
                res[temp] = i - temp;
            }
            stack.push(i);
        }
        return res;
    }

    // id 445
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int t = 0; //进位变量
        ListNode res = null;
        while (!s1.isEmpty() || !s2.isEmpty() || t > 0) {
            if (!s1.isEmpty()) {
                t += s1.pop();
            }
            if (!s2.isEmpty()) {
                t += s2.pop();
            }
            ListNode cur = new ListNode(t % 10);
            cur.next = res; //头插法
            res = cur;
            t /= 10;
        }
        return res;
    }

    // id 面试题 31
    // 栈的压入，弹出序列
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int ptr = 0;
        for (int val : pushed) {
            stack.push(val);
            while (!stack.isEmpty() && stack.peek() == popped[ptr]) {
                stack.pop();
                ptr++;
            }
        }
        return stack.isEmpty();
    }
}
