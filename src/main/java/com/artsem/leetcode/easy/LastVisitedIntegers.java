package com.artsem.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class LastVisitedIntegers {
    public static List<Integer> lastVisitedIntegers(int[] nums) {
        List<Integer> seen = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int k = 0;
        for (int num : nums) {
            if (num == -1) {
                k++;
                if (k <= seen.size()) {
                    ans.add(seen.get(k - 1));
                }
                if (k > seen.size()) {
                    ans.add(-1);
                }
            }
            if (num > 0) {
                k = 0;
                seen.add(0, num);
            }

        }
        return ans;
    }
}
