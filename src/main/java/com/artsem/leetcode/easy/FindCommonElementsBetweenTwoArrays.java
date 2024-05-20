package com.artsem.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class FindCommonElementsBetweenTwoArrays {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        int count1 = 0;
        int count2 = 0;
        for(int num : nums1){
            set1.add(num);
        }
        for(int num : nums2){
            set2.add(num);
        }
        for(int num : nums2){
            if(set1.contains(num)) count2++;
        }
        for(int num : nums1){
            if(set2.contains(num)) count1++;
        }
        return new int [] {count1,count2};
    }
}
