package com.artsem.leetcode.easy;

public class DivisibleAndNonDivisibleSumsDifference {
    public int differenceOfSums(int n, int m) {
        int num1 = 0;
        for(int i = 1; i<n+1; i++){
            if(i%m!=0){
                num1+=i;
            } else {
                num1-=i;
            }
        }
        return num1;
    }
}
