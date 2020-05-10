package com.java.leetcode;

import java.util.Arrays;

public class Tag_Sort {

    // idea
    // 插入排序，一般也被称为直接插入排序。对于少量元素的排序，它是一个有效的算法
    // 它的基本思想是将一个记录插入到已经排好序的有序表中
    public void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int pre = 0;
            while (pre < i) {
                if (nums[pre] > nums[i]) {
                    swap(nums, pre, i);
                }
                pre++;
            }
        }
    }

    // idea
    // 希尔排序是插入排序的一种
    // 是直接插入排序算法的一种更高效的改进版本
    // 不稳定
    // 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序
    public void shellSort(int[] nums) {
    }

    // idea
    // 选择排序
    // 第一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置
    // 然后再从剩余的未排序元素中寻找到最小（大）元素，然后放到已排序的序列的末尾
    // 以此类推，直到全部待排序的数据元素的个数为零
    // 选择排序是不稳定的排序方法
    public void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            swap(nums, min, i);
        }
    }

    // idea
    // 堆排序 升序用大顶堆 降序用小顶堆
    // 堆是一种完全二叉树: 每个节点的值都大于等于其左右孩子节点的值->大顶堆; 每个节点的值都小于等于其左右孩子节点的值->小顶堆
    // step1 先构造堆
    // step2 将堆顶元素与末尾元素交换，然后调整堆，不断反复，直到有序
    public void heapSort(int[] nums) {
        int len = nums.length;
        buildMaxHeap(nums, len);
        for (int i = len - 1; i > 0; i--) {
            // 堆顶跟最后元素交换
            swap(nums, 0, i);
            // 尾指针--
            len--;
            // 调整索引0到尾指针重新为堆
            adjustMaxHeap(nums, 0, len);
        }
        print(nums);
    }

    private void buildMaxHeap(int[] nums, int len) {
        for (int i = (len >> 1) - 1; i >= 0; i--) {
            adjustMaxHeap(nums, i, len);
        }
    }

    private void adjustMaxHeap(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, i, largest);
            adjustMaxHeap(arr, largest, len);
        }
    }

    // 小顶堆
    private void buildMinHeap(int[] nums, int len) {
        for (int i = (len >> 1) - 1; i >= 0; i--) {
            adjustMinHeap(nums, i, len);
        }
    }

    private void adjustMinHeap(int[] nums, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int min = i;
        if (left < len && nums[min] > nums[left]) {
            min = left;
        }
        if (right < len && nums[min] > nums[right]) {
            min = right;
        }
        if (min != i) {
            swap(nums, i, min);
            adjustMinHeap(nums, min, len);
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

    private void print(int[] nums) {
        for (int num : nums) {
            System.out.println(num);
        }
    }

    // id 面试题 40
    // 最小的K个数
    // 堆排序 大根堆
    public int[] getLeastNumbers(int[] arr, int k) {
        int len = arr.length;
        buildMaxHeap4getLeastNumbers(arr, len);
        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            adjustMaxHeap4getLeastNumbers(arr, 0, len);
        }
        return Arrays.copyOf(arr, k);
    }

    private void buildMaxHeap4getLeastNumbers(int[] arr, int len) {
        for (int i = (len >> 1) - 1; i >= 0; i--) {
            adjustMaxHeap4getLeastNumbers(arr, i, len);
        }
    }

    private void adjustMaxHeap4getLeastNumbers(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;
        if (left < len && arr[left] > arr[max]) {
            max = left;
        }
        if (right < len && arr[right] > arr[max]) {
            max = right;
        }
        if (max != i) {
            swap(arr, max, i);
            adjustMaxHeap4getLeastNumbers(arr, max, len);
        }
    }

    // id 1046
    // 大顶堆
    public int lastStoneWeight(int[] stones) {
        int len = stones.length;
        if (len == 0) return 0;
        if (len == 1) return stones[0];
        if (len == 2) return Math.abs(stones[0] - stones[1]);
        int nonZero = len;
        buildMaxHeap4lastStoneWeight(stones, len);
        while (true) {
            if (nonZero == 0) {
                return 0;
            } else if (nonZero == 1) {
                return stones[0];
            } else {
                int i = 0;
                int left = 1;
                int right = 2;
                if (stones[left] > stones[right]) {
                    stones[i] = stones[i] - stones[left];
                    stones[left] = 0;
                } else {
                    stones[i] = stones[i] - stones[right];
                    stones[right] = 0;
                }
                nonZero--;
                if (stones[i] == 0) nonZero--;
                buildMaxHeap4lastStoneWeight(stones, len);
            }
        }
    }

    private void buildMaxHeap4lastStoneWeight(int[] nums, int len) {
        for (int i = (len >> 1) - 1; i >= 0; i--) {
            adjustMaxHeap4lastStoneWeight(nums, i, len);
        }
    }

    private void adjustMaxHeap4lastStoneWeight(int[] nums, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;
        if (left < len && nums[left] > nums[max]) {
            max = left;
        }
        if (right < len && nums[right] > nums[max]) {
            max = right;
        }
        if (max != i) {
            swap(nums, max, i);
            adjustMaxHeap4lastStoneWeight(nums, max, len);
        }
    }

    // 快排 分治
    public void quicksort(int[] nums, int left, int right) {
        int key, i, j;

        if (left >= right) return;

        key = nums[left];
        i = left;
        j = right;

        while (i < j) {

            while (nums[j] >= key && i < j) {
                j--;
            }

            while (nums[i] <= key && i < j) {
                i++;
            }

            swap(nums, i, j);
        }

        nums[left] = nums[i];
        nums[i] = key;

        quicksort(nums, left, j - 1);
        quicksort(nums, j + 1, right);
    }

}
