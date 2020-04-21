package com.java.leetcode;

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

}
