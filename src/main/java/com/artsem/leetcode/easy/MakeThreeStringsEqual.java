package com.artsem.leetcode.easy;

public class MakeThreeStringsEqual {
    public static int findMinimumOperations(String s1, String s2, String s3) {
        if(s1.equals(s2) && s1.equals(s3)){
            return 0;
        }
        if(s1.charAt(0) != s2.charAt(0) || s1.charAt(0) != s3.charAt(0)){
            return -1;
        }
        int index = 0;
        int minStrLength = s1.length()<s2.length() ?
                Math.min(s1.length(), s3.length()) : Math.min(s2.length(), s3.length());
        while(index<minStrLength){
            if(s1.charAt(index) != s2.charAt(index) || s1.charAt(index) != s3.charAt(index)){
                break;
            }
            index++;
        }
        return s1.length()+s2.length()+s3.length() - index*3;
    }
}
