package com.java.leetcode;

public class Main {

    public static void main(String[] args) {
        // write your code here
        LTC_Tag_Stack solution = new LTC_Tag_Stack();
        String[] tokens = {"4", "13", "5", "/", "+"};
        System.out.println(solution.evalRPN(tokens));
    }
}
