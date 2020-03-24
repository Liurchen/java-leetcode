package com.java.leetcode;

import java.util.Arrays;

public class Tag_Array {

    public void rotate(int[][] matrix) {
        // 先转置
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // 再镜像对称
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = tmp;
            }
        }
    }

    public int search(int[] nums, int target) {
        int a = 0;
        for (int num : nums) {
            if (num == target) {
                a++;
            }
        }
        return a;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            int len = ints.length;
            if (len == 0) return false;
            int min = ints[0];
            int max = ints[len - 1];
            int idx = 0;
            while (target <= max && target >= min && idx < len) {
                if (target == ints[idx]) return true;
                idx++;
            }
        }
        return false;
    }

    public int arrayPairSum(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int sum = 0;
        Arrays.sort(nums);
        int idx = 0;
        int count = 0;
        while (idx < len) {
            if ((idx + 1) % 2 == 0) {
                sum += Math.min(nums[idx], nums[idx - 1]);
            }
            idx++;
        }
        return sum;
    }

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int mr = nums.length;
        if (mr == 0) return nums;
        int mc = nums[0].length;
        if (mc == 0) return nums;
        if (mr * mc != r * c) return nums;
        int[][] reshape = new int[r][c];

        int ridx = 0;
        int cidx = 0;
        for (int[] num : nums) {
            for (int j = 0; j < mc; j++) {
                if (cidx == c) {
                    cidx = 0;
                    ridx++;
                }

                reshape[ridx][cidx] = num[j];
                cidx++;
            }
        }
        return reshape;
    }

    public int findUnsortedSubarray(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int R = 0;
        int L = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max > arr[i]) {
                R = i;
            }
            max = Math.max(max, arr[i]);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (min < arr[i]) {
                L = i;
            }
            min = Math.min(min, arr[i]);
        }
        return R == L ? 0 : R - L + 1;
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            boolean left = false;
            boolean right = false;
            if (flowerbed[i] == 1) {
                continue;
            }
            if (i - 1 >= 0 && i - 1 <= flowerbed.length - 1 && flowerbed[i - 1] == 0) {
                left = true;
            }
            if (i + 1 <= flowerbed.length - 1 && flowerbed[i + 1] == 0) {
                right = true;
            }
            // 其实也可以先给左右各种上一个0 防御式编程思想
            if (i - 1 < 0) {
                left = true;
            }
            if (i + 1 > flowerbed.length - 1) {
                right = true;
            }
            if (left && right) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return !(n > 0);
    }

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int last = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        int head = nums[0] * nums[1] * nums[nums.length - 1];
        return Math.max(head, last);
    }

    public double findMaxAverage(int[] nums, int k) {
        double maxAve = 0.0;
        for (int i = k - 1; i < nums.length; i++) {
            int sum = 0;
            for (int j = i - k + 1; j <= i; j++) {
                sum += nums[j];
            }
            if ((double) sum / k > maxAve || (maxAve == 0.0)) {
                maxAve = (double) sum / k;
            }
        }
        return maxAve;
    }

    public int majorityElement(int[] nums) {
        int m = 0, i = 0;
        for (int num : nums) {
            if (i == 0) {
                m = num;
                i++;
            } else if (m == num) {
                i++;
            } else {
                i--;
            }
        }
        if (i == 0) {
            return -1;
        }
        return m;
    }

    public int missingNumber(int[] nums) {
        int sum = nums.length * (1 + nums.length) / 2;
        int sum1 = 0;
        for (int num : nums) {
            sum1 += num;
        }
        return sum - sum1;
    }
}
