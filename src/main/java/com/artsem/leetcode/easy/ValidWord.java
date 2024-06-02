package com.artsem.leetcode.easy;

public class ValidWord {

    public static boolean isValid(String word) {
        return isMinChar(word) && containsVowelandConsonant(word) && containsOnlyDigitsAndLett(word);
    }

    private static boolean isMinChar(String word){
        return word.length()>2;
    }

    private static boolean containsOnlyDigitsAndLett(String word){
        for(char c : word.toCharArray()){
            if(!((c>=48 && c<=57) || (c>=65 && c<=90) || (c>=97 && c<=122))){
                return false;
            }
        }
        return true;
    }

    public boolean isAlphanumeric(String word) {
        for (char c : word.toCharArray()) {
            if (!((c >= '0' && c <= '9') ||
                    (c >= 'A' && c <= 'Z') ||
                    (c >= 'a' && c <= 'z'))) {
                return false;
            }
        }
        return true;
    }


    private static boolean containsVowelandConsonant(String word){
        boolean vowel = false;
        boolean consonant = false;
        for (char c : word.toCharArray()){
            if(isVowel(c)) vowel = true;
            if(isConsonant(c)) consonant = true;
        }
        return vowel && consonant;
    }

    private boolean containsConsonant(String word){
        for (char c : word.toCharArray()){
            if(isConsonant(c)) return true;
        }
        return false;
    }

    private static boolean isConsonant(char ch)
    {
        // To handle lower case
        ch = Character.toUpperCase(ch);

        return !(ch == 'A' || ch == 'E' ||
                ch == 'I' || ch == 'O' ||
                ch == 'U') && ch >= 65 && ch <= 90;
    }
    public static boolean isVowel(char ch) {
        String vowels = "aeiouAEIOU";
        return vowels.contains(ch+"");
    }
}
