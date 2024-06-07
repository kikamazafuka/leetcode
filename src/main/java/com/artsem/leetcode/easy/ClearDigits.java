package com.artsem.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class ClearDigits {
    public static String clearDigits(String s) {
        StringBuilder sb = new StringBuilder(s);
        for(int i = 1; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                sb.deleteCharAt(i);
                sb.deleteCharAt(i-1);
            }
        }
        return sb.toString();
    }

    public String clearDigitsSet(String s) {
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                set.add(i-1);
            }
        }
        for(int i = 0; )
    }
}
