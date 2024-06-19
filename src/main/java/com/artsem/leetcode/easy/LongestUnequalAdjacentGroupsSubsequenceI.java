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

    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        int prev = -1;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (groups[i] != prev) {
                prev = groups[i];
                ans.add(words[i]);
            }
        }
        return ans;
    }
}
