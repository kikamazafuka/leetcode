package com.artsem.leetcode.easy;

import java.util.*;

public class MaxPairSumInAnArray {

    public static int maxSum(int[] nums) {
        int res = -1;
        for( int i = 0; i<nums.length-1; i++){
            int maxDigCurr = Integer.MIN_VALUE;
            int temp = nums[i];
            while(temp>0){
                int currDig = temp%10;
                maxDigCurr = Math.max(maxDigCurr, currDig);
                temp/=10;
            }
            for(int j = i+1; j<nums.length; j++){
                int maxDigNext = Integer.MIN_VALUE;
                int tempJ = nums[j];
                while(tempJ>0){
                    int currDig = tempJ%10;
                    maxDigNext = Math.max(maxDigNext, currDig);
                    tempJ/=10;
                }
                if(maxDigCurr == maxDigNext){
                    res = Math.max(res,nums[i]+nums[j]);
                }
            }
        }
        return res;
    }

    public int maxSumMap(int[] nums) {
        int ans = -1;
        Map<Integer, List<Integer>> ump = new HashMap<>();
        for(int i = 0; i < nums.length; ++i){
            int t = nums[i], maxDigit = 0;
            while(t != 0){ //evaluate max digit in the number
                maxDigit = Math.max(t%10, maxDigit);
                t = t/10;
            }
            if(!ump.containsKey(maxDigit)) ump.put(maxDigit, new ArrayList<>());
            ump.get(maxDigit).add(nums[i]); // add the number to the map
        }
        for(Map.Entry<Integer, List<Integer>> entry: ump.entrySet()){
            entry.getValue().sort(Comparator.reverseOrder()); //to find max two number in each max digit
            if(entry.getValue().size() >= 2) ans = Math.max(ans, entry.getValue().get(0) + entry.getValue().get(1)); //sum max two number and take max
        }
        return ans;
    }
}
