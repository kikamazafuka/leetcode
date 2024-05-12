package com.artsem.leetcode.easy;

public class DivideAnArrayIntoSubarraysWithMinimumCostI {
    public int minimumCost(int[] nums) {
        int res = nums[0];
        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int index = 0;
        for(int i = 1; i<nums.length; i++){
            if(nums[i]<min) {
                min = nums[i];
                index = i;
            }
        }
        res += min;
        for(int i = 1; i<nums.length; i++){
            if(nums[i] < min2 && i!=index){
                min2 = nums[i];
            }
        }
        res += min2;
        return res;
    }
}
