package com.artsem.leetcode.easy;

import java.util.Arrays;

public class FindTheXOROfNumbersWhichAppearTwice {
    public static int duplicateNumbersXOR(int[] nums) {
        int [] map = new int[51];
        int res = 0;
        for (int num : nums) {
            map[num]++;
        }

        for(int i = 0; i<map.length; i++){
            if(map[i]==2){
                res ^=i;
            }
        }
        return res;
    }

    public int duplicateNumbersXORSort(int[] nums) {
        int xor=0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == nums [i+1]){
                xor^=nums[i];
                i++;
            }
        }
        return xor;
    }
}
