package com.java.leetcode;

public class Tag_Binary {

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

}
