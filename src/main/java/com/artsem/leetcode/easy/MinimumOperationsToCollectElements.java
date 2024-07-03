package com.artsem.leetcode.easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumOperationsToCollectElements {
    public static int minOperations(List<Integer> nums, int k) {
        int res = k==1?1:k*(k+1)/2 - k;
        int count = 0;
        for(int i = nums.size()-1; i>=0; i--){
            int temp = nums.get(i);
            if(nums.get(i)<k){
                res-=temp;
            }
            count++;
            if(res==0) break;
        }
        return count;
    }

    public int minOperationsSet(List<Integer> nums, int k) {
        Set<Integer> st = new HashSet<>();
        for(int i=nums.size()-1; i>=0; --i){
            if(nums.get(i)<=k){
                st.add(nums.get(i));
                if (st.size() == k) return nums.size() -i;
            }
        }
        return nums.size();
    }
}
