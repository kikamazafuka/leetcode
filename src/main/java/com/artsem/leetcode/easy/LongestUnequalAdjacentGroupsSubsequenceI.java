package com.artsem.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequenceI {
    public static List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> res = new ArrayList<>();
        res.add(words[0]);
        int prev = groups[0];
        for(int i = 1; i<words.length; i++){
            int curr = groups[i];
            if(prev!=(curr)){
                res.add(words[i]);
                prev = curr;
            }
        }
        return res;
    }
}
