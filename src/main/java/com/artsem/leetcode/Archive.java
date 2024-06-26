package com.artsem.leetcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.artsem.leetcode.UtilityClass.isVowel;

public class Archive {

    public static int minFlips(int a, int b, int c) {
//        String aBin = Integer.toBinaryString(a);
//        String bBin = Integer.toBinaryString(b);
//        String cBin = Integer.toBinaryString(c);
//        int length = Math.max(aBin.length(),bBin.length());
//        int maxLength = Math.max(length,cBin.length());
//        int count = 0;
//        aBin = addLeadingZeros(aBin,maxLength);
//        bBin = addLeadingZeros(bBin,maxLength);
//        cBin = addLeadingZeros(cBin,maxLength);
//
//        for (int i = 0; i<maxLength; i++){
//
//            if ((Character.getNumericValue(aBin.charAt(i))
//                    | Character.getNumericValue(bBin.charAt(i))) != Character.getNumericValue(cBin.charAt(i))){
//                count++;
//            }
//        }
//        return count;
        int flips = 0;
        while (a > 0 || b > 0 || c > 0) {
            int bitA = a & 1;
            int bitB = b & 1;
            int bitC = c & 1;

            if (bitC == 0) {
                flips += (bitA + bitB);
            } else {
                if (bitA == 0 && bitB == 0) {
                    flips += 1;
                }
            }

            a >>= 1;
            b >>= 1;
            c >>= 1;
        }

        return flips;
    }
    private static String addLeadingZeros(String binaryString, int desiredLength) {
        // Use String.format to add leading zeros
        return String.format("%" + desiredLength + "s", binaryString).replace(' ', '0');
    }
    public static int[] countBits1(int n) {
        int [] nums = new int [n+1];
        for(int i = 0; i<=n; i++){
            nums[i] = nums[i>>1] + (i & 1);
        }
        return nums;
    }
    public static int singleNumber(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int num : nums){
//            map.put(num, map.getOrDefault(num, 0)+1);
//        }
//        for(Map.Entry mapEntry : map.entrySet()){
//            if((int)mapEntry.getValue()==1){
//                return (int)mapEntry.getKey();
//            }
//        }
        /******************/
//        Arrays.sort(nums);
//        for(int i = 0; i<nums.length-1; i+=2){
//            if(nums[i]!=nums[i+1]){
//                return nums[i];
//            }
//        }
//        return -1;
        int xor = 0;
        for(int num : nums){
            xor ^=num;
        }
        return xor;
    }
    public static String predictPartyVictory(String senate) {
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
        int n = senate.length();
        for(int i = 0; i<n; i++){
            if(senate.charAt(i) == 'R')r.add(i);
            else d.add(i);
        }
        while(!r.isEmpty() && !d.isEmpty()){
            int r_index = r.poll();
            int d_index = d.poll();
            if(r_index < d_index){
                r.add(r_index + n);
            } else d.add(d_index + n);
        }
        return r.size() > d.size() ? "Radiant" : "Dire";
    }

    public static String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<s.length();i++){
            if (sb.length()!=0 && Math.abs(sb.charAt(sb.length() - 1) - s.charAt(i)) == 32) {
                sb.setLength(sb.length()-1);
            }else sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static boolean backspaceCompare(String s, String t) {
        StringBuilder st1 = new StringBuilder();
        StringBuilder st2 = new StringBuilder();
        backspace(s, st1);
        backspace(t, st2);

        return st1.toString().equals(st2.toString());
    }
    private static void backspace(String t, StringBuilder st2) {
        for(char c : t.toCharArray()){
            if (c=='#' && st2.length()==0){
                continue;
            }
            if(c=='#' && st2.length()>0){
                st2.deleteCharAt(st2.length()-1);
            } else st2.append(c);
        }
    }

    public static String removeStars(String s) {
//        Stack<Character> st = new Stack<>();
//        for (char c : s.toCharArray()) {
//            if (c != '*') {
//                st.push(c);
//            } else if (!st.isEmpty())st.pop();
//        }
//        StringBuilder sb = new StringBuilder();
//        for (char c : st) {
//            sb.append(c);
//        }
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()){
            if(c=='*' && sb.length()>0){
                sb.deleteCharAt(sb.length()-1);
            }else sb.append(c);
        }
        return sb.toString();
    }

    public static int equalPairs(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                for (int k = 0; k < grid[i].length; k++) {
                    if (grid[i][k] != grid[k][j]) {
                        break;
                    }
                    if (grid[i][k] == grid[k][j] && k == grid[i].length - 1) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i), 0) + 1);
            map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0) + 1);
        }
        if (map1.size() != map2.size()) {
            return false;
        }
        for (char c : map1.keySet()) {
            if (!map2.containsKey(c)) {
                return false;
            }
        }
        List<Integer> sortedValues1 = new ArrayList<>(map1.values());
        List<Integer> sortedValues2 = new ArrayList<>(map2.values());
        Collections.sort(sortedValues1);
        Collections.sort(sortedValues2);
        if (!sortedValues1.equals(sortedValues2)) {
            return false;
        }
//        int[] chars1 = map1.keySet().stream().mapToInt(Character::charValue).toArray();
//        int[] chars2 = map2.keySet().stream().mapToInt(Character::charValue).toArray();
//        Arrays.sort(chars1);
//        Arrays.sort(chars2);
//        for (int i = 0; i < chars1.length; i++) {
//            if (chars1[i] != chars2[i]) {
//                return false;
//            }
//        }
//        int[] nums1 = map1.values().stream().mapToInt(Integer::intValue).toArray();
//        int[] nums2 = map2.values().stream().mapToInt(Integer::intValue).toArray();
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        for (int i = 0; i < nums1.length; i++) {
//            if (nums1[i] != nums2[i]) {
//                return false;
//            }
//        }
        return true;
    }

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Integer> set = new HashSet<>(map.values());
        return map.size() == set.size();
//        map.forEach((key, value) -> set.add(value));
//        if (set.size()!=map.values().size()){
//            return false;
//        }
//        List<Integer> values = new ArrayList<>(map.values());
//        int [] nums = map.values().stream().mapToInt(Integer::intValue).toArray();
//        Arrays.sort(nums);
//        for (int i = 0; i<nums.length-1; i++){
//            if(nums[i]==nums[i+1]){
//                return false;
//            }
//        }
//        return true;
    }

    public static int compress(char[] chars) {
        if (chars.length == 1) return 1;
        int i = 0, j;
        int count = 1;
        for (j = 1; j <= chars.length; j++) {
            if (j != chars.length && chars[j] == chars[j - 1]) {
                count++;
            } else if (count > 1) {
                chars[i++] = chars[j - 1];
                String num = Integer.toString(count);
                for (int k = 0; k < num.length(); k++) {
                    chars[i++] = num.charAt(k);
                }
                count = 1;
            } else {
                chars[i++] = chars[j - 1];
            }
        }
        return i;
    }

    public static boolean increasingTriplet(int[] nums) {
//        int left = 0;
//        int count = 0;
//        for(int right = 0; right<nums.length-1; right++){
//            if(nums[right+1]>nums[right]){
//                count++;
//            }else if(nums[right]<nums[left]){
//                count = 0;
//                left++;
//            }
//            if(count == 2){
//                return true;
//            }
//        }
        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= small) {
                small = n;
            } else if (n <= big) {
                big = n;
            } else return true;
        }
        return false;
    }

    public static int[] productExceptSelf(int[] nums) {
//        int[] ans = new int[nums.length];
//        int prod = 1;
//        int zeroIndex = -1;
//        for(int i = 0; i<nums.length; i++){
//            if(nums[i] == 0){
//                zeroIndex = i;
//                continue;
//            }
//            prod *= nums[i];
//        }
//        for(int i = 0; i<nums.length; i++){
//            if(zeroIndex>0){
//                ans[i] = 0;
//            }else if(zeroIndex>=0 && nums[i]!=0){
//                ans[i] = 0;
//            } else if(nums[i]==0) {
//                ans[i] = prod;
//            } else if(nums[i]!=0){
//                ans[i] = (int) (prod * Math.pow(nums[i],-1));
//
//            } else ans[i] = 0;
//        }
//        return ans;

        int[] lefts = new int[nums.length];
        lefts[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            lefts[i] = nums[i - 1] * lefts[i - 1];
        }
        int right = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right = nums[i + 1] * right;
            lefts[i] *= right;
        }

        return lefts;

    }

    public static int longestSubarray(int[] nums) {
        int l = 0, r;
        int num = 1;
        for (r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                num--;
            }
            if (num < 0 && nums[l++] == 0) {
                num++;
            }
        }
        return r - l - 1;
    }

    public static int longestOnes(int[] nums, int k) {
//        int count = 0;
//        int max = 0;
//        int countK = 0;
//        for(int i = 0; i<nums.length; i++){
//            if(nums[i]==1){
//                count++;
//            } else if(countK < k){
//                countK++;
//                count++;
//            } else {
//                count = 0;
//                countK = 0;
//            }
//            if(max<count){
//                max = count;
//            }
//        }
//        return max;

        // 1,1,1,0,0,0,1,1,1,1,0

//        int count = 0;
//        int length = 0;
//        for(int i = 0; i<k; ){
//            if(nums[i]==0){
//                i++;
//            }
//            if(nums[i]==1){
//                count++;
//            }
//            length++;
//        }
//        return 1;
        int i = 0, j;
        for (j = 0; j < nums.length; ++j) {
            if (nums[j] == 0) k--;
            if (k < 0 && nums[i++] == 0) k++;
        }
        return j - i;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else count = 0;
            if (max < count) {
                max = count;
            }
        }
        return max;
    }

    public static int maxVowels(String s, int k) {
        int countVowels = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i) + "")) {
                countVowels++;
            }
        }
        int maxVowels = countVowels;
        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i) + "")) {
                countVowels++;
            }
            if (isVowel(s.charAt(i - k) + "")) {
                countVowels--;
            }
            if (maxVowels < countVowels) {
                maxVowels = countVowels;
            }
        }
        return maxVowels;
    }

    public static String reverseWordsMed(String s) {
        String[] strArr = s.split(" ");
        StringBuilder str = new StringBuilder();
        for (int i = strArr.length - 1; i >= 0; i--) {
            if (strArr[i].equals("")) {
                continue;
            }
            str.append(strArr[i].trim());
            str.append(" ");
        }
        return str.toString().trim();
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
//        for (int j : candies) {
//            boolean flag = false;
//            for (int candy : candies) {
//                if (j + extraCandies < candy) {
//                    res.add(false);
//                    flag = true;
//                    break;
//                }
//            }
//            if (flag) {
//                continue;
//            }
//            res.add(true);
//        }
        int maxCandy = Arrays.stream(candies).max().getAsInt();
        for (int candy : candies) {
            if (candy + extraCandies < maxCandy) {
                res.add(false);
            } else res.add(true);
        }

        return res;
    }

    public static int[] getAverages(int[] nums, int k) {
        int[] res = new int[nums.length];
        if (nums.length < k * 2 + 1) {
            Arrays.fill(res, -1);
            return res;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l < k) {
            res[l] = -1;
            res[r] = -1;
            l++;
            r--;
        }
        long sum = 0;
        for (int i = 0; i < 2 * k + 1; i++) {
            sum += nums[i];
        }
        long avr = sum / (2 * k + 1);
        res[l++] = (int) avr;
        int n = 2 * k + 1;
        for (int i = k; i < nums.length - k - 1; i++) {
            sum += nums[n++] - nums[i - k];
            res[l++] = (int) (sum / (2L * k + 1));
        }
        return res;
    }

    public static int[] readNumbersFromFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            if (line != null) {
                // Split the line by commas and convert each part to an integer
                String[] numberStrings = line.split(",");
                int[] numbers = new int[numberStrings.length];
                for (int i = 0; i < numberStrings.length; i++) {
                    numbers[i] = Integer.parseInt(numberStrings[i].trim());
                }
                return numbers;
            }
        }
        return new int[0];
    }

    public static double findMaxAverage(int[] nums, int k) {
//        double maxAvr = -100000;
//        for (int j = 0; j <= nums.length - k; j++) {
//            int sum = 0;
//            for (int i = j; i < k + j; i++) {
//                sum += nums[i];
//            }
//            double avr = (double) sum / k;
//            maxAvr = Math.max(maxAvr, avr);
////            list.add(avr);
//        }
////        return list.stream().max(Double::compare).get();
//        return maxAvr;

        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double maxAvr = sum / k;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            maxAvr = Math.max(maxAvr, sum / k);
        }
        return maxAvr;
    }

    public static int maxOperations(int[] nums, int k) {
        int count = 0;
        int l = 0;
        int r = nums.length - 1;
        Arrays.sort(nums);
        while (l < r) {
            if (nums[l] + nums[r] == k) {
                count++;
                r--;
                l++;
            } else if (nums[l] + nums[r] > k) {
                r--;
            } else l++;
        }
        return count;

      /*  for(int i = 0; i<nums.length; i++){
            for(int j = nums.length-1; j>i; j--){
                if(nums[i]+nums[j]==k){
                    count ++;
                    break;
                }
            }
        }
        return count;*/
    }

    public static int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int max = 0;
        int water = 0;
        while (leftIndex < rightIndex) {
            water = Math.min(height[leftIndex], height[rightIndex]) * (rightIndex - leftIndex);
            if (water > max) {
                max = water;
            }
            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++;
            } else rightIndex--;
        }
        return max;
    }

    public static boolean isSubsequence(String s, String t) {
        int i = 0;
        for (char c : t.toCharArray()) {
            if (s.charAt(i) == c) {
                i++;
            }
            if (i == s.length()) {
                return true;
            }
        }
        return false;
    }

    public static void moveZeroes(int[] nums) {
//        int snowBallSize = 0;
//        for (int i=0;i<nums.length;i++){
//            if (nums[i]==0){
//                snowBallSize++;
//            }
//            else if (snowBallSize > 0) {
//                nums[i-snowBallSize]=nums[i];
//                nums[i] = 0;
//            }
//        }
        int i = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[i++] = num;
            }
        }
        while (i < nums.length) {
            nums[i++] = 0;
        }
    }

    public static void moveZeroes1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] == 0) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
//        return nums;
    }

    public static String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = s.length() - 1; i < s.length(); i++, j--) {
            if (!isVowel("" + s.charAt(i))) {
                sb.append(s.charAt(i));
            }
            if (isVowel("" + s.charAt(j))) {
                sb.append(s.charAt(j));
            }

        }
        return sb.toString();
    }

    public static int numberOfPoints(List<List<Integer>> nums) {
        boolean[] arr = new boolean[100];
        for (List<Integer> subList : nums) {
            int n = subList.get(0);
            while (n <= subList.get(1)) {
                arr[n] = true;
                n++;
            }
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                count++;
            }
        }
        return count;
    }

    public static void mergeArrListInPlace(ArrayList<Integer> a, ArrayList<Integer> b) {
        int i = 0;
        int j = 0;
        while (i < a.size() && j < b.size()) {
            if (a.get(i) < b.get(j)) {
                i++;
            } else a.add(i, b.get(j++));
        }
        while (j < b.size()) {
            a.add(b.get(j++));
        }
    }

    public static void mergeArrList(ArrayList<Integer> arrayList1, ArrayList<Integer> arrayList2) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < arrayList1.size() && j < arrayList2.size()) {
            if (arrayList1.get(i) < arrayList2.get(j)) {
                res.add(arrayList1.get(i++));
            } else res.add(arrayList2.get(j++));
        }
        while (i < arrayList1.size()) {
            res.add(arrayList1.get(i++));
        }
        while (j < arrayList2.size()) {
            res.add(arrayList2.get(j++));
        }
        for (int k = 0; k < res.size(); k++) {
            if (k < arrayList1.size()) {
                arrayList1.set(k, res.get(k));
            } else arrayList1.add(res.get(k));
        }
    }

    public int minimizedStringLength(String s) {
        return (int) s.chars().distinct().count();
    }

    public static void mergeSortInPlace(int[] arr, int s, int e) {
        if (e - s == 1) {
            return;
        }
        int mid = arr.length / 2;
        mergeSortInPlace(arr, s, mid);
        mergeSortInPlace(arr, mid, e);
        mergeInPlace(arr, s, mid, e);
    }

    private static void mergeInPlace(int[] arr, int s, int mid, int e) {
        int[] mix = new int[e - s];
        int i = s;
        int j = mid;
        int k = e;
        while (i < mid && j < e) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i++];
            } else mix[k] = arr[j++];
            k++;
        }
        while (i < mid) {
            mix[k++] = arr[i++];
        }
        while (j < e) {
            mix[k++] = arr[j++];
        }
        for (int l = 0; l < mix.length; l++) {
            arr[s + l] = mix[l];
        }
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    private static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                mix[k] = first[i++];
            } else mix[k] = second[j++];
            k++;
        }

        while (i < first.length) {
            mix[k++] = first[i++];
        }
        while (j < second.length) {
            mix[k++] = second[j++];
        }
        return mix;
    }

    public int maximumStrongPairXor(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) <= Math.min(nums[i], nums[j])) {
                    int cur = nums[i] ^ nums[j];
                    if (cur > max) {
                        max = cur;
                    }
                    // map.put(nums[i], nums[j]);
                }
            }
        }
        return max;
    }

    public static int hammingDistance(int x, int y) {
        int r = x ^ y;
        String str = Integer.toBinaryString(r);
        int count = 0;
        for (char binChar : str.toCharArray()) {
            if (binChar == '1') {
                count++;
            }

        }
        return count;
    }

    public static int countSetBits(int n) {
        int count = 0;

        // Count the set bits using bitwise AND operation
        while (n > 0) {
            count += n & 1; // Check the rightmost bit
            n >>= 1; // Shift to the right
        }

        return count;
    }

    public static int calPoints(String[] operations) {
        List<Integer> ls = new ArrayList<>();
//        for (String operation : operations) {
//            if (operation.charAt(0) >= '0' && operation.charAt(0) <= '9'
//                    || operation.charAt(0)=='-') {
//                ls.add(Integer.parseInt(operation));
//                continue;
//            }
//            char c = operation.charAt(0);
//            switch (c) {
//                case '+' -> ls.add(ls.get(ls.size() - 1) + ls.get(ls.size() - 2));
//                case 'D' -> ls.add(ls.get(ls.size() - 1) * 2);
//                case 'C' -> ls.remove(ls.size() - 1);
//            }
//        }
        for (String o : operations) {
            switch (o) {
                case "+" -> ls.add(ls.get(ls.size() - 1) + ls.get(ls.size() - 2));
                case "D" -> ls.add(ls.get(ls.size() - 1) * 2);
                case "C" -> ls.remove(ls.size() - 1);
                default -> ls.add(Integer.parseInt(o));
            }
        }
        int sum = 0;
        for (Integer num : ls) {
            sum += num;
        }
//        for(String o : operations){
//            try{
//                int num = Integer.parseInt(o);
//                ls.add(num);
//            } catch (NumberFormatException e){
//                char c = o.charAt(0);
//                switch (c) {
//                    case '+' -> ls.add(ls.get(ls.size() - 1) + ls.get(ls.size() - 2));
//                    case 'D' -> ls.add(ls.get(ls.size() - 1) * 2);
//                    case 'C' -> ls.remove(ls.size() - 1);
//                }
//            }
//        }

        return sum;
//        return ls.stream().reduce(0, Integer::sum);
    }
    public static List<Integer> collectToListWhichAreNotPresent(int[] nums1, int[] nums2) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    break;
                }
                if (j == nums2.length - 1 && nums2[j] != nums1[i]) {
                    resultList.add(nums1[i]);
                }
            }
        }
        return resultList;
    }

    public static int countGoodRectangles(int[][] rectangles) {
//        int [] arr = new int[rectangles.length];
//        for(int i = 0; i<rectangles.length; i++){
//            for(int j = 0; j<1; j++){
//                arr[i]=Math.min(rectangles[i][j], rectangles[i][j+1]);
//            }
//        }
//        Arrays.sort(arr);
//        int count = 0;
//        for(int i = 0; i<arr.length; i++){
//            if(arr[i]==arr[arr.length-1]){
//                count++;
//            }
//        }
        int sqLen = 0;
        int count = 1;
        for (int i = 0; i < rectangles.length; i++) {
            int curr = Math.min(rectangles[i][0], rectangles[i][1]);
            if (sqLen == curr) {
                count++;
            }
            if (sqLen < curr) {
                sqLen = curr;
                count = 1;
            }
        }
        return count;
    }

    public int sumOfSquares(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums.length % (i + 1) == 0) {
                res += Math.pow(nums[i], 2);
            }
        }
        return res;
    }

    public static int minOperations2(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                count += nums[i] - nums[i + 1] + 1;
                nums[i + 1] += nums[i] - nums[i + 1] + 1;
            }
        }
        return count;
    }

    public static int commonFactors(int a, int b) {
        int max = Math.max(a, b);
        int count = 0;
        for (int i = 1; i <= max; i++) {
            if (a % i == 0 && b % i == 0) {
                count++;
            }
        }
        return count;
    }

    public int minOperations(int[] nums) {

        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length - 1];
        if (max - min == nums.length - 1 && isUnique(nums)) {
            return 0;
        }
        return -1;
    }

    private static boolean isUnique(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String firstPalindrome(String[] words) {
//        for(String str : words){
//            if(str.length()==1){
//                return str;
//            }
//            for(int i = 0; i<str.length()/2; i++){
//                if(str.charAt(i)!=str.charAt(str.length()-1-i)){
//                    break;
//                }
//                if(str.charAt(i)==str.charAt(str.length()-1-i) && i==str.length()/2-1){
//                    return str;
//                }
//            }
//        }
        ///***///
//        for(String str : words){
//            StringBuilder sb = new StringBuilder(str);
//            if(str.equals(sb.reverse().toString())){
//                return str;
//            }
//        }
        ///***///
        for (String str : words) {
            if (isPalindrome(str)) {
                return str;
            }
        }
        return "";
    }

    private static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
//        int result = arrivalTime+delayedTime;
//        if(result>=24){
//            return result-24;
//        }
//        return result;
        return arrivalTime + delayedTime >= 24 ?
                arrivalTime + delayedTime - 24 : arrivalTime + delayedTime;
    }

    public static String mergeAlternately(String word1, String word2) {
//        StringBuilder sb = new StringBuilder();
//        String greaterWord = word1.length()>word2.length() ? word1 :word2;
//        int length = Math.min(word1.length(), word2.length());
//        int count = 0;
//        for(int i = 0; i<length; i++){
//            sb.append(word1.charAt(i)).append(word2.charAt(i));
//            count++;
//        }
//        if (word1.length()!=word2.length()){
//            sb.append(greaterWord.substring(count));
//        }
//
//        return sb.toString();

        StringBuilder sb = new StringBuilder();
        int length = Math.max(word1.length(), word2.length());
        for (int i = 0; i < length; i++) {
            if (i < word1.length()) {
                sb.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                sb.append(word2.charAt(i));
            }
        }
        return sb.toString();
    }

    public static int countPairs(int[] nums, int k) {
//        int count = 0;
//        for(int i = 0; i<nums.length; i++){
//            for(int j = i+1; j<nums.length; j++){
//                if(nums[i]==nums[j] && (i*j)%k==0){
//                    count++;
//                }
//            }
//        }
//        return count;

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int result = 0;

        for (int i = 0; i < nums.length; i++) {

            map.putIfAbsent(nums[i], new ArrayList<Integer>());
            ArrayList<Integer> list = map.get(nums[i]);

            for (int num : list) {
                if (num * i % k == 0) {
                    result++;
                }
            }
            list.add(i);
        }
        return result;
    }

    public static String freqAlphabets(String s) {
        Map<String, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        char c = 'a';
        for (int i = 1; i <= 26; i++) {
            if (i < 10) {
                map.put(i + "", String.valueOf((char) (c + (i - 1))));
            } else map.put(i + "#", String.valueOf((char) (c + (i - 1))));
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                String str = "" + (s.charAt(i - 2)) + (s.charAt(i - 1)) +
                        s.charAt(i);
                sb.append(map.get(str));
                i -= 2;
            } else sb.append(map.get("" + s.charAt(i)));
        }
        return sb.reverse().toString();
    }

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList();
        if (nums.length == 2 && nums[0] == nums[1]) {
            list.add(nums[0]);
            return list;
        }
        if (nums.length < 3) {
            return IntStream.of(nums).boxed().collect(Collectors.toList());
        }
        double a = nums.length / 3;
        for (int i = 0; i < nums.length; i++) {
            double count = 1.0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
                if (count > a) {
                    list.add(nums[i]);
                }
            }
        }
        return list;

    }

    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */
    class MyHashMap {

        LinkedList<Entry>[] list;

        public MyHashMap() {
            list = new LinkedList[16];
        }

        public void put(int key, int value) {
            int index = getIndex(key);
            if (list[index] == null) {
                list[index] = new LinkedList();
            }
            for (Entry entry : list[index]) {
                if (entry.key == key) {
                    entry.value = value;
                    return;
                }
            }

            list[index].add(new Entry(key, value));
        }

        public int get(int key) {
            int index = getIndex(key);
            LinkedList<Entry> linkList = list[index];
            if (linkList != null) {
                for (Entry entry : linkList) {
                    if (entry.key == key) {
                        return entry.value;
                    }
                }
            }
            return -1;
        }

        public void remove(int key) {
            int index = getIndex(key);
            LinkedList<Entry> linkList = list[index];
            if (linkList != null) {
                for (Entry entry : linkList) {
                    if (entry.key == key) {
                        linkList.remove(entry);
                    }
                }
            }
        }

        int getIndex(int key) {
            Integer obKey = key;
            if (key == 0) {
                return 0;
            }
            return obKey.hashCode() % 16;
        }

        private static class Entry {
            int key;
            int value;

            Entry(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length < 2) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j].charAt(i) != strs[j + 1].charAt(i)) {
                    if (sb.isEmpty()) {
                        return "";
                    } else return sb.toString();
                }
            }
            sb.append(strs[i].charAt(i));
        }
        return sb.toString();
    }

    public static String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (char c : word.toCharArray()) {
            sb.append(c);
            if (c == ch && flag) {
                sb.reverse();
                flag = false;
            }
        }
        return sb.toString();
    }
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int result = 0;
        //Map<String, String> resultMap = new HashMap<>();
        Map<String, String> map = new HashMap<>();
        map.put(ruleKey, ruleValue);
        for (List<String> nested : items) {
            Map<String, String> resultMap = new HashMap<>();
            for (String str : nested) {
                resultMap.put("type", str);
                switch (ruleKey) {
                    case "type":
                        if (str.equals(ruleValue)) {
                            result++;
                        }
                        break;
                    case "color":
                        if (str.equals(ruleValue)) {
                            result++;
                        }
                        break;
                    case "name":
                        if (str.equals(ruleValue)) {
                            result++;
                        }
                        break;
                }
            }
        }
        return result;
    }

//    public static int pivotInteger(int n) {
//        if (n == 1) {
//            return 1;
//        }
//        int i = 1;
//        int sum = n;
//        int count = 1;
//        while (count > 0) {
//            count = pivotIntegerRecursion(n - i);
//            sum += (n - i);
//            if (count == sum) {
//                return n - i;
//            }
//            i++;
//        }
//        return -1;
//    }

    public int minPartitions(String n) {
        char max = '0';
        for (char c : n.toCharArray()) {
            if (c > max) {
                max = c;
            }
        }
        return max - '0';
    }

    public static int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int[] arr = new int[2];
        for (Map.Entry entry : map.entrySet()) {
            if ((int) entry.getValue() % 2 != 0) {
                arr[1]++;
            }
            if ((int) entry.getValue() > 1) {
                arr[0] += (int) entry.getValue() / 2;
            }
        }
        return arr;
    }

    public static boolean judgeCircle(String moves) {
//        Map <Character, Integer> map = new HashMap<>();
//        for(int i = 0; i<moves.length(); i++){
//            map.put(moves.charAt(i), map.getOrDefault(moves.charAt(i), 0)+1);
//        }
//        if (map.size()%2!=0){
//            return false;
//        }
//        if (map.size()==4){
//            return (int)map.get('U')==(int)map.get('D') && (int)map.get('R')==(int)map.get('L');
//        }
//        if (map.containsKey('U') && (!map.containsKey('L') || !map.containsKey('R'))){
//            if (map.get('D')==null){
//                return false;
//            }
//            return (int)map.get('U')==map.get('D');
//        }
//        if (map.containsKey('R') && (!map.containsKey('U') || !map.containsKey('D'))){
//            if (map.get('L')==null){
//                return false;
//            }
//            return (int)map.get('R')==map.get('L');
//        }
//        return false;
        int u = 0;
        int d = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'D' -> ++u;
                case 'U' -> --u;
                case 'R' -> ++d;
                case 'L' -> --d;
            }
        }
        return d == 0 && u == 0;

    }

    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < startTime.length; i++) {
            map.put(startTime[i], endTime[i]);
        }
        int count = 0;
        for (Map.Entry entry : map.entrySet()) {

            if ((int) entry.getKey() <= queryTime && (int) entry.getValue() >= queryTime) {
                count++;
            }
        }
        return count;
    }

    public static int[] rowAndMaximumOnes(int[][] mat) {
        int index = 0;
        int max = 0;
        int[] res = new int[2];
        for (int[] arr : mat) {
            int count = (int) Arrays.stream(arr).filter(n -> n == 1).count();
            if (count > max) {
                max = count;
                res[0] = index;
                res[1] = count;
            }
            index++;
        }
        return res;
    }

    public static int countSeniors(String[] details) {
//        List <Integer> ls = new ArrayList<>();
//        for(String s : details){
//            ls.add(Integer.valueOf(s.substring(11,13)));
//        }
//       return (int)(ls.stream().filter(i->i>60).count());
        int count = 0;
        for (String s : details) {
            if (Integer.parseInt(s.substring(11, 13)) > 60) {
                count++;
            }
        }
        return count;
    }

    public static int repeatedNTimes(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return nums[i];
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return -1;
    }

    public static String sortString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        while (Collections.max(map.values().stream().distinct().toList()) > 0) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (map.containsKey(c) && map.get(c) > 0) {
                    sb.append(c);
                    map.put(c, map.get(c) - 1);
                }
                if (sb.length() == s.length()) {
                    return sb.toString();
                }
            }
            for (char c = 'z'; c >= 'a'; c--) {
                if (map.containsKey(c) && map.get(c) > 0) {
                    sb.append(c);
                    map.put(c, map.get(c) - 1);
                }
            }
        }
        return sb.toString();
    }

    public static int[] sumZero(int n) {
        int[] arr = new int[n];
        int num = n;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            arr[i] = num;
            arr[j] = -arr[i];
            num--;
        }
        return arr;
    }

    public static int[] distinctDifferenceArray(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> prefix = new HashSet<>();
            Set<Integer> suffix = new HashSet<>();
            for (int j = 0; j <= i; j++) {
                prefix.add(nums[j]);
            }
            for (int k = i + 1; k < nums.length; k++) {
                suffix.add(nums[k]);
            }
            res[i] = prefix.size() - suffix.size();
        }
        return res;
    }

    public static int sumOfUnique(int[] nums) {

//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i<nums.length; i++){
//            for (int j = 0; j<nums.length; j++){
//                if (i!=j && nums[i]==nums[j]){
//                    break;
//                }
//                if (j==nums.length-1){
//                    list.add(nums[i]);
//                }
//            }
//        }
//        return list.stream().mapToInt(Integer::intValue).sum();

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else map.put(num, 1);
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                sum += entry.getKey();
            }
        }
//        List <Integer> ls = new ArrayList<>();
//        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
//            if (entry.getValue()==1){
//                ls.add(entry.getKey());
//            }
//        }
        return sum;

    }

    public static int[] finalPrices(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            answer[i] = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    answer[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return answer;
    }

    public static int sumBase(int n, int k) {

        String converted = Integer.toString(n, k);
        int res = 0;
        for (char c : converted.toCharArray()) {
            res += c - '0';
        }
        return res;
    }

    public boolean areOccurrencesEqual(String s) {
//        Set<Integer> res = new HashSet<>();
//        for(char c : s.toCharArray()){
//            int appear = 0;
//            for(int i = 0; i<s.length(); i++){
//                if(c==s.charAt(i)){
//                    appear++;
//                }
//            }
//            res.add(appear);
//        }
//        return res.size() == 1;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else map.put(c, 1);
        }
        Set<Integer> res = new HashSet<>(map.values());

        return res.size() == 1;
    }

    public int findNumbers(int[] nums) {

        int res = 0;
        for (int n : nums) {
            int digNum = 0;
            while (n > 0) {
                n /= 10;
                digNum++;
            }
            if (digNum % 2 == 0) {
                res++;
            }
        }
        return res;
    }

    public static String destCity(List<List<String>> paths) {

        Map<String, String> map = new HashMap<>();
        for (List<String> ls : paths) {
            map.put(ls.get(0), ls.get(1));
        }
        for (List<String> ls : paths) {
            if (!map.containsKey(ls.get(1))) {
                return ls.get(1);
            }
        }

        return "";
    }

    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
//                if(grid[i][j]<0){
//                    count++;
//                }
                if (grid[i][j] < 0) {
                    count += grid[i].length - j;
                    break;
                }
            }
        }
        return count;
    }

    public int[] findArray(int[] pref) {
        int[] result = new int[pref.length];
        result[0] = pref[0];
        for (int i = 0; i < pref.length - 1; i++) {
            result[i + 1] = pref[i] ^ pref[i + 1];
        }
        return result;
    }

    public void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }

    public static int findGCD(int[] nums) {
        int min = 1001;
        int max = 0;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
//        List<Integer> maxList = new ArrayList<>();
//        List<Integer> minList = new ArrayList<>();
//        int maxCount = 1;
//        while(maxCount<=max){
//            if(max%maxCount==0){
//                maxList.add(maxCount);
//            }
//            maxCount++;
//        }
//        int minCount = 1;
//        while(minCount<=min){
//            if(min%minCount==0){
//                minList.add(minCount);
//            }
//            minCount++;
//        }
        int gcd = 0;
        for (int i = 1; i < min; i++) {
            if (max % i == 0 && min % i == 0) {
                gcd = i;
            }
        }
        return gcd;
        //return maxList.stream().filter(minList::contains).mapToInt(v->v).max().orElse(-1);
    }

    public static int prefixCount(String[] words, String pref) {
//        int count = 0;
//        for(String word : words){
//            if(word.startsWith(pref)){
//                count++;
//            }
//        }
//        return count;
        return (int) Stream.of(words).filter(w -> w.startsWith(pref)).count();
    }

    public boolean halvesAreAlike(String s) {
        String left = s.substring(0, s.length() / 2);
        String right = s.substring(s.length() / 2, s.length());
//        int countLeft = 0;
//        int countRight = 0;
//        for(int i = 0; i<s.length()/2; i++){
//            if(isVowel(""+left.charAt(i))){
//                countLeft++;
//            }
//            if(isVowel(""+right.charAt(i))){
//                countRight++;
//            }
//        }
//        return countLeft==countRight;
        ///////////////////////////
//        return left.replaceAll("[^aeiouAEIOU]", "").length() ==
//                right.replaceAll("[^aeiouAEIOU]", "").length();
        ///////////////////////////
        String vowels = "aeiouAEIOU";
        int countLeft = 0;
        int countRight = 0;
        Set<Character> set = new HashSet<>();
        for (char c : vowels.toCharArray()) {
            set.add(c);
        }

        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (set.contains(s.charAt(i))) {
                countLeft++;
            }
            if (set.contains(s.charAt(j))) {
                countRight++;
            }
        }
        return countLeft == countRight;
    }

    public String generateTheString(int n) {
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i<n-1; i++){
//            sb.append("a");
//        }
//        if (n%2!=0){
//            sb.append("a");
//        } else sb.append("b");
//        return sb.toString();
        return n % 2 != 0 ? "a".repeat(n) : "b" + "a".repeat(n - 1);
    }

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            res[i] = Integer.bitCount(i);
        }
        return res;
    }

    public static int[] sortByBits(int[] arr) {

//        List<String> binList = new ArrayList<>();
//        for (int num : arr){
//            binList.add(Integer.toBinaryString(num));
//        }
//        Map <String, Integer> map = new TreeMap<>();
//        for (String str : binList){
//            int count = 0;
//            int bits = Integer.par(str,2);
//            for (char c : str.toCharArray()){
//                if (c=='1'){
//                  count++;
//                }
//            }
//
//            //str = String.format("%16s", str.replace(' ', '0'));
//            while (str.length()<16){
//                str = "0"+str;
//            }
//
//            map.put(str,count);
//        }
//
//        Set<String> res = map.keySet();
//        int [] result = new int [res.size()];
//        int i = 0;
//        for (String str : res){
//            result[i] = Integer.parseInt(str,2);
//            i++;
//        }
//        return result;

        String str = "str";
        Formatter fmt = new Formatter();
        fmt.format("%06d", str);
        str = String.format("%16s", str);
        for (int i = 0; i < arr.length; i++) {
            arr[i] += Integer.bitCount(arr[i]) * 10001;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] % 10001;
        }
        return arr;
    }

    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] item : items1) {
            map.put(item[0], item[1]);
        }
        for (int[] item : items2) {
            if (map.containsKey(item[0])) {
                map.put(item[0], map.get(item[0]) + item[1]);
            } else map.put(item[0], item[1]);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry mapEntry : map.entrySet()) {
            List<Integer> list = new ArrayList<>();
            list.add((Integer) mapEntry.getKey());
            list.add((Integer) mapEntry.getValue());
            result.add(list);
        }
        return result;
    }

    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result.add(i);
            }
        }
        return result;
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        int countOne = 0;
        int countPossibleFlower = 0;

        if (flowerbed[0] == 0) {
            for (int i = 0; i < flowerbed.length; i++) {
                if (flowerbed[i] == 1) {
                    countOne++;
                }
                if (i % 2 != 0 || i == 0) {
                    countPossibleFlower++;
                }
            }
            return countPossibleFlower - countOne >= n;
        } else {
            for (int i = 0; i < flowerbed.length; i++) {
                if (flowerbed[i] == 1) {
                    countOne++;
                }
                if (i % 2 == 0) {
                    countPossibleFlower++;
                }

            }
            return countPossibleFlower - countOne >= n;
        }
    }

    public int heightChecker(int[] heights) {
        int length = heights.length;
        int[] expected = new int[length];
        int count = 0;

        int[] sortedHeights = Arrays.copyOf(heights, length);
        Arrays.sort(sortedHeights);
        for (int i = 0; i < length; i++) {
            if (sortedHeights[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }

    public int[] sortArrayByParity(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int[] res = new int[nums.length];
        int begin = 0;
        int end = nums.length - 1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                res[begin] = nums[i];
                begin++;
            } else if (nums[i] % 2 != 0) {
                res[end] = nums[i];
                end--;
            }
        }
        return res;
    }

    public int findNonMinOrMax(int[] nums) {
        if (nums.length < 3) {
            return -1;
        }
        Arrays.sort(nums);
        return nums[1];
    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public static int deleteGreatestValue(int[][] grid) {
        if (grid[0].length == 1) {
            return grid[0][0];
        }
        int n = grid[0].length;
        int result = 0;
        while (n >= 1) {
            int max = 0;
            for (int[] row : grid) {
                //Arrays.sort(row);
                selectionSort(row);
                if (max < row[n - 1]) {
                    max = row[n - 1];
                }

            }
            result += max;
            n--;
        }
        return result;
    }

    public static int minimumSum(int num) {
//        // sort(num);
//        int [] arr = new int[4];
//        for(int i = 0 ; i<arr.length; i++){
//            arr[i]=num%10;
//            num/=10;
//        }
//        Arrays.sort(arr);


        int[] arr = new int[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = num % 10;
            num /= 10;
        }
        /** Selection sort **/
//        for(int i = 0; i<arr.length; i++){
//            int minInd = i;
//            for(int j = i+1; j<arr.length; j++){
//                if(arr[j]<arr[minInd]){
//                    minInd = j;
//                }
//            }
//            int temp = arr[minInd];
//            arr[minInd] = arr[i];
//            arr[i] = temp;
//        }

        /** Bubble sort **/
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return (arr[0] * 10 + arr[3]) + (arr[1] * 10 + arr[2]);
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minInd = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minInd]) {
                    minInd = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minInd];
            arr[minInd] = temp;
        }
    }

    public static String removeTrailingZeros(String num) {
        StringBuilder sb = new StringBuilder();
        for (int i = num.length() - 1; i >= 0; i--) {
            if (num.charAt(i) != '0') {

                sb.append(num.subSequence(0, i + 1));
                return sb.toString();
            }
        }
        return "";
    }

    public static boolean isSameAfterReversals(int num) {
        if (num == 0) {
            return true;
        }
        if (num % 10 == 0) {
            return false;
        }
        int numC = num;
        int reversedNum = 0;
        while (numC > 0) {
            reversedNum = reversedNum * 10 + numC % 10;
            numC /= 10;
        }
        int reversedResult = 0;
        while (reversedNum > 0) {
            reversedResult = reversedResult * 10 + reversedNum % 10;
            reversedNum /= 10;
        }
        return reversedResult == num;
    }

    public static TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return traverse(cloned, target);
    }

    private static TreeNode traverse(TreeNode node, TreeNode target) {
        if (node == null) {
            return null;
        }
        if (node.val == target.val) {
            return node;
        }
        TreeNode leftNode = traverse(node.left, target);
        TreeNode rightNode = traverse(node.right, target);
        if (leftNode != null) {
            return leftNode;
        }
        return rightNode;
    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        List<Integer> result = new ArrayList<>();
        traverse1(root, result, low, high);
        for (int num : result) {
            sum += num;
        }
        return sum;

    }

    private static void traverse1(TreeNode node, List<Integer> list, int low, int high) {
        if (node == null) {
            return;
        }
        if (low <= node.val && node.val <= high) {
            list.add(node.val);
        }
        traverse1(node.left, list, low, high);
        traverse1(node.right, list, low, high);
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
//        List<List<Integer>> resultList = new ArrayList<>();
//        List <Integer>  nums1List = new ArrayList<>(Arrays.stream(nums1).boxed().toList());
//        List <Integer>  nums1List2 = new ArrayList<>(Arrays.stream(nums1).boxed().toList());
//        List <Integer>  nums2List = new ArrayList<>(Arrays.stream(nums2).boxed().toList());
//        nums1List.removeAll(nums2List);
//        nums2List.removeAll(nums1List2);
//        List<Integer> collect1 = nums1List.stream().distinct().toList();
//        List<Integer> collect2 = nums2List.stream().distinct().toList();
//        resultList.add(collect1);
//        resultList.add(collect2);
//        return resultList;

//        List<List<Integer>> resultList = new ArrayList<>();
//        List <Integer>  nums1List = collectToListWhichAreNotPresent(nums1,nums2);
//        List <Integer>  nums2List = collectToListWhichAreNotPresent(nums2, nums1);
//
//        List<Integer> collect1 = nums1List.stream().distinct().toList();
//        List<Integer> collect2 = nums2List.stream().distinct().toList();
//        resultList.add(collect1);
//        resultList.add(collect2);
//        return resultList;

        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).filter(n -> !set1.contains(n)).boxed().collect(Collectors.toSet());
        Arrays.stream(nums2).forEach(set1::remove);
        return Arrays.asList(new ArrayList<>(set1), new ArrayList<>(set2));

    }
    public static int pivotIntegerRecursion(int n) {
        if (n > 0) {
            return n + pivotIntegerRecursion(n - 1);
        } else return 0;
    }

    public static String[] sortPeople(String[] names, int[] heights) {
        String[] result = new String[names.length];
        Map<Integer, String> map = new TreeMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }
        int i = 0;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            result[names.length - i - 1] = entry.getValue();
            i++;
        }
        return result;
    }

    public static int maximumNumberOfStringPairs(String[] words) {
        int count = 0;
//        for(int i = 0; i<words.length; i++){
//            for(int j = i+1; j<words.length; j++){
//
//                StringBuilder sb = new StringBuilder();
//                if (words[i].equals(sb.append(words[j]).reverse().toString())){
//                    count++;
//                }
//            }
//        }
        Set<String> set = new HashSet<>();
        for (String word : words) {
            String reverse = new StringBuilder(word).reverse().toString();
            if (set.contains(reverse)) {
                count++;
            }
            set.add(word);
        }
        return count;
    }

    public static String makeSmallestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        char[] sArr = s.toCharArray();
        for (int i = 0; i < s.length() / 2; i++) {
            if (sArr[i] < sArr[sArr.length - i - 1]) {
                sb.setCharAt(sArr.length - i - 1, sArr[i]);
            } else if (sArr[i] > sArr[sArr.length - i - 1]) {
                sb.setCharAt(i, sArr[sArr.length - i - 1]);
            }
        }
        return sb.toString();
    }

    public static int maxProduct(int[] nums) {
//        int max = 0;
//        int max2 = 0;
//        int index = 0;
//        for(int i = 0; i<nums.length; i++){
//            if(nums[i]>max){
//                max=nums[i];
//                index = i;
//            }
//        }
//        for(int i = 0; i<nums.length; i++){
//            if(nums[i]>max2 && nums[i]<=max && i != index){
//                max2= nums[i];
//            }
//        }
//        return (max-1)*(max2-1);
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }

    public static String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 != 0) {
                char cur = (char) (s.charAt(i - 1) + (s.charAt(i) - '0'));
                sb.append(cur);
            } else sb.append(s.charAt(i));

        }
        return sb.toString();
    }

//    public static int subsetXORSum(int[] nums) {
//        //int result = 0;
//        int total = 0;
//        List<List<Integer>> subsets = generateSubsets(nums);
//        subsets.sort(Comparator.comparing(List::size));
//        for (List<Integer> subset : subsets) {
//            int result = 0;
//            for (int num : subset) {
//                if (subset.size() == 1) {
//                    total += num;
//                    continue;
//                }
//                result ^= num;
//            }
//            total += result;
//        }
//        return total;
//    }

    public static List<List<Integer>> generateSubsets(int[] arr) {
        List<List<Integer>> subsets = new ArrayList<>();
        int n = arr.length;

        // Generate all possible binary numbers from 0 to 2^n - 1
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<>();

            // Check each bit of 'i' to determine inclusion in the subset
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(arr[j]);
                }
            }

            subsets.add(subset);
        }

        return subsets;
    }

    public static int countPoints(String rings) {
        int[] r = new int[10];
        int[] g = new int[10];
        int[] b = new int[10];
        for (int i = 0; i < rings.length(); i += 2) {
            if (rings.charAt(i) == 'R') {
                r[rings.charAt(i + 1) - '0']++;
            }
            if (rings.charAt(i) == 'G') {
                g[rings.charAt(i + 1) - '0']++;
            }
            if (rings.charAt(i) == 'B') {
                b[rings.charAt(i + 1) - '0']++;
            }
        }
        int result = 0;
        for (int i = 0; i < 10; i++) {
            if (r[i] > 0 && g[i] > 0 && b[i] > 0) {
                result++;
            }
        }
        return result;
    }

    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a
                            && Math.abs(arr[j] - arr[k]) <= b
                            && Math.abs(arr[i] - arr[k]) <= c) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public static int maxProductDifference(int[] nums) {
//        int max = 0;
//        int min = 100000;
//        boolean flagMax = true;
//        boolean flagMin = true;
//        for(int i : nums){
//            if(i>max){
//                max = i;
//            }
//            if(i<min){
//                min = i;
//            }
//        }
//        int count = 0;
//        int [] res = new int [nums.length-2];
//        for(int i : nums){
//            if(i!=max && i!=min || flagMax || flagMin){
//                res[count] = i;
//                count++;
//            }
//            if(i==max){
//                flagMax = false;
//            }
//            if(i==min){
//                flagMin = false;
//            }
//        }
//        int max2 = 0;
//        int min2 = 10000;
//        for(int i : res){
//            if(i>max2){
//                max2 = i;
//            }
//            if(i<min2){
//                min2 = i;
//            }
//        }
//        int result = max*max2 - min*min2;
//        return result;

//        int max = 0;
//        int min = 100000;
//        boolean flagMax = false;
//        boolean flagMin = false;
//        for(int i : nums){
//            if(i>max){
//                max = i;
//            }
//            if(i<min){
//                min = i;
//            }
//        }
        int count = 0;
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());

        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        list.remove(Integer.valueOf(max));
        list.remove(Integer.valueOf(min));
        Integer max2 = list.stream().max(Integer::compare).get();
        Integer min2 = list.stream().min(Integer::compare).get();
//        for(int i : nums){
//            if(i==max && !flagMax){
//                flagMax=true;
//                list.remove(count);
//            }
//            if(i==min && !flagMin){
//                flagMin=true;
//                if(count==nums.length-1){
//                    count--;
//                }
//                list.remove(count);
//            }
//            count++;
//
//        }
//        int [] res = new int [nums.length-2];
//
//        for(int i : nums){
//            if(i!=max && i!=min || flagMax || flagMin){
//                res[count] = i;
//                count++;
//            }
//            if(i==max){
//                flagMax = true;
//            }
//            if(i==min){
//                flagMin = true;
//            }
//        }
//        int max2 = 0;
//        int min2 = 10000;
//        for(int i : list){
//            if(i>max2){
//                max2 = i;
//            }
//            if(i<min2){
//                min2 = i;
//            }
//        }
        return max * max2 - min * min2;
    }

    public static int[][] flipAndInvertImage(int[][] image) {
        int[][] res = new int[image.length][image[0].length];
        for (int i = 0; i < image.length; i++) {
            int count = 0;
            for (int j = image[i].length - 1; j >= 0; j--) {
                res[i][count++] = image[i][j] ^ 1;
            }
        }
        return res;
    }

    public static String removeOuterParentheses(String s) {
        int balance = 0;
        boolean flag = true;
        StringBuilder curPrimit = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                balance += 1;
                flag = false;
                curPrimit.append(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                balance += -1;
                curPrimit.append(s.charAt(i));
            }
            if (balance == 0 && !flag) {
                flag = true;
                res.append(curPrimit.deleteCharAt(0).deleteCharAt(curPrimit.length() - 1));
                curPrimit = new StringBuilder();
            }
        }
        return res.toString();
    }

    public static int maxDepth(String s) {
        char[] sArr = s.toCharArray();
        int currentDepth = 0;
        int maxDepth = 0;
        int countLeft = 0;
        int countRight = 0;
        int balance = 0;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (balance == 0 && !flag) {
                countLeft = 0;
                countRight = 0;
                flag = true;
            }
            if (sArr[i] == '(') {
                countLeft++;
                balance += 1;
                flag = false;
            } else if (sArr[i] == ')') {
                countRight++;
                balance += -1;
            }
            //  if(sArr[i]!='(' && sArr[i]!=')'){
            currentDepth = countLeft - countRight;
            // }
            if (currentDepth > maxDepth) {
                maxDepth = currentDepth;
            }
        }
        return maxDepth;
    }

    public static int countAsterisks(String s) {
//        boolean flag = true;
//        StringBuilder sb = new StringBuilder();
//        for(char c : s.toCharArray()){
//            if(c=='|'){
//                flag=false;
//            }else flag=true;
//        }
        String[] strArr = s.split("\\|");
        StringBuilder sb = new StringBuilder();
        int count = 0;
//        boolean flag = true;
//        if(s.charAt(0)=='|'){
//            flag = false;
//        }
        for (String str : strArr) {
            if (count % 2 == 0 /*&& flag*/) {
                sb.append(str);
            }//else if(count%2!=0 && !flag)sb.append(str);
            count++;
        }
        return (int) sb.toString().chars().filter(c -> c == '*').count();
    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] strArr = s.split(" ");
        for (String str : strArr) {


        }
        return "";
    }

    public static int maximum69Number(int num) {
//        boolean flag=false;
//        String str = String.valueOf(num);
//        StringBuilder sb = new StringBuilder();
//        for(char c : str.toCharArray()){
//            if(c=='6' && !flag){
//                sb.append(9);
//                flag=true;
//            } else sb.append(c+"");
//        }
        return Integer.parseInt((num + "").replaceFirst("6", "9"));
        //return Integer.valueOf(sb.toString());
    }

    public static int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        // int [] altitudes = new int [gain.length+1];
        int currentAltitude = 0;
        //altitudes[0] = 0;
        for (int i = 0; i < gain.length; i++) {
            //altitudes[i+1] = altitudes[i] + gain[i];
            currentAltitude += gain[i];
            // if(maxAltitude<altitudes[i+1]){
            //   maxAltitude=altitudes[i+1];
            //}
            if (currentAltitude > maxAltitude) {
                maxAltitude = currentAltitude;
            }
        }
        return maxAltitude;
    }

    public static int minBitFlips(int start, int goal) {
        int binStart = Integer.parseInt(Integer.toString(start, 2));
        int binGoal = Integer.parseInt(Integer.toString(goal, 2));
//        if(binStart.length()>binGoal.length()){
//            int zeroNum = binStart.length()-binGoal.length();
//            while (zeroNum>0){
//                binGoal="0"+binGoal;
//                zeroNum--;
//            }
//        } else if (binStart.length()<binGoal.length()){
//            int zeroNum = binGoal.length()-binStart.length();
//            while (zeroNum>0){
//                binStart="0"+binStart;
//                zeroNum--;
//            }
//        }
//        int res = 0;
//        for(int i = 0; i<binStart.length(); i++){
//            if(binStart.charAt(i)!=binGoal.charAt(i)){
//                res++;
//            }
//        }
        int res = binStart ^ binGoal;
        return res;
    }

    public static int uniqueMorseRepresentations(String[] words) {
        String[] morseCode = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        char a = 'a';
        Map<String, String> morseTable = new HashMap<>();
        Set<String> set = new HashSet();
        for (int i = 0; i < morseCode.length; i++) {
            morseTable.put(a + "", morseCode[i]);
            a++;
        }
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(morseTable.get(word.charAt(i) + ""));
            }
            set.add(sb.toString());
        }
        return set.size();

    }

    public static String toLowerCase(String s) {
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] > 64 && c[i] < 91) {
                c[i] += 32;
            }
        }
        return String.valueOf(c);
    }

    public static int diagonalSum(int[][] mat) {
        int sum = 0;
        int dCount = mat.length - 1;
        for (int i = 0; i < mat.length; i++) {
            int j = i;
            sum += mat[i][j];
            if (mat.length % 2 != 0 && dCount == mat.length / 2) {
                dCount--;
                continue;
            }
            sum += mat[i][dCount];
            dCount--;
        }
        return sum;
    }

    public static int countKDifference(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    res++;
                }
            }
        }
        return res;
    }

    public static boolean checkIfPangram(String sentence) {
//        String alf = "thequickbrownfoxjumpsoverthelazydog";
//        String alf = "abcdefghijklmnopqrstuvwxyz";
//        if(sentence.length()<alf.length()){
//            return false;
//        }
//        for(int i = 0; i<alf.length(); i++){
//            for(int j = 0; j < sentence.length(); j++){
//                if(sentence.contains(alf.charAt(i)+"")){
//
//                }else return false;
//            }
//        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < sentence.length(); i++) {
            set.add(sentence.charAt(i));
        }

        return set.size() == 26;
    }

    public static boolean isAcronym(List<String> words, String s) {
        if (words.size() != s.length()) {
            return false;
        }
        s.contains("a");
        int count = 0;
        for (String str : words) {
            if (str.charAt(0) != s.charAt(count)) {
                return false;
            }
            count++;
        }
        return true;
    }

    public static String sortSentence(String s) {
        String[] sArr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        char c = '1';
        for (int i = 0; i < sArr.length; i++) {
            for (String str : sArr) {
                if (str.charAt(str.length() - 1) == c) {
                    sb.append(str, 0, str.length() - 1);
                    sb.append(" ");
                }
            }
            c++;
        }
        return sb.toString().trim();
    }

    /**
     * You are given a 0-indexed, strictly increasing integer array nums and a positive integer diff. A triplet (i, j, k)
     * is an arithmetic triplet if the following conditions are met:
     * <p>
     * i < j < k,
     * nums[j] - nums[i] == diff, and
     * nums[k] - nums[j] == diff.
     */
    public static int arithmeticTriplets(int[] nums, int diff) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                for (int k = j; k < nums.length; k++) {

                }
            }
        }
        return -1;
    }

    //    public static int sortDesc(final int num) {
//
//        String str = String.valueOf(num);
//
////        List<StringBuilder> stringBuilder = str.chars().sorted().mapToObj(String::new).collect(Collectors.toList());
//
//
//        int someNum = num;
//        while (someNum>0){
//            int digit = someNum%10;
//            someNum/=10;
//        }
//        //Your code
//    }
    public static int findCenter(int[][] edges) {
        int result = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] node : edges) {
            if (map.containsKey(node[0])) {

                result = node[0];
            }
            map.put(node[0], node[1]);
        }
        if (result == -1) {
            result = map.get(1);
        }
        return result;
    }

    public static int differenceOfSum(int[] nums) {

//        String str = Arrays.toString(nums).replaceAll("\\D+", "");
        int elemSum = 0;
        int digitSum = 0;
        for (int num : nums) {
            elemSum += num;
            while (num > 0) {
                digitSum += num % 10;
                num /= 10;
            }
        }
//        for (char c : str.toCharArray()){
//            digitSum+=Character.getNumericValue(c);
//        }
        return Math.abs(elemSum - digitSum);
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String word1Str = String.join(",", word1).replace(",", "");
        String word2Str = String.join(",", word2).replace(",", "");
        return word1Str.equals(word2Str);
    }

    public static int countDigits(int num) {
        int count = 0;
        int n = num;
        while (num > 0) {
            if (n % (num % 10) == 0) {
                count++;
            }
            num /= 10;
        }
        return count;
    }

    public static String decodeMessage(String key, String message) {
        key = key.replaceAll("\\s", "");
//        List<Character> uniqueKey = trKey.chars().distinct().mapToObj(c->(char)c)
//               .collect(Collectors.toList());

        StringBuilder result = new StringBuilder();
        char a = 'a';
        Map<Character, Character> susTable = new HashMap<>();
        for (int i = 0; i < key.length(); i++) {
            if (!susTable.containsKey(key.charAt(i))) {
                susTable.put(key.charAt(i), a++);
            }
//           char newChar = (char) ('a'+i);

        }
        for (char c : message.toCharArray()) {
            if (c == ' ') {
                result.append(" ");
                continue;
            }
            result.append(susTable.get(c));
        }
        return result.toString();
    }

    public static List<String> cellsInRange(String s) {
//        List<String> list = new ArrayList<>();
//        int n = Integer.parseInt(s.substring(4));
//        int c = s.charAt(3)-s.charAt(0);
//        char startChar = s.charAt(0);
//        char startNum = s.charAt(1);
//        for (int j =0; j<=c; j++) {
//            for (int i = 0; i < n; i++) {
//                StringBuilder stringBuilder = new StringBuilder();
//                char newChar = (char) (startChar+j);
//                char newCharNum = (char) (startNum+i);
//                if (newCharNum>s.charAt(4)){
//                    break;
//                }
//                stringBuilder.append(newChar);
//                stringBuilder.append(newCharNum);
//                list.add(stringBuilder.toString());
//            }
//        }
//        return list;
        List<String> list = new ArrayList<>();
        char cs = s.charAt(0);
        char ce = s.charAt(3);
        char rs = s.charAt(1);
        char re = s.charAt(4);
        for (char c = cs; c <= ce; c++) {
            for (char r = rs; r <= re; r++) {
                list.add("" + c + r);
            }
        }
        return list;
    }

    public static int task1(int n) {
        int result = 0;
        if (n > 0) {
            result = n * n;
        } else if (n < 0) {
            result = -n;
        }
        return result;
    }

    public static int sumOfFibonacciNumbers(int n) {
        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        int[] fibonacciNumbers = new int[n];
        fibonacciNumbers[0] = 0;
        fibonacciNumbers[1] = 1;
        int sum = fibonacciNumbers[0] + fibonacciNumbers[1];
        for (int i = 2; i < n; i++) {
            fibonacciNumbers[i] = fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2];
            sum += fibonacciNumbers[i];
        }
        return sum;
    }

    public static int[] twoSum(int[] nums, int target) {

        int[] twoSum = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    twoSum[0] = i;
                    twoSum[1] = j;
                    return twoSum;
                }
            }
        }
        return twoSum;
    }

    public static int[] twoSumMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int number = target - nums[i];
            if (map.containsKey(number) && map.get(number) != i) {
                return new int[]{i, map.get(number)};
            }
        }

        throw new IllegalArgumentException("Can't find a sum");

    }

    public static String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                sb.append("[.]");
            } else sb.append(address.charAt(i));
        }
        return sb.toString();
    }


    public static int theMaximumAchievableX(int num, int t) {
        return num + t + 1;
    }

    /**
     * Given an array of integers nums, return the number of good pairs.
     * A pair (i, j) is called good if nums[i] == nums[j] and i < j.
     **/
    public int numIdenticalPairs(int[] nums) {
        int numberOfGoodPairs = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    numberOfGoodPairs++;
                }
            }
        }
        return numberOfGoodPairs;
    }

    public static int[] getConcatenation(int[] nums) {

        int[] ans = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
            ans[i + nums.length] = nums[i];
        }
        return ans;
    }

    public static int[] buildArray(int[] nums) {

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

    public static int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for (String string : operations) {
            if (string.contains("-")) {
                res--;
            } else res++;
        }
        return res;
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] ans = new int[n * 2];
        for (int i = 0; i < nums.length; i += 2) {
            ans[i] = nums[i];
            ans[i + 1] = nums[i + n];
        }
        return ans;
    }

    public static int numJewelsInStones(String jewels, String stones) {
        char[] jewelsArr = jewels.toCharArray();
        char[] stonesArr = stones.toCharArray();
        int count = 0;
        for (int i = 0; i < jewels.length(); i++) {
            for (int j = 0; j < stones.length(); j++) {
                if (jewelsArr[i] == stonesArr[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static String interpret(String command) {
        StringBuilder result = new StringBuilder();
        char[] c = command.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'G') {
                result.append(c[i]);
            } else if (c[i] == '(' && c[i + 1] == ')') {
                result.append("o");
            } else if (c[i] == '(' && c[i + 1] == 'a') {
                result.append("al");
            }
        }
        return result.toString();
    }

    public static String interpretOne(String command) {
        return command.replace("()", "o").replace("(al)", "al");
    }

    public static int mostWordsFound(String[] sentences) {

        List<Integer> counts = new ArrayList<>();
        for (String str : sentences) {
            int count = 0;
            char[] c = str.toCharArray();
            for (int i = 0; i < str.length(); i++) {
                if (c[i] == ' ') {
                    count++;
                }
            }
            counts.add(count + 1);
        }
        return Collections.max(counts);
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }

    public static int subtractProductAndSum(int n) {
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            int c = n % 10;
            n /= 10;
            list.add(c);
        }
        int sum = list.stream().mapToInt(value -> value).sum();
        int prod = list.stream().mapToInt(value -> value)
                .reduce(1, (a, b) -> a * b);
        return prod - sum;
    }

    public static int[] leftRightDifference(int[] nums) {
        int[] answer = new int[nums.length];
        int[] leftSumArr = new int[nums.length];
        int[] rightSumArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int rightSum = 0;
            for (int j = i + 1; j < nums.length; j++) {
                rightSum += nums[j];
            }
            rightSumArr[i] = rightSum;
        }
        for (int i = 0; i < nums.length; i++) {
            int leftSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += nums[j];
            }
            leftSumArr[i] = leftSum;
        }
        for (int i = 0; i < nums.length; i++) {
            answer[i] = Math.abs(leftSumArr[i] - rightSumArr[i]);
        }
        return answer;
    }

//    public static final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
//        for (TreeNode node : cloned)
//        return target;
//    }

    public static void ckeckBool() {
        boolean bol = false;
        if (!bol) {
            System.out.println(bol);
        }
    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> target = new LinkedList<>();
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> indexList = Arrays.stream(index).boxed().collect(Collectors.toList());
        for (int i = 0; i < nums.length; i++) {
            target.add(indexList.get(i), numsList.get(i));
        }
        int[] result = target.stream().mapToInt(Integer::intValue)
                .toArray();
        return result;
    }

    public static int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            while (count < nums[2 * i]) {
                list.add(nums[2 * i + 1]);
                count++;
            }
            if (2 * i + 2 == nums.length) {
                break;
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static int balancedStringSplit(String s) {
        char[] arr = s.toCharArray();
        int result = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (arr[i] == 'L') {
                count++;
            } else count--;
            if (count == 0) {
                result++;
            }
        }
        return result;
    }

    public static int sumOfMultiples(int n) {
        int result = 0;
        for (int i = 3; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                result += i;
            }
        }
        return result;
    }

    public static int xorOperation(int n, int start) {
        int[] nums = new int[n];
        int result = 0;
        for (int i = 0; i < 0; i++) {
            nums[i] = start + 2 * i;
        }
        for (int i : nums) {
            result ^= i;
        }
        return result;
    }

    public static String restoreString(String s, int[] indices) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(' ');
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            list.set(indices[i], s.charAt(i));
        }
        return list.toString();
    }

    public static String restoreStringRef(String s, int[] indices) {
        char[] c = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            c[indices[i]] = s.charAt(i);
        }
        return String.valueOf(c);
    }
}
