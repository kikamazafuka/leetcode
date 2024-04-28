package com.artsem.leetcode.easy;

import java.util.Arrays;

public class FindTheSumOfEncryptedIntegers {
    public static int sumOfEncryptedInt(int[] nums) {
        for(int i = 0; i<nums.length; i++){
            int maxDigit = 0;
            int newNum = 0;
            int num = nums[i];
            int count = 0;
            while(num>0){
                int digit = num % 10;
                maxDigit = Math.max(maxDigit, digit);
                num /= 10;
                count++;
            }
            while(count>0){
                newNum = newNum * 10 + maxDigit;
                count--;
            }
            nums[i] = newNum;
        }
        return Arrays.stream(nums).sum();
    }
}
