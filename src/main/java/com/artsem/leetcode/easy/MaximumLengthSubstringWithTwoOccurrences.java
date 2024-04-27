package com.artsem.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class MaximumLengthSubstringWithTwoOccurrences {
    public static int maximumLengthSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int res = 0;
        int currLen = 0;
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);

            if(map.get(s.charAt(i)) > 2){
                while (map.get(s.charAt(i))>2){
                    map.put(s.charAt(l), map.get(s.charAt(l))-1);
                    l++;
                    currLen--;
                }
            }
            currLen++;
            res = Math.max(res, currLen);
        }
        return res;
    }
}
