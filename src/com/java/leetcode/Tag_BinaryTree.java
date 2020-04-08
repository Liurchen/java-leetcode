package com.java.leetcode;

import java.util.*;

public class Tag_BinaryTree {

    public void preOrder(TreeNode t) {
        if (t != null) {
            System.out.println(t.val);
            preOrder(t.left);
            preOrder(t.right);
        }
    }

    // id 144
    public List<Integer> preorderTraversal(TreeNode root) {
        return null;
    }

    public void inOrder(TreeNode t) {
        if (t != null) {
            inOrder(t.left);
            System.out.println(t.val);
            inOrder(t.right);
        }
    }

    public void postOrder(TreeNode t) {
        if (t != null) {
            postOrder(t.left);
            postOrder(t.right);
            System.out.println(t.val);
        }
    }

    public void levelOrder(TreeNode t) {
        if (t != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(t);
            while (!queue.isEmpty()) {
                TreeNode head = queue.poll();
                System.out.println(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
        }
    }

    // id 617
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        System.out.println(t1.val);
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    // id 114
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        root.right = tmp;
    }

    // id 102
    public List<List<Integer>> levelOrder_102(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 每层的叶子数目 == queue.size()
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            while (size > 0) {
                TreeNode head = queue.poll();
                assert head != null;
                tmp.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
                size--;
            }
            result.add(tmp);
        }
        return result;
    }

    // id 105
    // 不会
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return null;
    }

    // id 236
    // 不会
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return null;
    }

    // id 543
    // 不会
    public int diameterOfBinaryTree(TreeNode root) {
        return 0;
    }

    // id 面试题 55-1
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    // id 面试题 26 树的子结构
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return helper26(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean helper26(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null) return false;
        return A.val == B.val && helper26(A.left, B.left) && helper26(A.right, B.right);
    }

    // id 面试题 32-1
    public int[] levelOrder_32_1(TreeNode root) {
        if (root == null) return new int[]{};
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode head = q.poll();
            res.add(head.val);
            if (head.left != null) {
                q.offer(head.left);
            }
            if (head.right != null) {
                q.offer(head.right);
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    // id 面试题 32-3
    public List<List<Integer>> levelOrder_32_3(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 0;
        while (!queue.isEmpty()) {
            // 每层的叶子数目 == queue.size()
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            i++;
            while (size > 0) {
                TreeNode head = queue.poll();
                assert head != null;
                tmp.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
                size--;
            }
            if (i % 2 == 0) {
                Collections.reverse(tmp);
            }
            result.add(tmp);
        }
        return result;
    }
}
