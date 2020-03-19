package com.java.leetcode;

import java.util.*;

public class LTC_Tag_Stack {

    public String simplifyPath(String path) {
        if (path.equals("/") || path.equals("")) {
            return "/";
        }
        String[] paths = path.trim().split("/");
        MiniStacks<String> stack = new MiniStacks<>();
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
            res.append(stack.getElem(i));
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
        MiniStacks<String> stack = new MiniStacks<>();
        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                Integer a = Integer.parseInt(stack.pop());
                Integer b = Integer.parseInt(stack.pop());
                Integer c = 0;
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
                stack.push(c.toString());
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

}
