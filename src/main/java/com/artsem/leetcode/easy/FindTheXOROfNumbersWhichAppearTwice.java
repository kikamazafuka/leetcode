package com.artsem.leetcode.easy;

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
}
