package com.artsem.leetcode.easy;

public class ValidWord {
    public boolean isValid(String word) {


        return false;
    }

    private boolean isMinChar(String word){
        return word.length()>2;
    }

    private boolean containsOnlyDigitsAndLett(String word){

        return false;
    }

    private boolean containsVowel(String word){
        for (char c : word.toCharArray()){
            if(isVowel(c)) return true;
        }
        return false;
    }

    private boolean containsConsonant(String word){
        for (char c : word.toCharArray()){
            if(isConsonant(c)) return true;
        }
        return false;
    }

    private boolean isConsonant(char ch)
    {
        // To handle lower case
        ch = Character.toUpperCase(ch);

        return !(ch == 'A' || ch == 'E' ||
                ch == 'I' || ch == 'O' ||
                ch == 'U') && ch >= 65 && ch <= 90;
    }
    public static boolean isVowel(char c) {
        String vowels = "aeiouAEIOU";
        return vowels.contains(c+"");
    }
}
