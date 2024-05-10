package com.artsem.leetcode.easy;

public class MinimumNumberOfPushesToTypeWordI {
    public static int minimumPushes(String word) {
        int res = 0;
        int incr = 1;
        int count = 0;
        for(int i = 0; i<word.length(); i++){
            count++;
            res += incr;
            if(count >= 8){
                incr++;
                count = 0;
            }
        }
        return res;
    }
}
