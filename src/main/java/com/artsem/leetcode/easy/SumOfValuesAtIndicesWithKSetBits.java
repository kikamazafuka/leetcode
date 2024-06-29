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

    public static int sumIndicesWithKSetBitsManipulation(List<Integer> nums, int k) {
        int res = 0;
        for (int i = 0; i<nums.size(); i++) {
            int temp = i;
            int bitCount = 0;
            while (temp != 0) {
                bitCount += temp & 1; // Add the least significant bit
                temp >>= 1;
            }
            if (bitCount == k) {
                res += nums.get(i);
            }
        }
        return res;
    }
}
