package com.artsem.leetcode.easy;

public class LargestLocalValuesInAMatrix {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] res = new int [n-2][m-2];
        for(int k = 1; k<n-1; k++){
            for(int l = 1; l<n-1; l++){
                int max = Integer.MIN_VALUE;
                for(int i = k-1; i<=k+1; i++){
                    for(int j = l-1; j<=l+1; j++){
                        max = Math.max(max, grid[i][j]);
                    }
                }
                res[k-1][l-1] = max;
            }
        }
        return res;
    }
}
