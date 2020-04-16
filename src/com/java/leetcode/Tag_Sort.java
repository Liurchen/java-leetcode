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
                    nums[pre] ^= nums[i];
                    nums[i] ^= nums[pre];
                    nums[pre] ^= nums[i];
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
            if (min != i) {
                // 用异或交换需要注意 两边不能相等
                // 相等会得到0
                nums[i] ^= nums[min];
                nums[min] ^= nums[i];
                nums[i] ^= nums[min];
            }
        }
    }

    private void print(int[] nums) {
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
