package com.artsem.leetcode.easy;

public class MakeASquareWithTheSameColor {
    public boolean canMakeSquare(char[][] grid) {
        for(int i = 0; i<grid.length-1; i++){
            for(int j = 0; j<grid[0].length-1; j++){
                if(grid[i][j] == grid[i+1][j] && grid[i][j] == grid[i+1][j+1]) return true;
                if(grid[i][j+1] == grid[i+1][j] && grid[i][j+1] == grid[i+1][j+1]) return true;
                if(grid[i][j] == grid[i][j+1] && grid[i][j] == grid[i+1][j+1]) return true;
                if(grid[i][j] == grid[i][j+1] && grid[i][j] == grid[i+1][j]) return true;
            }
        }
        return false;
    }
}
