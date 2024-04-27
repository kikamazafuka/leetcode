package com.artsem.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class CountTheNumberOfSpecialCharactersI {
    public int numberOfSpecialCharsArr(String word) {
        int res = 0;
        int [] a = new int[26];
        int [] b = new int[26];
        for(char c : word.toCharArray()){
            if (c>='a' && c<='z'){
                a[c - 'a']++;
            } else {
                b[c - 'A']++;
            }
        }
        for (int i = 0; i<a.length; i++){
            if (a[i] != 0 && b[i] != 0){
                res++;
            }
        }
        return res;
    }

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
