package com.artsem.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class MaximumLengthSubstringWithTwoOccurrences {
    public int maximumLengthSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int res = 0;
        for(int i = 0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
            if(map.get(s.charAt(i)) < 2){
                r++;
                res++;
            } else {
                map.put(s.charAt(l), map.get(s.charAt(l)-1));
                l++;
                res--;
            }
        }
        return res;
    }
}
