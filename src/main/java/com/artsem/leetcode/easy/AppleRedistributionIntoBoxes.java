package com.artsem.leetcode.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class AppleRedistributionIntoBoxes {
    public static int minimumBoxes(int[] apple, int[] capacity) {

        int [] sortedArr = Arrays.stream(capacity).boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        int applesNum = Arrays.stream(apple).sum();

        int res = 0;
        for (int i = 0; i < sortedArr.length; i++) {
            if (applesNum<=0){
                return res;
            }
            applesNum -=sortedArr[i];
            res++;
        }
        return res;
    }


}
