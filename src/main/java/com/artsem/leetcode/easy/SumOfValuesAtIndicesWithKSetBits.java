package com.artsem.leetcode.easy;

import java.util.List;

public class SumOfValuesAtIndicesWithKSetBits {
    public static int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int res = 0;
        for (int i = 0; i<nums.size(); i++) {
            int bitsNum = Integer.bitCount(i);
            if (bitsNum == k) {
                res += nums.get(i);
            }
        }
        return res;
    }
}
