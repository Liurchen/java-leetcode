package com.java.leetcode;

import java.util.*;

public class TagBFS {

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
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] vector = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    // 将所有 0 元素作为 BFS 第一层
                    queue.add(new int[]{i, j});
                } else {
                    matrix[i][j] = row + col;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] s = queue.poll();
            // 搜索上下左右四个方向
            for (int[] v : vector) {
                int r = s[0] + v[0], c = s[1] + v[1];
                if (r >= 0 && r < row
                        && c >= 0 && c < col
                        && matrix[r][c] > matrix[s[0]][s[1]] + 1) {
                    // matrix[r][c] > matrix[s[0]][s[1]] + 1 看不懂
                    matrix[r][c] = matrix[s[0]][s[1]] + 1;
                    queue.add(new int[]{r, c});
                }
            }
        }
        return matrix;
    }

    // id 1162
    public int maxDistance(int[][] grid) {
        return 0;
    }

    // id 429
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> tmp = new ArrayList<>();
            while (size > 0) {
                Node nd = q.poll();
                assert nd != null;
                tmp.add(nd.val);
                size--;
                for (Node node : nd.children) {
                    q.offer(node);
                }
            }
            res.add(tmp);
        }
        return res;
    }

    // id 513
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            while (size > 0) {
                TreeNode tmp = q.poll();
                size--;
                assert tmp != null;
                level.add(tmp.val);
                if (tmp.left != null) {
                    q.offer(tmp.left);
                }
                if (tmp.right != null) {
                    q.offer(tmp.right);
                }
            }
            res.add(level);
        }
        return res.get(res.size() - 1).get(0);
    }

    // id 199
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            while (size > 0) {
                TreeNode tmp = q.poll();
                size--;
                assert tmp != null;
                level.add(tmp.val);
                if (tmp.left != null) {
                    q.offer(tmp.left);
                }
                if (tmp.right != null) {
                    q.offer(tmp.right);
                }
            }
            res.add(level);
        }
        List<Integer> result = new ArrayList<>();
        for (List<Integer> le : res) {
            result.add(le.get(le.size() - 1));
        }
        return result;
    }

    // id 515
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            while (size > 0) {
                TreeNode tmp = q.poll();
                size--;
                assert tmp != null;
                level.add(tmp.val);
                if (tmp.left != null) {
                    q.offer(tmp.left);
                }
                if (tmp.right != null) {
                    q.offer(tmp.right);
                }
            }
            res.add(level);
        }
        List<Integer> result = new ArrayList<>();
        for (List<Integer> le : res) {
            int max = le.get(0);
            for (int val : le) {
                if (max < val) {
                    max = val;
                }
            }
            result.add(max);
        }
        return result;
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
