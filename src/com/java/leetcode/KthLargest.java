//package com.java.leetcode;
//
//// 动态 top k 问题
//class KthLargest {
//
//    private int[] minHeap;
//
//    private final int size;
//
//    private int last;
//
//    public KthLargest(int k, int[] nums) {
//        this.size = k;
//        this.minHeap = new int[k + 1];
//        for (int i = 1; i <= k && i <= nums.length; i++) {
//            this.minHeap[i] = nums[i - 1];
//            this.last = i;
//        }
//        /*如果小顶堆被填满了,就继续添加元素,并使堆有序*/
//        if (last == k) {
//            for (int i = k; i < nums.length; i++) {
//                add(nums[i]);
//            }
//        }
//
//        buildMinHeap(nums, nums.length);
//    }
//
//    public int add(int val) {
//        return 0;
//    }
//
//    private void buildMinHeap(int[] nums, int len) {
//        for (int i = (len >> 1) - 1; i >= 0; i--) {
//            adjustMinHeap(nums, i, len);
//        }
//    }
//
//    private void adjustMinHeap(int[] nums, int i, int len) {
//        int left = i * 2 + 1;
//        int right = i * 2 + 2;
//        int min = i;
//        if (left < len && nums[left] < nums[min]) {
//            min = left;
//        }
//        if (right < len && nums[right] < nums[min]) {
//            min = right;
//        }
//        if (min != i) {
//            swap(nums, i, min);
//            adjustMinHeap(nums, min, len);
//        }
//    }
//
//    private void swap(int[] nums, int i, int j) {
//        // 异或双方不能相等，否则会得到0
//        if (i != j) {
//            nums[i] ^= nums[j];
//            nums[j] ^= nums[i];
//            nums[i] ^= nums[j];
//        }
//    }
//
//}
