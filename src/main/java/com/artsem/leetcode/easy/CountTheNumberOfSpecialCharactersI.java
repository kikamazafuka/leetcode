package com.artsem.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class CountTheNumberOfSpecialCharactersI {
    public int numberOfSpecialChars(String word) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        for(char c : word.toCharArray()){
            set.add(c);
        }

        for(char c : set){
            if (Character.isLowerCase(c) && set.contains(Character.toTitleCase(c))){
                res++;
            }
        }
        return res;
    }
}
