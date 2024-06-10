package com.artsem.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class ClearDigits {
    public String clearDigitsCharactersMeth(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                //if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                sb.deleteCharAt(sb.length()-1);
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    public static String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                sb.deleteCharAt(sb.length()-1);
            }else sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static String clearDigitsSet(String s) {
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                set.add(i-1);
            }
        }
        for(int i = 0; i<s.length(); i++){
            if (set.contains(i) || Character.isDigit(s.charAt(i))){
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
