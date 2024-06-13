package com.artsem.leetcode.easy;

public class FindTheChildWhoHasTheBallAfterKSeconds {
    public int numberOfChild(int n, int k) {
        int count = 0;
        boolean flag = true;
        int position = 0;
        while(count<k){
            if(position==n-1){
                flag = false;
            }
            if(position==0){
                flag = true;
            }
            if(flag){
                position++;
            } else {
                position --;
            }
            count++;
        }
        return position;
    }
}
