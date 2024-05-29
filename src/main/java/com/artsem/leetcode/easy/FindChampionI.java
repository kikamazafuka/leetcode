package com.artsem.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class FindChampionI {
    public static int findChampion(int[][] grid) {
        int n = grid.length;
        Map<Integer, Integer> map = new HashMap<>();
        for( int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(grid[j][i] == 1 && i!=j){
                    map.put(j,map.getOrDefault(j,0)+1);
                }
            }
        }
        int max = 0;
        int res = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue()>max){
                res = entry.getKey();
                max = entry.getValue();
            }
        }
        return res;
    }
}
