package com.artsem.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Problems {
    public static void main(String[] args) {
        int [] twoSum = new int[]{12,4,6,8,1,4};
        String str = "codeleet";

        String rings = "B0R0G0R9R0B0G0";
        String [] str1 = new String[]{"alice and bob love leetcode","i think so too","this is great thanks very much"};//"G()(al)";
        String[] s = {"w jrpihe zsyqn l dxchifbxlasaehj","nmmfrwyl jscqyxk a xfibiooix xolyqfdspkliyejsnksfewbjom","xnleojowaxwpyogyrayfgyuzhgtdzrsyococuqexggigtberizdzlyrdsfvryiynhg","krpwiazoulcixkkeyogizvicdkbrsiiuhizhkxdpssynfzuigvcbovm","rgmz rgztiup wqnvbucfqcyjivvoeedyxvjsmtqwpqpxmzdupfyfeewxegrlbjtsjkusyektigr","o lgsbechr lqcgfiat pkqdutzrq iveyv iqzgvyddyoqqmqerbmkxlbtmdtkinlk","hrvh efqvjilibdqxjlpmanmogiossjyxepotezo","qstd zui nbbohtuk","qsdrerdzjvhxjqchvuewevyzlkyydpeeblpc"};

        int num = 234;
        int [] small = new int[]{5,6,2,7,4};
        int [] arr = new int[]{3,0,1,1,9,7};
        int [][] multArr = new int[][]{{1,1,0},{1,0,1},{0,0,0}};
        int [][] multArrSum = new int[][]{{1},{0},{1}};



        List<List<String>> list = new ArrayList<>();
        list.add(List.of(new String[]{"phone","blue","pixel"}));
        list.add(List.of(new String[]{"computer","silver","phone"}));
        list.add(List.of(new String[]{"phone", "blue", "pixel"}));
        List<String> list1 = new ArrayList<>();
        list1.add("never");
        list1.add("gonna");
        list1.add("give");
        list1.add("up");
        list1.add("on");
        list1.add("you");
        String ruleKey = "type", ruleValue = "phone";
        String[] word1 = new String[]{"gin","zen","gig","msg"};
        String[] word2 = new String[]{"a", "bc"};
        String st = "ngguoys";


        System.out.println(Problems.countPoints(rings));
        System.out.println(Problems.countGoodTriplets(arr,7,2,3));
        System.out.println(Problems.maxProductDifference(small));
        System.out.println(Problems.flipAndInvertImage(multArrSum));
        System.out.println(Problems.removeOuterParentheses(""));
        System.out.println(Problems.maxDepth(""));
        System.out.println(Problems.countAsterisks("|l|*e*et|c**o|*de"));
        System.out.println(Problems.maximum69Number(9696666));
        System.out.println(Problems.largestAltitude(new int[]{44,32,-9,52,23,-50,50,33,-84,47,-14,84,36,-62,37,81,-36,-85,-39,67,-63,64,-47,95,91,-40,65,67,92,-28,97,100,81}));
        System.out.println(Integer.parseInt((Integer.toString(2,2))));
        System.out.println(Problems.minBitFlips(10,7));
        System.out.println(Problems.uniqueMorseRepresentations(new String []{"a"}));
        System.out.println(Problems.toLowerCase("al&phaBET"));
        System.out.println(Problems.diagonalSum(multArrSum));
        System.out.println(Problems.countKDifference(small, 1));
        System.out.println(Problems.checkIfPangram("uwqohxamknblecdtzpisgvyfjr"));
        System.out.println(Problems.isAcronym(list1, st));
        System.out.println(Problems.sortSentence("Myself2 Me1 I4 and3"));
        System.out.println(Problems.findCenter(multArr));
        System.out.println(Problems.differenceOfSum(small));
        System.out.println(Problems.arrayStringsAreEqual(word1,word2));
        System.out.println(Problems.countDigits(1248));
        System.out.println(Problems
                .decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
        System.out.println(Problems.cellsInRange("K7:M9"));
        System.out.println(Problems.countMatches(list, ruleKey, ruleValue));
        Problems.restoreStringRef(str, small);
        Problems.xorOperation(5,0);
        System.out.println(Problems.sumOfMultiples(9));
        System.out.println(Problems.balancedStringSplit(str));
        System.out.println(Arrays.toString(Problems.decompressRLElist(arr)));
    }


    public static int countPoints(String rings) {
        int [] r = new int [10];
        int [] g = new int [10];
        int [] b = new int [10];
        for (int i = 0; i<rings.length(); i++){
            if (rings.charAt(i)=='R'){
                r[rings.charAt(i+1)-'0']++ ;
            }
            if (rings.charAt(i)=='G'){
                g[rings.charAt(i+1)-'0']++;
            }
            if (rings.charAt(i)=='B'){
                b[rings.charAt(i+1)-'0']++;
            }
        }
        int result = 0;
        for(int i = 0; i<10; i++){
            if (r[i]>0 && g[i]>0 && b[i]>0){
                result++;
            }
        }
        return result;
    }
    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int res = 0;
        for(int i = 0; i<arr.length; i++){
            for(int j = i+1; j< arr.length; j++){
                for(int k = j+1; k<arr.length; k++){
                    if(Math.abs(arr[i]-arr[j])<=a
                            && Math.abs(arr[j]-arr[k])<=b
                            && Math.abs(arr[i]-arr[k])<=c){
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
        List<Integer> list =Arrays.stream(nums).boxed().collect(Collectors.toList());

        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        list.remove(Integer.valueOf(max));
        list.remove(Integer.valueOf(min));
        Integer max2  = list.stream().max(Integer::compare).get();
        Integer min2  = list.stream().min(Integer::compare).get();
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
        return max*max2 - min*min2;
    }
    public static int[][] flipAndInvertImage(int[][] image) {
        int [][] res = new int[image.length][image[0].length];
        for(int i = 0; i<image.length; i++){
            int count = 0;
            for( int j = image[i].length-1; j>=0; j--){
                res[i][count++] = image[i][j]^1;
            }
        }
        return res;
    }

    public static String removeOuterParentheses(String s) {
        int balance = 0;
        boolean flag = true;
        StringBuilder curPrimit = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for( int i = 0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                balance+=1;
                flag=false;
                curPrimit.append(s.charAt(i));
            }else if(s.charAt(i)==')'){
                balance+=-1;
                curPrimit.append(s.charAt(i));
            }
            if(balance==0 && !flag){
                flag = true;
                res.append(curPrimit.deleteCharAt(0).deleteCharAt(curPrimit.length()-1));
                curPrimit=new StringBuilder();
            }
        }
        return res.toString();
    }
    public static int maxDepth(String s) {
        char [] sArr = s.toCharArray();
        int currentDepth = 0;
        int maxDepth= 0;
        int countLeft = 0;
        int countRight = 0;
        int balance = 0;
        boolean flag = true;
        for( int i = 0; i<s.length(); i++){
            if(balance==0 && !flag){
                countLeft=0;
                countRight=0;
                flag = true;
            }
            if(sArr[i]=='('){
                countLeft++;
                balance+=1;
                flag=false;
            }else if(sArr[i]==')'){
                countRight++;
                balance+=-1;
            }
            //  if(sArr[i]!='(' && sArr[i]!=')'){
            currentDepth=countLeft-countRight;
            // }
            if(currentDepth>maxDepth){
                maxDepth=currentDepth;
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
        String [] strArr=s.split("\\|");
        StringBuilder sb = new StringBuilder();
        int count = 0;
//        boolean flag = true;
//        if(s.charAt(0)=='|'){
//            flag = false;
//        }
        for(String str : strArr){
            if(count%2==0 /*&& flag*/){
                sb.append(str);
            }//else if(count%2!=0 && !flag)sb.append(str);
            count++;
        }
        return (int)sb.toString().chars().filter(c -> c=='*').count();
    }
    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String [] strArr= s.split(" ");
        for(String str : strArr){


        }
        return "";
    }
    public static int maximum69Number (int num) {
//        boolean flag=false;
//        String str = String.valueOf(num);
//        StringBuilder sb = new StringBuilder();
//        for(char c : str.toCharArray()){
//            if(c=='6' && !flag){
//                sb.append(9);
//                flag=true;
//            } else sb.append(c+"");
//        }
        return Integer.parseInt((num+"").replaceFirst("6","9"));
        //return Integer.valueOf(sb.toString());
    }
    public static int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        // int [] altitudes = new int [gain.length+1];
        int currentAltitude = 0;
        //altitudes[0] = 0;
        for(int i = 0; i<gain.length; i++){
            //altitudes[i+1] = altitudes[i] + gain[i];
            currentAltitude +=gain[i];
            // if(maxAltitude<altitudes[i+1]){
            //   maxAltitude=altitudes[i+1];
            //}
            if(currentAltitude>maxAltitude){
                maxAltitude=currentAltitude;
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
        int res = binStart^binGoal;
        return res;
    }
    public static int uniqueMorseRepresentations(String[] words) {
        String [] morseCode = new String []{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        char a = 'a';
        Map <String, String> morseTable = new HashMap<>();
        Set <String> set = new HashSet();
        for(int i = 0; i<morseCode.length; i++){
            morseTable.put(a+"", morseCode[i]);
            a++;
        }
        for(String word : words){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<word.length(); i++){
                sb.append(morseTable.get(word.charAt(i)+""));
            }
            set.add(sb.toString());
        }
        return set.size();

    }
    public static String toLowerCase(String s) {
        char [] c = s.toCharArray();
        for(int i = 0; i<c.length; i++){
            if(c[i]>64 && c[i]<91){
                c[i]+=32;
            }
        }
        return String.valueOf(c);
    }
    public static int diagonalSum(int[][] mat) {
        int sum=0;
        int dCount = mat.length-1;
        for(int i = 0; i<mat.length; i++){
            int j=i;
            sum+=mat[i][j];
            if(mat.length%2!=0 && dCount==mat.length/2){
                dCount--;
                continue;
            }
            sum+=mat[i][dCount];
            dCount--;
        }
        return sum;
    }

    public static int countKDifference(int[] nums, int k) {
        int res = 0;
        for(int i =0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                if(Math.abs(nums[i]-nums[j])==k){
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
        for (int i = 0; i < sentence.length(); i++){
            set.add(sentence.charAt(i));
        }

        return set.size()==26;
    }
    public static boolean isAcronym(List<String> words, String s) {
        if (words.size()!=s.length()){
            return false;
        }
        s.contains("a");
        int count = 0;
        for(String str : words){
            if(str.charAt(0)!=s.charAt(count)){
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
        for (int i = 0; i<sArr.length; i++) {
            for (String str : sArr) {
                if (str.charAt(str.length() - 1) == c) {
                    sb.append(str.substring(0,str.length()-1));
                    sb.append(" ");
                }
            }
            c++;
        }
        return sb.toString().trim();
    }

    /**You are given a 0-indexed, strictly increasing integer array nums and a positive integer diff. A triplet (i, j, k)
     is an arithmetic triplet if the following conditions are met:

     i < j < k,
     nums[j] - nums[i] == diff, and
     nums[k] - nums[j] == diff. */
    public static int arithmeticTriplets(int[] nums, int diff) {

        for (int i = 0; i<nums.length; i++){
            for (int j = i ; j< nums.length; j++){
                for(int k = j; k<nums.length; k++){

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
        for(int [] node : edges){
            if(map.containsKey(node[0])){

                result = node[0];
            }
            map.put(node[0],node[1]);
        }
        if (result==-1){
            result=map.get(1);
        }
        return result;
    }
    public static int differenceOfSum(int[] nums) {

//        String str = Arrays.toString(nums).replaceAll("\\D+", "");
        int elemSum = 0;
        int digitSum = 0;
        for(int num : nums){
            elemSum+=num;
            while (num>0){
                digitSum+=num%10;
                num/=10;
            }
        }
//        for (char c : str.toCharArray()){
//            digitSum+=Character.getNumericValue(c);
//        }
        return Math.abs(elemSum-digitSum);
    }
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String word1Str = String.join(",", word1).replace(",","");
        String word2Str = String.join(",", word2).replace(",","");
        return word1Str.equals(word2Str);
    }
    public static int countDigits(int num) {
        int count=0;
        int n = num;
        while(num>0){
            if(n%(num%10)==0){
                count++;
            }
            num/=10;
        }
        return count;
    }
    public static String decodeMessage(String key, String message) {
        key = key.replaceAll("\\s", "");
//        List<Character> uniqueKey = trKey.chars().distinct().mapToObj(c->(char)c)
//               .collect(Collectors.toList());

        StringBuilder result = new StringBuilder();
        char a = 'a';
        Map<Character,Character> susTable = new HashMap<>();
        for (int i=0; i<key.length(); i++){
            if (!susTable.containsKey(key.charAt(i))){
                susTable.put(key.charAt(i),a++);
            }
//           char newChar = (char) ('a'+i);

        }
        for (char c : message.toCharArray()){
            if (c==' '){
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
        List <String> list = new ArrayList<>();
        char cs = s.charAt(0);
        char ce = s.charAt(3);
        char rs = s.charAt(1);
        char re = s.charAt(4);
        for(char c = cs; c<=ce; c++){
            for(char r = rs; r<=re; r++){
                list.add(""+c+r);
            }
        }
        return list;
    }
    public static int task1(int n) {
        int result = 0;
        if (n>0){
            result=n*n;
        } else if (n<0){
            result=-n;
        }
        return result;
    }

    public static int sumOfFibonacciNumbers(int n){
        if (n<=1){
            return 0;
        }
        if (n==2){
            return 1;
        }
        int [] fibonacciNumbers =  new int [n];
        fibonacciNumbers [0]=0;
        fibonacciNumbers [1]=1;
        int sum = fibonacciNumbers [0]+fibonacciNumbers [1];
        for (int i =2;i <n; i++){
            fibonacciNumbers [i]=fibonacciNumbers [i-1]+fibonacciNumbers [i-2];
            sum+=fibonacciNumbers[i];
        }
        return sum;
    }

    public static int[] twoSum(int[] nums, int target){

        int [] twoSum = new int[2];
        for (int i = 0 ; i< nums.length; i++){
            for (int j=i; j<nums.length; j++){
                if (nums[i]+nums[j]==target){
                    twoSum[0]=i;
                    twoSum[1]=j;
                    return twoSum;
                }
            }
        }
        return twoSum;
    }

    public static int [] twoSumMap (int[]nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i =0; i<nums.length;i++){
            map.put(nums[i],i);
        }

        for (int i=0; i<nums.length;i++){
            int number = target - nums[i];
            if (map.containsKey(number)&&map.get(number)!=i){
                return  new int[]{i, map.get(number)};
            }
        }

        throw new IllegalArgumentException("Can't find a sum");

    }

    public static String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<address.length();i++){
            if (address.charAt(i)=='.'){
                sb.append("[.]");
            }else sb.append(address.charAt(i));
        }
        return sb.toString();
    }


    public static int theMaximumAchievableX(int num, int t) {
        return num +t + 1;
    }

    /**Given an array of integers nums, return the number of good pairs.
     A pair (i, j) is called good if nums[i] == nums[j] and i < j.**/
    public int numIdenticalPairs(int[] nums) {
        int numberOfGoodPairs = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    numberOfGoodPairs++;
                }
            }
        }
        return  numberOfGoodPairs;
    }

    public static int[] getConcatenation(int[] nums) {

        int [] ans = new int[nums.length*2];
        for (int i =0; i<nums.length; i++){
            ans[i]=nums[i];
            ans[i+nums.length]=nums[i];
        }
        return ans;
    }

    public static int[] buildArray(int[] nums) {

        int [] ans = new int[nums.length];
        for (int i =0; i< nums.length;i++){
            ans[i]= nums[nums[i]];
        }
        return ans;
    }

    public static int finalValueAfterOperations(String[] operations) {
        int res =0;
        for (String string : operations){
            if(string.contains("-")){
                res--;
            }else res++;
        }
        return res;
    }

    public static int[] shuffle(int[] nums, int n) {
        int [] ans = new int [n*2];
        for(int i = 0; i<nums.length; i+=2){
            ans[i]=nums[i];
            ans[i+1]=nums[i+n];
        }
        return ans;
    }

    public static int numJewelsInStones(String jewels, String stones) {
        char[] jewelsArr = jewels.toCharArray();
        char[] stonesArr = stones.toCharArray();
        int count = 0;
        for (int i = 0; i<jewels.length(); i++){
            for (int j=0; j<stones.length();j++){
                if (jewelsArr[i]==stonesArr[j]){
                    count++;
                }
            }
        }
        return count;
    }

    public static String interpret(String command) {
        StringBuilder result = new StringBuilder();
        char [] c = command.toCharArray();
        for (int i = 0; i<c.length; i++){
            if (c[i]=='G'){
                result.append(c[i]);
            } else if (c[i]=='(' && c[i+1]==')'){
                result.append("o");
            }else if (c[i]=='(' && c[i+1]=='a'){
                result.append("al");
            }
        }
        return result.toString();
    }

    public static String interpretOne(String command){
        return command.replace("()","o").replace("(al)","al");
    }

    public static int mostWordsFound(String[] sentences) {

        List<Integer> counts = new ArrayList<>();
        for (String str : sentences){
            int count =0;
            char[] c = str.toCharArray();
            for (int i = 0; i < str.length(); i++) {
                if (c[i] == ' ') {
                    count++;
                }
            }
            counts.add(count+1);
        }
        return Collections.max(counts);
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int [] result = new int[nums.length];

        for(int i = 0; i< nums.length; i++){
            int count = 0;
            for(int j = 0; j<nums.length; j++){
                if(nums[i]>nums[j]){
                    count++;
                }
            }
            result[i]=count;
        }
        return result;
    }

    public static int subtractProductAndSum(int n) {
        List<Integer> list = new ArrayList<>();
        while(n>0){
            int c = n%10;
            n/=10;
            list.add(c);
        }
        int sum = list.stream().mapToInt(value -> value).sum();
        int prod = list.stream().mapToInt(value -> value)
                .reduce(1,(a, b) -> a * b);
        return prod-sum;
    }

    public static int[] leftRightDifference(int[] nums) {
        int [] answer = new int [nums.length];
        int [] leftSumArr = new int [nums.length];
        int [] rightSumArr = new int [nums.length];
        for(int i = 0; i<nums.length; i++){
            int rightSum = 0;
            for(int j = i+1; j<nums.length; j++){
                rightSum+=nums[j];
            }
            rightSumArr[i]=rightSum;
        }
        for(int i = 0; i<nums.length; i++){
            int leftSum = 0;
            for(int j = 0; j<i; j++){
                leftSum+=nums[j];
            }
            leftSumArr[i]=leftSum;
        }
        for(int i = 0; i<nums.length; i++){
            answer[i]=Math.abs(leftSumArr[i]-rightSumArr[i]);
        }
        return answer;
    }

//    public static final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
//        for (TreeNode node : cloned)
//        return target;
//    }

    public static void ckeckBool(){
        boolean bol = false;
        if (!bol){
            System.out.println(bol);
        }
    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> target = new LinkedList<>();
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> indexList = Arrays.stream(index).boxed().collect(Collectors.toList());
        for (int i = 0; i<nums.length; i++) {
            target.add(indexList.get(i), numsList.get(i));
        }
        int [] result = target.stream().mapToInt(Integer::intValue)
                .toArray();
        return result;
    }
    public static int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            int count=0;
            while(count<nums[2*i]){
                list.add(nums[2*i+1]);
                count++;
            }
            if (2*i+2==nums.length){
                break;
            }
        }
        int [] result = new int [list.size()];
        for(int i = 0; i<result.length; i++){
            result[i]=list.get(i);
        }
        return result;
    }

    public static int balancedStringSplit(String s) {
        char [] arr = s.toCharArray();
        int result = 0;
        int count = 0;
        for(int i = 0; i<s.length(); i++){
            if(arr[i]=='L'){
                count++;
            }else count--;
            if(count==0){
                result++;
            }
        }
        return result;
    }

    public static int sumOfMultiples(int n) {
        int result = 0;
        for(int i = 3; i<=n; i++){
            if(i%3==0 || i%5==0 || i%7==0){
                result+=i;
            }
        }
        return result;
    }

    public static int xorOperation(int n, int start) {
        int [] nums = new int [n];
        int result = 0;
        for(int i = 0; i<0; i++){
            nums[i]=start+2*i;
        }
        for(int i : nums){
            result^=i;
        }
        return result;
    }

    public static String restoreString(String s, int[] indices) {
        List <Character> list = new ArrayList<>();
        for(int i = 0; i<s.length(); i++){
            list.add(' ');
        }
        StringBuilder str = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            list.set(indices[i], s.charAt(i));
        }
        return list.toString();
    }

    public static String restoreStringRef(String s, int[] indices) {
        char c[]= new char[s.length()];
        for(int i = 0; i<s.length(); i++){
            c[indices[i]]=s.charAt(i);
        }
        return String.valueOf(c);
    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int result=0;
        //Map<String, String> resultMap = new HashMap<>();
        Map<String, String> map = new HashMap<>();
        map.put(ruleKey,ruleValue);
        for( List<String> nested: items){
            Map<String, String> resultMap = new HashMap<>();
            for(String str : nested ){
                resultMap.put("type",str);
                switch (ruleKey){
                    case "type":
                        if(str.equals(ruleValue)){
                            result++;
                        }
                        break;
                    case "color":
                        if(str.equals(ruleValue)){
                            result++;
                        }
                        break;
                    case "name":
                        if(str.equals(ruleValue)){
                            result++;
                        }
                        break;
                }
            }
        }
        return result;
    }
}
