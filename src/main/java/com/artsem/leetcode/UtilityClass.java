package com.artsem.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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
    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minInd = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minInd]) {
                    minInd = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minInd];
            arr[minInd] = temp;
        }
    }

    /** Bubble sort **/
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    /** Binary Search **/
    private static int binarySearch(int[]nums, int num){
        int l = 0;
        int r = nums.length-1;
        Arrays.sort(nums);
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid]==num){
                return num*2;
            }
            if(nums[mid]<num){
                l=mid+1;
            } else r=mid-1;
        }
        return -1;
    }
}
