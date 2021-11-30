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

}
