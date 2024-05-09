package com.artsem.leetcode.easy;

public class MinimumNumberOfPushesToTypeWordI {
    public static int minimumPushes(String word) {
        int res = 0;
        int incr = 1;
        int count = 1;
        for(int i = 0; i<word.length(); i++){
            if(count > 8){
                incr++;
                count = 0;
            }
            count++;
            res += incr;
        }
        return res;
    }
}
