package com.java.leetcode;

import java.util.*;

public class TagBinaryTree {

    public void preOrder(TreeNode t) {
        if (t != null) {
            System.out.println(t.val);
            preOrder(t.left);
            preOrder(t.right);
        }
    }

    // id 144
    // 前序遍历 非递归
    // 使用栈
    // 右子树先入栈 因为栈先入后出
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollFirst();
            res.add(node.val);
            if (node.right != null) {
                stack.offerFirst(node.right);
            }
            if (node.left != null) {
                stack.offerFirst(node.left);
            }
        }
        return res;
    }

    public void inOrder(TreeNode t) {
        if (t != null) {
            inOrder(t.left);
            System.out.println(t.val);
            inOrder(t.right);
        }
    }

    // id 94
    // 先一路找到最左的子节点
    // 然后 栈不空的时候 出栈 以此来访问右孩子
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        List<Integer> res = new ArrayList<>();
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.offerFirst(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pollFirst();
                res.add(p.val);
                p = p.right;
            }
        }
        return res;
    }

    public void postOrder(TreeNode t) {
        if (t != null) {
            postOrder(t.left);
            postOrder(t.right);
            System.out.println(t.val);
        }
    }

    // id 145
    public List<Integer> postorderTraversal(TreeNode root) {
        return new ArrayList<>();
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
        if (root == null) {
            return new ArrayList<>();
        }
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
    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }

    // id 面试题 26 树的子结构
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return helper26(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean helper26(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        return A.val == B.val && helper26(A.left, B.left) && helper26(A.right, B.right);
    }

    // id 面试题 32-1
    public int[] levelOrder_32_1(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
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
        if (root == null) {
            return new ArrayList<>();
        }
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
        if (start > end) {
            return null;
        }
        int mid = ((end - start) >> 1) + start;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs_108(nums, start, mid - 1);
        root.right = dfs_108(nums, mid + 1, end);
        return root;
    }

    // id 404
    private int sum = 0;

    public void sumOfLeftLeaves(TreeNode root) {
        if (root != null) {
            // 怎么样是左叶子哦~
            if (root.left != null && root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            }
            System.out.printf("sum: %d\n", sum);
            sumOfLeftLeaves(root.left);
            sumOfLeftLeaves(root.right);
        }
    }

    // id 501
    int preVal = 0, curTimes = 0, maxTimes = 0;
    ArrayList<Integer> list = new ArrayList<>();

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
        if (root != null) {
            if (root.val < val) {
                root.right = insertIntoBST(root.right, val);
            } else if (root.val > val) {
                root.left = insertIntoBST(root.left, val);
            } else {
                return root;
            }
        } else {
            return new TreeNode(val);
        }
        return root;
    }

    // id 105
    // id 面试题 07
    // 前序+中序
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

    // id 面试题 27
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        // root.left = 翻转好了的左子树
        root.left = mirrorTree(root.left);
        root.right = mirrorTree(root.right);
        // 最后在根节点上翻转
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }

    // id 938
    // 递归真香
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        if (root.val >= L && root.val <= R) {
            return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        } else if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        } else {
            return rangeSumBST(root.left, L, R);
        }
    }

    // id 700
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    // id 590
    public List<Integer> postorder(Node root) {
        List<Integer> res_pre = new ArrayList<>();
        if (root == null)
            return res_pre;
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            Node n = s.pop();
            res_pre.add(n.val);
            for (Node node : n.children)
                s.push(node);
        }
        Collections.reverse(res_pre);
        return res_pre;
    }

    // id 面试题 54
    // 1,二叉搜索树中序遍历就是一个有序的数组
    public int kthLargest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res.get(res.size() - k);
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root != null) {
            inorder(root.left, res);
            res.add(root.val);
            inorder(root.right, res);
        }
    }

    // id 面试题 28 对称二叉树
    // id 101
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetricHelper(root.left, root.right);
    }

    public boolean isSymmetricHelper(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        // 传入 左右 跟 右左 怎么理解？
        return root1.val == root2.val && isSymmetricHelper(root1.left, root2.right) &&
                isSymmetricHelper(root1.right, root2.left);
    }

    // 构造二叉树问题
    // 1，前序遍历+中序遍历 构造二叉树 唯一
    // 2，中序遍历+后序遍历 构造二叉树 唯一
    // 3，前序遍历+后序遍历 构造二叉树 答案不唯一
    // 4，前序遍历 构造二叉搜索树

    // 前+中
    public TreeNode buildTreeFromPreIn(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        if (preorder.length == 1 && inorder.length == 1) return new TreeNode(preorder[0]);
        return buildTreeFromPreInCore(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeFromPreInCore(int[] preorder, int preS, int preE, int[] inorder, int inS, int inE) {
        if (preS > preE) return null;
        TreeNode root = new TreeNode(preorder[preS]);
        // 找到根节点在中序中的位置，以此来划分左右子树
        int pos = inS;
        while (pos < inE) {
            if (inorder[pos] == root.val) {
                break;
            }
            pos++;
        }
        // pos的左边是左子树，右边是右子树，递归即可
        int leftLen = pos - inS;
        int rightLen = inE - pos;
        // 确定子区间
        int newLeftPreS = preS + 1;
        int newLeftPreE = newLeftPreS + leftLen - 1;
        int newRightPreS = newLeftPreE + 1;
        int newRightPreE = newRightPreS + rightLen - 1;

        int newLeftInE = pos - 1;
        int newRightInS = pos + 1;
        int newRightInE = newRightInS + rightLen - 1;

        root.left = buildTreeFromPreInCore(preorder, newLeftPreS, newLeftPreE, inorder, inS, newLeftInE);
        root.right = buildTreeFromPreInCore(preorder, newRightPreS, newRightPreE, inorder, newRightInS, newRightInE);
        return root;
    }

    // 前+后
    public TreeNode buildTreeFromPrePost(int[] pre, int[] post) {
        if (pre.length == 0 || post.length == 0) return null;
        if (pre.length == 1 && post.length == 1) return new TreeNode(pre[0]);
        int[] reversePost = new int[post.length];
        for (int i = 0; i < reversePost.length; i++) {
            reversePost[i] = post[post.length - i - 1];
        }
        return buildTreeFromPrePostCore(pre, 0, pre.length - 1, reversePost, 0, reversePost.length - 1);
    }

    private TreeNode buildTreeFromPrePostCore(int[] pre, int preS, int preE, int[] post, int postS, int postE) {
        if (preS > preE || postS > postE) return null;
        TreeNode root = new TreeNode(pre[preS]);
        if (preS == preE) return root;
        // 找到右子树的起点
        int pos = preS;
        while (pos < preE) {
            if (post[postS + 1] == pre[pos]) {
                break;
            }
            pos++;
        }

        int leftPreS = preS + 1;
        int rightPreS = pos;
        int leftPreE = rightPreS - 1;

        // 左右子树节点数
        int leftLen = rightPreS - leftPreS;
        int rightLen = 1 + preE - rightPreS;

        int rightPostS = postS + 1;
        int rightPostE = rightPostS + rightLen - 1;
        int leftPostS = rightPostE + 1;

        root.left = buildTreeFromPrePostCore(pre, leftPreS, leftPreE, post, leftPostS, postE);
        root.right = buildTreeFromPrePostCore(pre, rightPreS, preE, post, rightPostS, rightPostE);
        return root;
    }

    // 中+后
    public TreeNode buildTreeFromInPost(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        if (inorder.length == 1 || postorder.length == 1) return new TreeNode(inorder[0]);
        return buildTreeFromInPostCore(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTreeFromInPostCore(int[] inorder, int inS, int inE, int[] postorder, int postS, int postE) {
        if (inS > inE || postS > postE) return null;
        TreeNode root = new TreeNode(postorder[postE]);
        if (postE == postS) return root;

        // 寻找根节点在中序遍历中的位置，以此来划分左右子树
        int pos = inS;
        while (pos < inE) {
            if (postorder[postE] == inorder[pos]) {
                break;
            }
            pos++;
        }

        int leftInE = pos - 1;
        int rightInS = pos + 1;

        int leftLen = pos - inS;
        int rightLen = inE - pos;

        int leftPostE = postS + leftLen - 1;
        int rightPostS = leftPostE + 1;
        int rightPostE = postE - 1;

        root.left = buildTreeFromInPostCore(inorder, inS, leftInE, postorder, postS, leftPostE);
        root.right = buildTreeFromInPostCore(inorder, rightInS, inE, postorder, rightPostS, rightPostE);
        return root;
    }

    // 树的路径问题
    // 1，路径和
    // 2，打印路径

    // id 112 是否存在路经总和为K的路径
    // 递归实现
    // 终止条件要想清楚
    // 1 判断在叶子节点 是否为0了
    private boolean ans = false;

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        hasPathSum_dfs(root, sum);
        return ans;
    }

    private void hasPathSum_dfs(TreeNode root, int sum) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                ans = true;
            }
        }
        hasPathSum_dfs(root.left, sum - root.val);
        hasPathSum_dfs(root.right, sum - root.val);
    }

    // id 面试题 04.12 求出和为K的路径数 不一定从根节点开始
    // 深度优先搜索
    // 每一个都使用dfs
    // 主函数遍历二叉树
    // helper函数dfs
    private int cnt = 0;

    public void pathSum(TreeNode root, int sum) {
        if (root == null) return;
        pathSum_dfs(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
    }

    private void pathSum_dfs(TreeNode root, int sum) {
        if (root == null) return;
        // 不要判断是否叶子节点
        // if (root.left == null && root.right == null)
        if (root.val == sum) {
            cnt++;
        }
        pathSum_dfs(root.left, sum - root.val);
        pathSum_dfs(root.right, sum - root.val);
    }

    // id 113 求出和为K的路径 返回路径数组
    // 只从根节点开始
    // 到叶子节点
    // 外层从根节点开始
    // 内层dfs
    public List<List<Integer>> pathSum_113(TreeNode root, int sum) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        pathSum_113_dfs(root, sum, res, tmp);
        return res;
    }

    private void pathSum_113_dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> tmp) {
        if (root == null) return;
        tmp.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                res.add(new ArrayList<>(tmp));
            }
        }
        pathSum_113_dfs(root.left, sum - root.val, res, tmp);
        pathSum_113_dfs(root.right, sum - root.val, res, tmp);
        tmp.remove(tmp.size() - 1);
    }

    // id 面试题 04 05
    // 检查是否为合法二叉搜索树
    // 考虑递归
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean isValidBST(TreeNode node, long max, long min) {
        if (node == null) return true;
        return node.val < max && node.val > min && isValidBST(node.left, node.val, min) && isValidBST(node.right, max, node.val);
    }

    // id 111
    // 二叉树的最小深度
    public int minDepth(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        if (root == null) return 0;
        if (root.left == null && root.right != null) return 1 + minDepth(root.right);
        if (root.right == null && root.left != null) return 1 + minDepth(root.left);
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    // id 110
    // id 面试题 55-II
    // 判断是否平衡二叉树 任意节点左右子树高度差不超过1
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else if (Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        } else {
            return false;
        }
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public Node treeToDoublyList(Node root) {

        return null;
    }

    // id 100
    // same tree
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null) {
            return false;
        }
        if (q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
