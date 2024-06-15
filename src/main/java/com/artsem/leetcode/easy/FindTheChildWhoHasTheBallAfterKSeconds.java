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

    public int numberOfChildMath(int n, int k) {

        return (k / --n & 1) > 0 ? n - k % n : k % n;
    }

    public int numberOfChildIE(int n, int k) {
        n--; // Decrement n to simplify calculation (so range is now 0 to n-1)
        int rounds = k / n; // Calculate the number of complete back-and-forth trips
        int rem = k % n; // Calculate the remaining steps after the last complete trip

        if (rounds % 2 == 0) {
            // If the number of complete back-and-forth trips is even
            return rem; // The ball is passed forward from the start
        } else {
            // If the number of complete back-and-forth trips is odd
            return n - rem; // The ball is passed backward from the end
        }
    }
}
