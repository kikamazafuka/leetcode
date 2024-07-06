package com.artsem.leetcode.easy;

public class CheckIfBitwiseORHasTrailingZeros {
    public static boolean hasTrailingZeros(int[] nums) {
        for(int i = 0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                String s = Integer.toBinaryString(nums[i] | nums[j]);
                if(s.charAt(s.length()-1)== '0'){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean hasTrailingZerosModulo(int[] nums) {
        int n = nums.length; // Number of elements in the array `nums`

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // Check if any pair of elements' bitwise OR results in a number with trailing zeros (even number)
            for (int j = 0; j < n; j++) {
                if (i != j && (nums[i] | nums[j]) % 2 == 0) {
                    return true; // Return true if such a pair is found
                }
            }
        }
        return false;
    }
}
