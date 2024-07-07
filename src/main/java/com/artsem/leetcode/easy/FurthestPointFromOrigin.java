package com.artsem.leetcode.easy;

public class FurthestPointFromOrigin {
    public int furthestDistanceFromOrigin(String moves) {
        int countR = 0;
        int countL = 0;
        int countSpace = 0;
        for(char c : moves.toCharArray()){
            if(c == 'L'){
                countL++;
            } else if(c == 'R'){
                countR++;
            } else countSpace++;
        }
        int temp = Math.abs(countL-countR);
        return temp+countSpace;
    }
}
