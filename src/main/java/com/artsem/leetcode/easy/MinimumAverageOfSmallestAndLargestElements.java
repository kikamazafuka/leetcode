package com.artsem.leetcode.easy;

import java.util.Arrays;

public class MinimumAverageOfSmallestAndLargestElements {
    public double minimumAverage(int[] nums) {
        double res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0, j=nums.length-1; i<j; i++,j--){
            double curr = (double)(nums[i]+nums[j])/2;
            res = Math.min(res, curr);
        }
        return res;
    }
}
