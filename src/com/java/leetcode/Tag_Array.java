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
        int m = 0, cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                m = nums[i];
                cnt++;
            } else {
                if (nums[i] == m) {
                    cnt++;
                } else {
                    cnt--;
                }
                if (cnt == 0) {
                    m = nums[i];
                    cnt++;
                }
            }
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

    // id 75
    public void sortColors(int[] nums) {
        int p1 = 0;
        int p2 = 1;
        while (p1 < nums.length) {
            if (p2 == nums.length) {
                p1++;
                p2 = p1;
            }
            if (p1 == nums.length) {
                break;
            }
            if (nums[p1] > nums[p2]) {
                int tmp = nums[p1];
                nums[p1] = nums[p2];
                nums[p2] = tmp;
            } else {
                p2++;
            }
        }
    }

    // id 56
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[][]{};
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        int[][] res = new int[intervals.length][2];
        res[0] = intervals[0];
        int j = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (res[j][1] >= intervals[i][0]) {
                res[j][1] = Math.max(res[j][1], intervals[i][1]);
            } else {
                res[++j] = intervals[i];
            }
        }

        return Arrays.copyOf(res, j + 1);
    }

    // id 238
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int left = 1;
        // 从左往右遍历
        for (int i = 0; i < nums.length; i++) {
            result[i] = left;
            left = nums[i] * left;
        }
        int right = 1;
        // 从右往左遍历
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= right;
            right = nums[i] * right;
        }
        return result;
    }

    // id 896
    public boolean isMonotonic(int[] A) {
        int n = A.length;
        if (n < 3) return true;
        boolean flag1 = false, flag2 = false;  //flag1递增标志  flag2递减标志
        for (int i = 1; i < n; i++) {
            if (A[i] - A[i - 1] > 0) {
                if (flag2) return false;
                flag1 = true;
            } else if (A[i] - A[i - 1] < 0) {
                if (flag1) return false;
                flag2 = true;
            }
        }
        return true;
    }

    // id 350
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        do {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        } while (i < nums1.length && j < nums2.length);
        int[] arr = new int[result.size()];
        for (int k = 0; k < arr.length; k++) {
            arr[k] = result.get(k);
        }
        return arr;
    }

    // id LCP 1.猜数字
    public int game(int[] guess, int[] answer) {
        int p1 = 0, p2 = 0;
        int cnt = 0;
        while (p1 < guess.length) {
            if (guess[p1] == answer[p2]) {
                cnt++;
            }
            p1++;
            p2++;
        }
        return cnt;
    }

}
