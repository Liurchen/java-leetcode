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

    // id 235
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

    // id 108
    public TreeNode sortedArrayToBST(int[] nums) {
        // idea 左右区间分治策略 递归
        // 求中点不要用 int mid = (start + end)/2，有溢出风险，稳妥的方法是 int mid = start + (end-start)/2
        // 如果你把除2改成右移1位，会和面试官更搭哦
        return nums == null ? null : dfs_108(nums, 0, nums.length - 1);
    }

    private TreeNode dfs_108(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = dfs_108(nums, start, mid - 1);
        node.right = dfs_108(nums, mid + 1, end);
        return node;
    }

    // id 404
    private int sum = 0;

    public void sumOfLeftLeaves(TreeNode root) {
        if (root != null) {
            // 怎么样是左叶子哦~
            if (root.left != null && root.left.left == null && root.left.right == null) sum += root.left.val;
            System.out.printf("sum: %d\n", sum);
            sumOfLeftLeaves(root.left);
            sumOfLeftLeaves(root.right);
        }
    }

    // id 501
    int preVal = 0, curTimes = 0, maxTimes = 0;
    ArrayList<Integer> list = new ArrayList<Integer>();

    public int[] findMode(TreeNode root) {
        traversal(root);
        //list转换为int[]
        int size = list.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    //二叉搜索树中序遍历是递增顺序
    public void traversal(TreeNode root) {
        if (root != null) {
            traversal(root.left);
            //判断当前值与上一个值的关系, 更新 curTimes 和 preVal
            if (preVal == root.val) {
                curTimes++;
            } else {
                preVal = root.val;
                curTimes = 1;
            }
            //判断当前数量与最大数量的关系, 更新 list 和 maxTimes
            if (curTimes == maxTimes) {
                list.add(root.val);
            } else if (curTimes > maxTimes) {
                list.clear();
                list.add(root.val);
                maxTimes = curTimes;
            }
            traversal(root.right);
        }
    }

    // id 701
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return null;
    }

    // id 105
    // id 面试题 07
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        if (preorder.length == 1) return new TreeNode(preorder[0]);
        return buildTreeCore(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTreeCore(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootInPos = inStart;
        while (rootInPos < inEnd) {
            if (inorder[rootInPos] == root.val) {
                break;
            }
            rootInPos++;
        }
        System.out.printf("root pos is %d in inorder\n", rootInPos);
        // 左子树
        int leftLen = rootInPos - inStart;
        int leftPreStart = preStart + 1;
        int leftPreEnd = leftPreStart + leftLen - 1;
        int leftInEnd = rootInPos - 1;
        root.left = buildTreeCore(preorder, inorder, leftPreStart, leftPreEnd, inStart, leftInEnd);
        // 右子树
        int rightLen = inEnd - rootInPos;
        int rightPreStart = leftPreEnd + 1;
        int rightPreEnd = rightPreStart + rightLen - 1;
        int rightInStart = rootInPos + 1;
        root.right = buildTreeCore(preorder, inorder, rightPreStart, rightPreEnd, rightInStart, inEnd);
        return root;
    }
}
