package com.artsem.leetcode.hard;

import java.util.Arrays;

public class ReducingDishes {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        Arrays.sort(satisfaction);
        int sum = satisfaction[n-1];
        int oldAns = satisfaction[n-1];
        int newAns = oldAns;
        for(int i = n-2; i>=0; i--){
            sum += satisfaction[i];
            oldAns = oldAns + sum;
            if(oldAns>newAns){
                newAns = oldAns;
            }
        }
        return Math.max(newAns, 0);
    }

    public int maxSatisfactionRef(int[] satisfaction) {
        int n = satisfaction.length;
        Arrays.sort(satisfaction);
        int sum = 0;
        int oldAns = 0;
        int newAns = 0;
        for(int i = n-1; i>=0; i--){
            sum += satisfaction[i];
            oldAns += sum;
            newAns = Math.max(newAns, oldAns);
        }
        return newAns;
    }
}
