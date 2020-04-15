package com.java.leetcode;

public class Tag_DFS {

    // id 1020
    public int numEnclaves(int[][] A) {
        int res = 0, m = A.length, n = A[0].length;
        for (int i = 0; i < m; i++) {
            if (A[i][0] == 1) {
                dfs_1020(A, i, 0);
            }
            if (A[i][n - 1] == 1) {
                dfs_1020(A, i, n - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (A[0][i] == 1) {
                dfs_1020(A, 0, i);
            }
            if (A[m - 1][i] == 1) {
                dfs_1020(A, m - 1, i);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    res += dfs_1020(A, i, j);
                }
            }
        }
        return res;
    }

    private int dfs_1020(int[][] A, int i, int j) {
        if (i < 0 || i >= A.length || j < 0 || j >= A[0].length || A[i][j] == 0) {
            return 0;
        }
        A[i][j] = 0;
        return 1 + dfs_1020(A, i + 1, j) + dfs_1020(A, i - 1, j) + dfs_1020(A, i, j - 1) + dfs_1020(A, i, j + 1);
    }
}
