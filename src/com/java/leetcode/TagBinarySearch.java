package com.java.leetcode;

import java.util.Arrays;

public class TagBinarySearch {

    // id 287
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            System.out.printf("slow %d\n", nums[slow]);
            System.out.printf("fast %d\n", nums[fast]);
            if (nums[slow] == nums[fast]) {
                fast = 0;
                while (nums[slow] != nums[fast]) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return nums[slow];
            }
        }
    }

    // id 面试题 11
    public int minArray(int[] numbers) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int mid = ((r - l) >> 1) + l;
            //只要右边比中间大，那右边一定是有序数组
            if (numbers[r] > numbers[mid]) {
                r = mid;
            } else if (numbers[r] < numbers[mid]) {
                l = mid + 1;
                //去重
            } else r--;
        }
        return numbers[l];
    }

    // id 面试题 53-I
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = ((r - l) >> 1) + l;
            if (target <= nums[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        int cnt = 0;
        while (l < nums.length && nums[l++] == target) {
            cnt++;
        }
        return cnt;
    }

    // id 400
    public int findNthDigit(int n) {
        int left = 1;
        int oldLen = 0;
        while (left < n) {
            int mid = (left + n) / 2;
            int len = getDigitLength(left, mid);
            oldLen += len;
            if (oldLen < n) {
                left = mid + 1;
            } else {
                oldLen -= len;
                break;
            }
        }
        for (int i = left; i < n + 1; i++) {
            int len = getDigitLength(i, i);
            int total = len;
            while (len > 0) {
                len--;
                oldLen++;
                if (oldLen == n) {
                    int d = total - len;
                    String s = String.valueOf(i);
                    char res = s.charAt(d-1);
                    return Character.getNumericValue(res);
                }
            }
        }

        return 0;
    }

    public int getDigitLength(int start, int end) {
        if (start > end) {
            int tmp = start;
            start = end;
            end = tmp;
        }
        int len = 0;
        for (int i = start; i < end + 1; i++) {
            int cur = i;
            int cnt = 0;
            while (cur >= 1) {
                cur /= 10;
                cnt++;
            }
            len += cnt;
        }
        return len;
    }
}
