package com.artsem.leetcode.easy;

public class SpecialArrayI {
    public boolean isArraySpecial(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i] % 2 == 0 && nums[i + 1] % 2 == 0)
                    || (nums[i] % 2 != 0 && nums[i + 1] % 2 != 0)) {
                return false;
            }
        }
        return true;
    }

    public boolean isArraySpecialRef(int[] nums) {
        for(int i = 0; i<nums.length-1; i++){
            if(nums[i]%2==nums[i+1]%2)return false;
        }
        return true;
    }

    public boolean isArraySpecialXOR(int[] nums) {
        for(int i = 0; i<nums.length-1; i++){
            if(((nums[i]&1) ^ (nums[i+1]&1)) == 0)return false;
        }
        return true;
    }
}
