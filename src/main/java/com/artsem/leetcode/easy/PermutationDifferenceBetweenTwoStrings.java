package com.artsem.leetcode.easy;

public class PermutationDifferenceBetweenTwoStrings {
    public int findPermutationDifference(String s, String t) {
        int count = 0;
        for(char c : s.toCharArray()){
            count += Math.abs(s.indexOf(c)-t.indexOf(c));
        }
        return count;
    }
}
