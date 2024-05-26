package com.artsem.leetcode.easy;

public class FindTheNumberOfGoodPairsI {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int count = 0;
        for (int value : nums1) {
            for (int i : nums2) {
                if (value % (i * k) == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
