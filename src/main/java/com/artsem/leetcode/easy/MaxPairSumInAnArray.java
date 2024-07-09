package com.artsem.leetcode.easy;

public class MaxPairSumInAnArray {

    public static int maxSum(int[] nums) {
        int res = -1;
        for( int i = 0; i<nums.length-1; i++){
            int maxDigCurr = Integer.MIN_VALUE;
            int temp = nums[i];
            while(temp>0){
                int currDig = temp%10;
                maxDigCurr = Math.max(maxDigCurr, currDig);
                temp/=10;
            }
            for(int j = i+1; j<nums.length; j++){
                int maxDigNext = Integer.MIN_VALUE;
                int tempJ = nums[j];
                while(tempJ>0){
                    int currDig = tempJ%10;
                    maxDigNext = Math.max(maxDigNext, currDig);
                    tempJ/=10;
                }
                if(maxDigCurr == maxDigNext){
                    res = Math.max(res,nums[i]+nums[j]);
                }
            }
        }
        return res;
    }
}
