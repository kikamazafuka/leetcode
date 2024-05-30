package com.artsem.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class FindTheKorOfAnArray {
    public static int findKOrMap(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int bit = 0;
            while(nums[i]>0){
                int currBit = nums[i]&1;
                if(currBit==1){
                    map.put(bit, map.getOrDefault(bit,0)+1);
                }
                bit++;
                nums[i] >>= 1;
            }
        }
        int [] res = new int [32];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue()>=k){
                res[entry.getKey()] = 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = res.length-1; i>=0; i--){
            sb.append(res[i]);
        }
        return Integer.valueOf(sb.toString(),2);
    }

    public static int findKOr(int[] nums, int k) {

        int [] res = new int [32];
        for(int i = 0; i<nums.length; i++){
            int bit = 0;
            while(nums[i]>0){
                int currBit = nums[i]&1;
                if(currBit==1){
                   res[bit]++;
                }
                bit++;
                nums[i] >>= 1;
            }
        }
        for(int i = 0; i<res.length; i++){
            if(res[i]>=k){
                res[i] = 1;
            } else res[i] = 0;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = res.length-1; i>=0; i--){
            sb.append(res[i]);
        }
        return Integer.valueOf(sb.toString(),2);
    }

    public int findKOrBitwiseConvert(int[] nums, int k) {

        int [] res = new int [32];
        for(int i = 0; i<nums.length; i++){
            int bit = 0;
            while(nums[i]>0){
                int currBit = nums[i]&1;
                if(currBit==1){
                    res[bit]++;
                }
                bit++;
                nums[i] >>= 1;
            }
        }
        int ans = 0;
        for (int i = 0; i<res.length; i++){
            if(res[i]>=k){
                ans += (1<<i);
            }
        }
        return ans;
    }
}
