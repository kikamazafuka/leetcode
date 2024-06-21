package com.artsem.leetcode.easy;

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
}
