package com.artsem.leetcode.easy;

public class FindIndicesWithIndexAndValueDifferenceI {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        for(int i = 0; i<nums.length; i++){
            for(int j = i; j<nums.length; j++){
                if(Math.abs(i-j)>=indexDifference && Math.abs(nums[i] - nums[j])>=valueDifference){
                    return new int []{i,j};
                }
            }
        }
        return new int []{-1,-1};
    }
    public int[] findIndicesOnePass(int[] A, int d, int v) {
        int mini = 0, maxi = 0, n = A.length;
        for (int i = d; i < n; i++) {
            if (A[i - d] < A[mini]) mini = i - d;
            if (A[i - d] > A[maxi]) maxi = i - d;
            if (A[i] - A[mini] >= v) return new int[] {mini, i};
            if (A[maxi] - A[i] >= v) return new int[] {maxi, i};
        }
        return new int[] { -1, -1};
    }
}
