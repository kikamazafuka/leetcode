package com.artsem.leetcode.easy;

public class MakeThreeStringsEqual {
    public int findMinimumOperations(String s1, String s2, String s3) {
        if(s1.equals(s2) && s1.equals(s3)){
            return 0;
        }
        int index = 0;
        int minStrLength = 0;
        int maxStrLength = 0;
        while(index<minStrLength){
            if(s1.charAt(index) != s2.charAt(index) || s1.charAt(index) != s3.charAt(index)){
                break;
            }
            index++;
        }
        return maxStrLength - index;
    }
}
