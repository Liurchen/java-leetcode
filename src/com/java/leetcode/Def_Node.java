package com.java.leetcode;

import java.util.List;

public class Def_Node {

    public int val;
    public Def_Node left;
    public Def_Node right;
    public List<Def_Node> children;

    public Def_Node() {
    }

    public Def_Node(int _val) {
        val = _val;
    }

    public Def_Node(int _val, Def_Node _left, Def_Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }

    public Def_Node(int _val, List<Def_Node> _children) {
        val = _val;
        children = _children;
    }
}
