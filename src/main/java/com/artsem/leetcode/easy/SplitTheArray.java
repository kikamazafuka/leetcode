package com.artsem.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class SplitTheArray {
    public boolean isPossibleToSplit(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        for (int val : map.values()){
            if (val>2)return false;
        }
        return true;
//        map.values().stream().findFirst(i -> i>2);

    }
}
