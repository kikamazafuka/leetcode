package com.artsem.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UtilityClass {

    public static boolean isVowel(String c) {
        String vowels = "aeiouAEIOU";
        return vowels.contains(c);
    }
    public static int getUserChoice(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int choice;
        try {
            choice = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return choice;
    }
}
