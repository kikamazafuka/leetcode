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

    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]!=val){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0, j = 0; i<nums1.length && j<nums2.length;){
            if(nums1[i]==nums2[j]){
                res.add(nums1[i]);
                i++;
                j++;
                continue;
            }
            if(nums1[i]<nums2[j]){
                i++;
            }else if (nums1[i]>nums2[j]){
                j++;
            }

        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> l = new ArrayList<>();

        for(int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        for(int n : map.values()){
            if(n>1) return true;
        }
        return false;
    }
    public static int[] rotate(int[] nums, int k) {
        int[] res = new int[nums.length];
        for(int i = 0; i< nums.length; i++){
            int newInd = i + k%nums.length;
            if (newInd< nums.length){
                res[newInd] = nums[i];
            } else {
                newInd -= nums.length;
                res[newInd] = nums[i];
            }
        }
        System.arraycopy(res, 0, nums, 0, nums.length);
        return res;
    }
    public static String greatestLetter(String s) {
        char gr = Character.MIN_VALUE;
        for(char c : s.toCharArray()){
            char cap = (char) (c - ' ');
            if(s.indexOf(cap)!=-1){
                if(cap>gr){
                    gr = cap;
                }
            }
        }
        return gr>'\u0000' ? String.valueOf(gr) : "";
    }
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i<arr.length-1; i++){
            int diff = arr[i+1] - arr[i];
            if (diff < min) {
                min = diff;
                res.clear();
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            } else if (diff == min) {
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        return res;
    }
    public long findTheArrayConcValString(int[] nums) {
        long res = 0;
        for (int i = 0, j = nums.length - 1; i <= j; i++, j--) {
            long mult = i != j ? (long) Math.pow(10, String.valueOf(nums[j]).length()) : 0;
            res += nums[i] * mult + nums[j];
        }
        return res;
    }
    public static long findTheArrayConcVal(int[] nums) {
        long res = 0;
        long mult;
        for(int i = 0, j = nums.length-1; i<=j; i++,j--){
            if (i!=j){
                mult = nums[j]<10 ? 10 : nums[j]<100 ? 100 : nums[j]<1000 ?1000 : nums[j]<10000 ? 10000 : 100000;
            } else mult = 0;
            res +=  nums[i] * mult + nums[j];
        }
        return res;
    }
    public static boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int dif = arr[1] - arr[0];
        for(int i = 0; i<arr.length-1; i++){
            if(arr[i+1]-arr[i]!=dif){
                return false;
            }
        }
        return true;
    }
    public static int buyChoco(int[] prices, int money) {
        int ans = Integer.MAX_VALUE;
        int fin;
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < prices.length; j++) {
                if (i != j ) {
                    int sum = prices[i] + prices[j];
                    ans = Math.min(ans, sum);
                }
            }
        }
        fin = money - ans;
        if(fin>=0){
            return fin;
        }
        else{
            return money;
        }
    }
    public static int buyChocoSort(int[] prices, int money) {
//        Arrays.sort(prices);
        for(int i = 0; i<prices.length; i++){
            for(int j = i + 1; j<prices.length; j++){
                if(prices[i]+prices[j]<=money){
                    return money - prices[i] - prices[j];
                }
            }
        }
        return money;
    }
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        //distance[i][j] is the distance converse word1(1~ith) to word2(1~jth)
        int[][] distance = new int[len1 + 1][len2 + 1];
        for (int j = 0; j <= len2; j++)
        {distance[0][j] = j;} //delete all characters in word2
        for (int i = 0; i <= len1; i++)
        {distance[i][0] = i;}

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) { //ith & jth
                    distance[i][j] = distance[i - 1][j - 1];
                } else {
                    distance[i][j] = Math.min(Math.min(distance[i][j - 1], distance[i - 1][j]), distance[i - 1][j - 1]) + 1;
                }
            }
        }
        return distance[len1][len2];

    }
    public static int maxProfit1(int[] prices) {
        int profit = 0;
        int currProf = 0;
        int N = prices.length;
        int buy  = Integer.MAX_VALUE;
        for (int i=0;i<N;i++){
            if (prices[i]<buy){
                buy = prices[i];
            }
            currProf = prices[i] - buy;
            if(currProf>profit){
                profit = currProf;
            }
        }
        return profit;
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