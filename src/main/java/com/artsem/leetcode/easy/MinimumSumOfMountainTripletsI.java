package com.artsem.leetcode.easy;

public class MinimumSumOfMountainTripletsI {
    public static int minimumSum(int[] nums) {
        int minSum = Integer.MAX_VALUE;
        boolean flag = true;
        for(int i = 0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                if(nums[i]<nums[j]) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[j] > nums[k]) {
                            minSum = Math.min(minSum, nums[i] + nums[j] + nums[k]);
                            flag = false;
                        }
                    }
                }
            }
        }
        if(flag){
            return -1;
        }
        return minSum;
    }
}
