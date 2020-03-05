package com.java.leetcode;

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

}
