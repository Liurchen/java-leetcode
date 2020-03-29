package com.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public int[][] imageSmoother(int[][] M) {
        if (M.length == 0) return null;
        if (M[0].length == 0) return null;
        int[][] res = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            int row = M.length;
            int col = M[i].length;
            for (int j = 0; j < M[i].length; j++) {
//                System.out.println(M[i][j]);
                int sum = M[i][j];
                int div = 1;
                if (i - 1 >= 0 && j - 1 >= 0) {
                    sum += M[i - 1][j - 1];
                    div++;
                }
                if (i - 1 >= 0) {
                    sum += M[i - 1][j];
                    div++;
                }
                if (i - 1 >= 0 && j + 1 < col) {
                    sum += M[i - 1][j + 1];
                    div++;
                }
                if (j - 1 >= 0) {
                    sum += M[i][j - 1];
                    div++;
                }
                if (j + 1 < col) {
                    sum += M[i][j + 1];
                    div++;
                }
                if (i + 1 < row && j - 1 >= 0) {
                    sum += M[i + 1][j - 1];
                    div++;
                }
                if (i + 1 < row) {
                    sum += M[i + 1][j];
                    div++;
                }
                if (i + 1 < row && j + 1 < col) {
                    sum += M[i + 1][j + 1];
                    div++;
                }
                int ave = sum / div;
                res[i][j] = ave;
            }
        }
        return res;
    }

    public boolean checkPossibility(int[] nums) {
        int numsSize = nums.length;
        // 数组个数小于2个 一定可以
        if (numsSize < 3) {
            return true;
        }

        // 思路如下：
        // 如果出现 a[i] > a[i+1]   改变一个数 就面临两种选择
        // 1. 把a[i]变大
        // 2. 把a[i+1] 变小
        // 这两种选择其实是有依据的 需要比较a[i-1] 与 a[i+1]的值
        // eg.  ... 1 4 3 ...   只能选择把4变小   ... 3 4 1 ... 只能选择把1变大
        // 改变完之后，记录改变次数，再检测是否升序
        // 如果次数大于1，至少改了两次 返回false

        // 先让前两个有序
        // 因为没有左边没有数 所以对于前两个数来说，最佳选择就是吧 a[0] 变小
        int changeCount = 0;
        if (nums[0] > nums[1]) {
            nums[0] = nums[1];
            changeCount++;
        }

        for (int i = 1; i < numsSize - 1; i++) {
            int right = nums[i + 1];
            if (nums[i] > right) {
                changeCount++;
                if (changeCount > 1) {
                    // 后面不用再看了
                    return false;
                }
                int left = nums[i - 1];
                if (left > right) {
                    nums[i + 1] = nums[i];
                } else {
                    nums[i] = left;
                }
            }
        }
        return true;
    }

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        if (nums.length == 2) {
            if (nums[0] < nums[1]) {
                return 2;
            } else {
                return 1;
            }
        }
        List<Integer> counts = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int tmp = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[j - 1]) {
                    tmp++;
                } else {
                    break;
                }
            }
            counts.add(tmp);
        }

        int max = counts.get(0);
        for (int n : counts) {
            if (n > max) {
                max = n;
            }
            System.out.println(n);
        }

        return max;
    }

    public boolean isOneBitCharacter(int[] bits) {
        int head = 0;
        while (head < bits.length - 1) {
            if (bits[head] == 1) {
                head += 2;
            } else {
                head++;
            }
        }
        return head <= bits.length - 1;
    }

    public int pivotIndex(int[] nums) {
        // leftSum*2 = sum - nums[i]
        int sum = 0;
        int leftSum = 0;
        for (int num : nums) sum += num;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum * 2 == sum - nums[i]) {
                return i;
            } else {
                leftSum += nums[i];
            }
        }
        return -1;
    }

    public int dominantIndex(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        Arrays.sort(nums);
        if (nums[nums.length - 1] >= 2 * nums[nums.length - 2]) {
            return max;
        } else {
            return -1;
        }
    }

    public boolean isToMatrix(int[][] matrix) {
        if (matrix.length == 1) return true;
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                System.out.println(matrix[i][j]);
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    // id 830
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        if (S.length() <= 2) return res;
        // 防止数组越界的小技巧
        // 防御性编程
        // 首尾加一个元素
        S = "0" + S + "0";
        int start = 0;
        while (start < S.length()) {
            int end = start + 1;
            if (end >= S.length()) break;
            while (S.charAt(end) == S.charAt(start)) {
                end++;
            }
            int len = end - start;
            if (end - start >= 3) {
                List<Integer> tmp = new ArrayList<>(Arrays.asList(start - 1, end - 2));
                res.add(tmp);
            }
            start = end;
        }
        return res;
    }

}
