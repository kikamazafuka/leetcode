package com.artsem.leetcode.easy;

import java.util.Arrays;

public class RelativeSortArray {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int [] res = new int [arr1.length];
        int index = 0;
        for(int i = 0; i<arr2.length; i++){
            for(int j = 0; j<arr1.length; j++){
                if(arr1[j] == arr2[i]){
                    res[index++] = arr1[j];
                    arr1[j] = -1;
                }
            }
        }
        int [] elem = new int[arr1.length - index];
        int elemInd = 0;
        for (int num : arr1) {
            if (num != -1) {
                elem[elemInd++] = num;
            }
        }
        Arrays.sort(elem);
        for (int j : elem) {
            res[index++] = j;
        }
        return res;
    }
}
