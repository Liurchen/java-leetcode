package com.java.leetcode;

import java.util.*;

public class Tag_BFS {

    // id 690
    public int getImportance(List<Employee> employees, int id) {
        Queue<Employee> queue = new ArrayDeque<>(employees.size());
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        queue.offer(map.get(id));
        int res = 0;
        while (!queue.isEmpty()) {
            Employee employee = queue.poll();
            res += employee.importance;
            for (int subId : employee.subordinates) {
                queue.offer(map.get(subId));
            }
        }
        return res;
    }

    // id 559
    public int maxDepth(Node root) {
        int max = 0;
        if (root == null) {
            return 0;
        } else if (root.children.size() == 0) {
            return 1;
        } else {
            for (Node nd : root.children) {
                max = Math.max(max, maxDepth(nd) + 1);
            }
        }
        return max;
    }

    // id 993
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root.val == x || root.val == y) return false;
        Queue<TreeNode> q = new LinkedList<>();
        int[] hash = new int[101];  // 用来存储父节点的值，题目说明数据范围1-100 & 没有重复数字
        q.offer(root);

        boolean hasX = false, hasY = false;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                assert temp != null;
                if (temp.left != null) {
                    q.offer(temp.left);
                    int left = temp.left.val;
                    hash[left] = temp.val;
                    if (left == x) hasX = true;
                    if (left == y) hasY = true;
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                    int right = temp.right.val;
                    hash[right] = temp.val;
                    if (right == x) hasX = true;
                    if (right == y) hasY = true;
                }
            }
            if (hasX && hasY) return hash[x] != hash[y];  // x,y在同一层出现
            if (hasX || hasY) return false; // x, y只出现一个，直接返回false
        }
        return false;
    }

    // id 542.01
    public int[][] updateMatrix(int[][] matrix) {
        return null;
    }

    // id 1162
    public int maxDistance(int[][] grid) {
        return 0;
    }
}

// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
