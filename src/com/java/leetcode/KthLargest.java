package com.java.leetcode;

// 动态 top k 问题
class KthLargest {

    public KthLargest(int k, int[] nums) {
        buildMaxHeap(nums, nums.length);
    }

    public int add(int val) {
        return 0;
    }

    private void buildMaxHeap(int[] nums, int len) {
        for (int i = (len >> 1) - 1; i >= 0; i--) {
            adjustHeap(nums, i, len);
        }
    }

    private void adjustHeap(int[] nums, int i, int len) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;
        if (left < len && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < len && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(nums, i, largest);
            adjustHeap(nums, largest, len);
        }
    }

    private void swap(int[] nums, int i, int j) {
        // 异或双方不能相等，否则会得到0
        if (i != j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }

}
