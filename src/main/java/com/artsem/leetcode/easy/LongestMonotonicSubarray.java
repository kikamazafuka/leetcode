package com.artsem.leetcode.easy;

class LongestMonotonicSubarray {
    public int longestMonotonicSubarray(int[] nums) {
        int maxLen = 1;
        int currInc = 1;
        int currDec = 1;
        for(int i = 0; i<nums.length-1; i++){
            if(nums[i]<nums[i+1]){
                currInc++;
                maxLen = Math.max(maxLen, currInc);
            } else currInc = 1;
            if(nums[i]>nums[i+1]){
                currDec++;
                maxLen = Math.max(maxLen, currDec);
            } else currDec = 1;
        }
        return maxLen;
    }
}
