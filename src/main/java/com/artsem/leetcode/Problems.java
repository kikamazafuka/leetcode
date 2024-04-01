package com.artsem.leetcode;

import java.io.*;
import java.util.*;

public class Problems {
    public static void main(String[] args) {

        String dirname = "/leetcode";
        File dir = new File(dirname);

        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(19);

        TreeNode cloned = new TreeNode(7);
        cloned.left = new TreeNode(4);
        cloned.right = new TreeNode(3);
        cloned.right.left = new TreeNode(6);
        cloned.right.right = new TreeNode(19);

        Calendar calendar = Calendar.getInstance();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
    }

    public static int maxProfit(int[] prices, int fee) {
        int buy = 0;
        int sell = 0;
        int profit = 0;
        int i = 0;
        int n = prices.length - 1;
        boolean flag = true;

        while(i<n){
            while(i<n && prices[i] > prices[i+1] && flag){
                i++;
                flag = true;
            }
            if (flag) {
                buy = prices[i];
            }
            while(!flag || (i<n && prices[i] < prices[i+1])){
                i++;
                flag = true;
            }
            sell = prices[i];
            int currProf = (sell-buy)-fee;
            if(currProf<=0){
                flag = false;
                continue;
            }
            profit += (sell - buy) - fee;
        }
        return profit;
    }
    public static int maxProfit(int[] prices) {
        int i = 0, buy, sell, profit = 0, N = prices.length - 1;
        while (i < N) {
            while (i < N && prices[i + 1] <= prices[i]){
                i++;
            }
            buy = prices[i];
            while (i < N && prices[i + 1] > prices[i]){
                i++;
            }
            sell = prices[i];
            profit += sell - buy;
        }
        return profit;
    }
    public static int[] twoSum_bs(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int low = i + 1;
            int high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (numbers[i] + numbers[j] != target) {
            if (numbers[i] + numbers[j] < target) {
                i++;
            } else j--;
        }
        return new int[]{i + 1, j + 1};
    }

    public static int removeDuplicates(int[] nums) {

        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static String addBinary(String a, String b) {

        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            res.insert(0, sum % 2);
            carry = sum / 2;
        }
        return res.toString();
    }
}