package com.artsem.leetcode.easy;

import java.util.HashMap;

public class CountPairsThatFormACompleteDayI {
    public int countCompleteDayPairs(int[] hours) {
        int res = 0;
        for(int i = 0; i<hours.length; i++){
            for(int j = i+1; j<hours.length; j++){
                int currHours = hours[i]+hours[j];
                if(currHours%24==0){
                    res++;
                }
            }
        }
        return res;
    }

    public int countCompleteDayPairsMap(int[] hours) {
        HashMap<Integer, Integer> remainderCount = new HashMap<>();
        int count = 0;
        for (int hour : hours) {
            int remainder = hour % 24;
            if (remainder == 0) {
                count += remainderCount.getOrDefault(0, 0);
            } else {
                count += remainderCount.getOrDefault(24 - remainder, 0);
            }
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }
        return count;
    }
}
