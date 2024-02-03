package com.artsem.leetcode;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Problems {


    public static void main(String[] args) {

        String dirname = "/leetcode";
        File dir = new File(dirname);
        System.out.println(dir.getAbsolutePath());

        int[] twoSum = new int[]{12, 4, 6, 8, 1, 4};
        String str = "a1c1e1";

        String rings = "B0R0G0R9R0B0G0";
        String[] str1 = new String[]{"alice and bob love leetcode", "i think so too", "this is great thanks very much"};//"G()(al)";
        String[] s = {"w jrpihe zsyqn l dxchifbxlasaehj", "nmmfrwyl jscqyxk a xfibiooix xolyqfdspkliyejsnksfewbjom", "xnleojowaxwpyogyrayfgyuzhgtdzrsyococuqexggigtberizdzlyrdsfvryiynhg", "krpwiazoulcixkkeyogizvicdkbrsiiuhizhkxdpssynfzuigvcbovm", "rgmz rgztiup wqnvbucfqcyjivvoeedyxvjsmtqwpqpxmzdupfyfeewxegrlbjtsjkusyektigr", "o lgsbechr lqcgfiat pkqdutzrq iveyv iqzgvyddyoqqmqerbmkxlbtmdtkinlk", "hrvh efqvjilibdqxjlpmanmogiossjyxepotezo", "qstd zui nbbohtuk", "qsdrerdzjvhxjqchvuewevyzlkyydpeeblpc"};

        int num = 234;
        int[] small = new int[]{5, 6, 2, 7, 4};
        int[] arr = new int[]{0, 6, 0};
        int[][] multArr = new int[][]{{9, 81}, {33, 17}};
        int[][] multArrSum = new int[][]{{1}, {0}, {1}};


        List<List<String>> list = new ArrayList<>();
        list.add(List.of(new String[]{"A", "B"}));
        list.add(List.of(new String[]{"C", "D"}));
        list.add(List.of(new String[]{"B", "C"}));
        List<String> list1 = new ArrayList<>();
        list1.add("never");
        list1.add("gonna");
        list1.add("give");
        list1.add("up");
        list1.add("on");
        list1.add("you");
        int[] ages = new int[]{2, 6, 2, 1, 0, 9, 7};
        String st = "cdf";
        String st2 = "a";

        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        // root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(19);

        TreeNode cloned = new TreeNode(7);
        cloned.left = new TreeNode(4);
        cloned.right = new TreeNode(3);
        cloned.right.left = new TreeNode(6);
        cloned.right.right = new TreeNode(19);

        Calendar calendar = Calendar.getInstance();
        String[] month = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        int[][] multArr1 = new int[][]{{0, 1}, {1, 1}, {3, 8}};
        int[][] multArrSum1 = new int[][]{{3, 1}, {1, 5}};
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        String ss = "RULDDLLDLRDUUUURULRURRRRLRULRLULLLRRULULDDRDLRULDRRULLUDDURDLRRUDRUDDURLLLUUDULRUDRLURRDRLLDDLLLDLRLLRUUDUURDRLDUDRUDRLUDULRLUDRLDDUULDDLDURULUDUUDDRRDUURRLRDLDLRLLDRRUUURDLULLURRRRDRRURDUURDLRRUULRURRUULULUUDURUDLRDDDDDURRRLRUDRUULUUUULDURDRULLRRRUDDDUUULUURRDRDDRLLDRLDULDLUUDRDLULLDLDDRUUUUDDRRRDLLLLURUURLRUUULRDDULUULUURDURDDDRRURLURDLLLRLULRDLDDLRDRRRRLUURRRRLDUDLLRUDLDRDLDRUULDRDULRULRRDLDLLLUDLDLULLDURUURRLLULUURLRLRDUDULLDURRUDDLDDLLUDURLLRLDLDUDLURLLDRRURRDUDLDUULDUDRRUDULLUUDURRRURLULDDLRRURULUURURRDULUULDDDUUDRLDDRLULDUDDLLLDLDURDLRLUURDDRLUDRLUDLRRLUUULLDUUDUDURRUULLDDUDLURRDDLURLDRDRUDRLDDLDULDRULUDRRDRLLUURULURRRUDRLLUURULURRLUULRDDDRDDLDRLDRLDUDRLDRLDDLDUDDURUDUDDDLRRDLUUUDUDURLRDRURUDUDDRDRRLUDURULDULDDRLDLUURUULUDRLRLRLLLLRLDRURRRUULRDURDRRDDURULLRDUDRLULRRLLLDRLRLRRDULDDUDUURLRULUUUULURULDLDRDRLDDLRLURRUULRRLDULLUULUDUDRLDUDRDLLDULURLUDDUURULDURRUURLRDRRRLDDULLLLDDRRLRRDRDLRUDUUDLRLDRDRURULDLULRRDLLURDLLDLRDRURLRUDURDRRRULURDRURLDRRRDUDUDUDURUUUUULURDUDDRRDULRDDLULRDRULDRUURRURLUDDDDLDRLDLLLLRLDRLRDRRRLLDRDRUULURLDRULLDRRDUUDLURLLDULDUUDLRRRDDUDRLDULRDLLULRRUURRRURLRRLDDUDDLULRUDULDULRDUDRLRDULRUUDDRUURUDLDRDUDDUULLUDDLLRLURURLRRULLDDDLURDRRDLLLLULLDLUDDLURLLDDRLDLLDDRDRDDUDLDURLUUUUUDLLLRLDULDDRDDDDRUDLULDRRLLLDUUUDDDRDDLLULUULRRULRUDRURDDULURDRRURUULDDDDUULLLURRRRDLDDLRLDDDRLUUDRDDRDDLUDLUUULLDLRDLURRRLRDRLURUURLULLLLRDDLLLLRUDURRLDURULURULDDRULUDRLDRLLURURRRDURURDRRUDLDDLLRRDRDDLRLRLUDUDRRUDLLDUURUURRDUDLRRLRURUDURDLRRULLDLLUDURUDDRUDULLDUDRRDDUDLLLDLRDRUURLLDLDRDDLDLLUDRDDRUUUDDULRUULRDRUDUURRRURUDLURLRDDLUULRDULRDURLLRDDDRRUDDUDUDLLDDRRUUDURDLLUURDLRULULDULRUURUDRULDRDULLULRRDDLDRDLLLDULRRDDLDRDLLRDDRLUUULUURULRULRUDULRULRUURUDUUDLDUDUUURLLURDDDUDUDLRLULDLDUDUULULLRDUDLDRUDRUULRURDDLDDRDULRLRLRRRRLRULDLLLDDRLUDLULLUUDLDRRLUDULRDRLLRRRULRLRLLUDRUUDUDDLRLDRDDDDRDLDRURULULRUURLRDLLDDRLLRUDRRDDRDUDULRUDULURRUDRDLRDUUDDLDRUDLLDDLRLULLLRUUDRRRRUULLRLLULURLDUDDURLRULULDLDRURDRLLURRDLURRURLULDLRLDUDLULLLDRDLULDLRULLLUDUDUDUDLDDDDDRDLUDUULLUDRLUURDRLULD";

        ArrayList<Integer> listToMerge1 = new ArrayList<>();
        List<List<Integer>> list2 = new ArrayList<>();
        listToMerge1.add(3);
        listToMerge1.add(6);
        list2.add(listToMerge1);
        ArrayList<Integer> listToMerge2 = new ArrayList<>();
        listToMerge2.add(1);
        listToMerge2.add(5);
        list2.add(listToMerge2);
        ArrayList<Integer> listToMerge3 = new ArrayList<>();
        listToMerge3.add(4);
        listToMerge3.add(7);
        list2.add(listToMerge3);

        int[] nums = new int[0];
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(4);
        treeNode.right = new TreeNode(3);
//        treeNode.right.left = new TreeNode(1);
//        treeNode.right.left = new TreeNode(4);


        System.out.println(Problems.guessNumber(5));
    }

    public static int maxFrequencyElements(int[] nums) {
        int [] arr = new int [101];
        for(int i = 0; i<nums.length; i++){
            arr[nums[i]]++;
        }
        Arrays.sort(arr);
        int res = 0;
        for(int i = arr.length-1; i>0; i--){
            if(arr[i] != arr[i-1]){
                res += arr[i];
                break;
            } else {
                res += arr[i];
            }
        }
        return res;
    }
    public static List<Integer> minSubsequence(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int totalSum = 0;
        for(int n : nums){
            totalSum += n;
        }
        Arrays.sort(nums);
        int currSum = 0;
        for(int i = nums.length-1; i>=0; i--){
            currSum += nums[i];
            int n = totalSum - currSum;
            if(currSum <= n){
                list.add(nums[i]);
            } else {
                list.add(nums[i]);
                break;
            }
        }
        return list;
    }
    public static int canBeTypedWords1(String text, String brokenLetters) {

        Set<Character> set = new HashSet<>();
        for (char c : brokenLetters.toCharArray()){
            set.add(c);
        }
        int count = 0;
        String [] words = text.split(" ");
        for (String word : words) {
            count++;
            for (int i = 0; i<word.length(); i++){
                if (set.contains(word.charAt(i))){
                    count--;
                    break;
                }
            }
        }
        return count;
    }

    public static int canBeTypedWords(String text, String brokenLetters) {
        boolean isAbleToType = true;
        int count = 0;
        for (int i = 0; i<text.length(); i++){
            char c = text.charAt(i);
            if (brokenLetters.contains(text.charAt(i)+"")){
                isAbleToType = false;
            }
            if ((text.charAt(i)==' ' && isAbleToType) || (i == text.length()-1 && isAbleToType)){
                count++;
            } else if (text.charAt(i) == ' ' && !isAbleToType){
                isAbleToType = true;
            }
        }
        return count;
    }

    public List<String> splitWordsBySeparatorArr(List<String> words, char separator) {
        List<String> nm=new ArrayList<>();
        for(int i=0;i<words.size();i++)
        {
            String arr[]=words.get(i).split("["+separator+"]");
            for(int j=0;j<arr.length;j++)
            {

                if(arr[j].length()>0)
                {
                    nm.add(arr[j]);
                }
            }
        }
        return nm;
    }
    public static List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> list = new ArrayList<>();
        for(String s : words){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<s.length(); i++){
                if (s.charAt(i)==separator){
                    if (sb.length()>0) {
                        list.add(sb.toString());
                    }
                    sb.delete(0,sb.length());
                    continue;
                }
                if (i==s.length()-1){
                    sb.append(s.charAt(i));
                    list.add(sb.toString());
                    continue;
                }
                sb.append(s.charAt(i));
            }
        }
        return list;
    }
    public int countGoodSubstrings(String s) {
        if(s.length()<3){
            return 0;
        }
        int count = 0;
        for(int i = 2; i<s.length(); i++){
            if(s.charAt(i)!=s.charAt(i-1) && s.charAt(i)!=s.charAt(i-2)
                    && s.charAt(i-1)!=s.charAt(i-2)){
                count++;
            }
        }
        return count;
    }

    public String maximumOddBinaryNumber(String s) {
        StringBuilder sb = new StringBuilder();
        int count1 = 0;
        int count0 = 0;
        for(char c : s.toCharArray()){
            if(c == '1'){
                count1++;
            } else count0++;
        }
        while(count1>1){
            sb.append("1");
            count1--;
        }
        while(count0>0){
            sb.append("0");
            count0--;
        }
        sb.append("1");
        return sb.toString();
    }
    public static int[][] mergeArraysMergeSort(int[][] nums1, int[][] nums2) {

        List<int[]> res = new ArrayList<>();
        int i = 0,j = 0;
        while (i<nums1.length && j<nums2.length){
            if (nums1[i][0] == nums2[j][0]){
                res.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]){
                res.add(new int[]{nums1[i][0], nums1[i][1]});
                i++;
            } else {
                res.add(new int[]{nums2[j][0],nums2[j][1]});
                j++;
            }
        }
        while (i<nums1.length){
            res.add(new int[]{nums1[i][0], nums1[i][1]});
            i++;
        }
        while (j<nums2.length){
            res.add(new int[]{nums2[j][0], nums2[j][1]});
            j++;
        }

        return res.toArray(new int[res.size()][]);
    }
    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int [] arr : nums1){
            map.put(arr[0], arr[1]);
        }
        for(int [] arr : nums2){
            if(map.containsKey(arr[0])){
                map.put(arr[0], map.get(arr[0])+arr[1]);
            } else map.put(arr[0], arr[1]);
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByKey());
        int [][] res = new int[map.size()][2];
        int count = 0;
        for (Map.Entry<Integer,Integer> entry : entryList){
            res[count][0] = entry.getKey();
            res[count++][1] = entry.getValue();
        }
        return res;
    }
    public int sumRootToLeaf(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        collectPath(root, sb, list);
        return list.stream().reduce(0, Integer::sum);

    }
    public void collectPath(TreeNode node, StringBuilder currPath, List<Integer> paths){
        if(node == null){
            return;
        }
        currPath.append(node.val);
        if(node.left == null && node.right == null){
            paths.add(Integer.parseInt(currPath.toString(),2));
        } else {
            collectPath(node.left, currPath, paths);
            collectPath(node.right,currPath, paths);
        }
        currPath.deleteCharAt(currPath.length()-1);
    }
    public boolean divideArray(int[] nums) {
        int [] res = new int [501];
        for(int num : nums){
            res[num]++;
        }
        for(int num : res){
            if(num%2!=0){
                return false;
            }
        }
        return true;
    }

    public static int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        while(lowLimit<=highLimit){
            int boxNum = digitSum(lowLimit);
            map.put(boxNum, map.getOrDefault(boxNum,0)+1 );
            lowLimit++;
        }
        return map.values().stream().max(Comparator.naturalOrder()).get();
    }

    private static int digitSum(int n){
        int res = 0;
        while(n>0){
            res += n%10;
            n/=10;
        }
        return res;
    }

    public static int[] kWeakestRows2(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        int[] ans = new int[k];

        for (int i = 0; i < mat.length; i++) {
            pq.offer(new int[] {countSoldiers(mat[i],1), i});
            if (pq.size() > k)
                pq.poll();
        }

        while (k > 0)
            ans[--k] = pq.poll()[1];

        return ans;
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
//        Arrays.sort(mat, Comparator.comparingInt(row ->countSoldiers(row,1)));
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<mat.length; i++){
            int soldNum = countSoldiers(mat[i],1);
            map.put(i, soldNum);
        }
        map = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        int [] res = new int[k];
        int count = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (count<k){
                res[count++] = entry.getKey();
            } else break;
        }
        return res;
    }

    private static int countSoldiers(int [] row, int targetElem){
        int lo = 0;
        int hi = row.length;
        while (lo<hi){
            int mid = lo + (hi-lo)/2;
            if (row[mid]==targetElem){
                lo = mid + 1;
            }else hi = mid;
        }
        return lo;
    }

    public char repeatedCharacterS(String s) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i<s.length();i++){
            if(set.contains(s.charAt(i))){
                return s.charAt(i);
            }
            set.add(s.charAt(i));
        }
        throw new RuntimeException("s should contain at least one repeated letter");
    }
    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            if(set.contains(c)){
                return c;
            }
            set.add(c);
        }
        return 'a';
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt(subarray -> subarray[1]));
        int maxUnitsInBox = 0;
        for (int i = boxTypes.length-1; i>=0; i--){
            maxUnitsInBox += boxTypes[i][0]*boxTypes[i][1];
            truckSize -= boxTypes[i][0];
            if (truckSize<=0){
                maxUnitsInBox -= Math.abs(truckSize)*boxTypes[i][1];
                return maxUnitsInBox;
            }
        }
        return maxUnitsInBox;
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums){
            minHeap.offer(num);
            if (minHeap.size()>k){
                minHeap.poll();
            }
        }
//        Arrays.sort(nums);
//        return nums[nums.length - k];
        return minHeap.isEmpty() ? -1 : minHeap.poll();
    }

    public static List<List<Integer>> pascalTriangleGenerate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>(List.of(1));
        List<Integer> prev = new ArrayList<>(List.of(1, 1));
        res.add(list1);
        res.add(prev);
        for (int i = 1; i < numRows - 1; i++) {
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int j = 1; j < prev.size(); j++) {
                curr.add(prev.get(j) + prev.get(j - 1));
            }
            curr.add(1);
            prev = curr;
            res.add(prev);
        }

        return res;
    }

    public int percentageLetter(String s, char letter) {
        if (!s.contains(letter + "")) {
            return 0;
        }
        double count = 0;
        for (char c : s.toCharArray()) {
            if (c == letter) {
                count++;
            }
        }
        count = count / s.length() * 100;
        return (int) count;
    }

    public boolean isSumEqual2(String firstWord, String secondWord, String targetWord) {
        return getIntValue(firstWord) + getIntValue(secondWord) == getIntValue(targetWord);
    }

    private int getIntValue(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++)
            result = result * 10 + (s.charAt(i) - 'a');
        return result;
    }

    public static boolean isSumEqual(String firstWord, String secondWord, String targetWord) {

        StringBuilder sNum1 = new StringBuilder();
        StringBuilder sNum2 = new StringBuilder();
        StringBuilder sNum3 = new StringBuilder();
        for (char c : firstWord.toCharArray()) {
            sNum1.append(c - 'a');
        }
        for (char c : secondWord.toCharArray()) {
            sNum2.append(c - 'a');
        }
        for (char c : targetWord.toCharArray()) {
            sNum3.append(c - 'a');
        }
        int num1 = Integer.parseInt(sNum1.toString());
        int num2 = Integer.parseInt(sNum2.toString());
        int num3 = Integer.parseInt(sNum3.toString());
        return num3 == num1 + num2;
    }

    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] arr = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (set.contains(ints[j])) {
                    arr[0] = ints[j];
                }
                set.add(ints[j]);
            }
        }
        int num = 1;
        while (set.contains(num)) {
            num++;
        }
        arr[1] = num;
        return arr;
    }

    public int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        Arrays.sort(words);
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            if (i < left || i > right) {
                continue;
            }
            if (isVowel(s.charAt(0)) && isVowel(s.charAt(s.length() - 1))) {
                count++;
            }
        }
        return count;
    }

    private boolean isVowel(char s) {
        String vowels = "aeiou";
        return vowels.contains(s + "");
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
//            int count = 0;
//            for(int j=i;j<n;j++){
//                if(temperatures[j]>temperatures[i]){
//                    res[i] = count;
//                    break;
//                } else count++;
//            }
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                int index = st.pop();
                res[index] = i - index;
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int index = st.pop();
            res[index] = 0;
        }
        return res;
    }

    public static int countSymmetricIntegers(int low, int high) {

        int count = 0;
        for (int i = low; i <= high; i++) {
            String s = String.valueOf(i);
            int length = s.length();
            if (length < 2 || length % 2 != 0) {
                continue;
            }
            int num11 = 0;
            int num22 = 0;
            for (int j = 0; j < length / 2; j++) {
                num11 += s.charAt(j) - '0';
                num22 += s.charAt(j + length / 2) - '0';
            }
            if (num11 == num22) {
                count++;
            }
        }
        return count;
    }

    public static List<Integer> findPeaks(int[] mountain) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i < mountain.length; i++) {
            if (mountain[i - 1] > mountain[i] && mountain[i - 2] < mountain[i - 1]) {
                list.add(i - 1);
            }
        }
        return list;
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] res = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            int left = 0;
            int right = potions.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                long prod = (long) potions[mid] * spells[i];
                if (prod < success) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            res[i] = potions.length - left;
        }
        return res;
    }

    public static int minTimeToType(String word) {
        int count = 0;
        char curr = 'a';
        for (char c : word.toCharArray()) {
            int num = Math.abs(c - curr);
            if (num > 13) {
                num = 26 - num;
            }
            count += num + 1;
            curr = c;

        }
        return count;
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] arr = new boolean[rooms.size()];
        arr[0] = true;

        Stack<Integer> key = new Stack<>();
        key.add(0);
        while (!key.isEmpty()) {
            int currKey = key.pop();
            for (int newKey : rooms.get(currKey)) {
                if (!arr[newKey]) {
                    key.add(newKey);
                    arr[newKey] = true;
                }
            }
        }
        for (boolean visited : arr) {
            if (!visited) {
                return false;
            }
        }
        return true;
    }

    public static int countOperations(int num1, int num2) {
        int count = 0;
        while (num1 > 0 && num2 > 0) {
            if (num1 >= num2) {
                num1 -= num2;
            } else {
                num2 -= num1;
            }
            count++;
        }
        return count;
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
//        int dp[] = new int [nums.length+1];
//        dp[0] = 0;
//        dp[1] = nums[0];
//        for(int i = 1; i<nums.length; i++){
//            dp[i+1] = Math.max(dp[i], dp[i-1] + nums[i]);
//        }
//        return dp[nums.length];
        int first = 0;
        int second = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = Math.max(second, first + nums[i]);
            first = second;
            second = tmp;
        }
        return second;
    }

    public static int minCostClimbingStairs(int[] cost) {
//        int n = cost.length;
//        int[] dp = new int [n];
//        for(int i = 0; i<n; i++){
//            if(i<2){
//                dp[i] = cost[i];
//            } else{
//                dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
//            }
//        }
//        return Math.min(dp[n-1], dp[n-2]);
        int first = cost[0];
        int sec = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int res = cost[i] + Math.min(first, sec);
            first = sec;
            sec = res;
        }
        return Math.min(first, sec);
    }

    public static boolean isAllPositiveNumbers(List<String> args) {
        //magic happens here
        for (String s : args) {
            if (!Problems.isPositiveNumber(s)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPositiveNumber(String str) {
        if (str == null || str.length() < 1 || str.charAt(0) == '-') {
            return false;
        }

        double num;
        try {
            num = Double.parseDouble(str);
        } catch (NullPointerException | NumberFormatException ex) {
            return false;
        }

        return num > 0;
    }

    public static int tribonacci(int n) {
//        int [] arr = new int [38];
//        arr[0] = 0;
//        arr[1] = 1;
//        arr[2] = 1;
//        for(int i = 3; i<=n; i++){
//            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
//        }
//        return arr[n];
        if (n == 0) {
            return 0;
        }
        int a = 0;
        int b = 1;
        int c = 1;
        int d = 0;
        for (int i = 3; i <= n; i++) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return c;
    }

    public static int guessNumber(int n) {
        Random random = new Random();
        int i = random.nextInt(5);
        return i;
    }

    public static int getNodesAtEachLevel(com.artsem.leetcode.TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return 1;
        }
        Queue<com.artsem.leetcode.TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                com.artsem.leetcode.TreeNode node = queue.poll();
                currentLevel.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(currentLevel);
        }
        int level = 1;
        int currLevel = 1;
        int max = Integer.MIN_VALUE;
        for (List<Integer> list : result) {
            int curr = list.stream().mapToInt(v -> v).sum();
            if (curr > max) {
                max = curr;
                level = currLevel;
            }
            currLevel++;
        }

        return level;
    }

    public static List<Integer> rightSideView(com.artsem.leetcode.TreeNode root) {
        List<Integer> list = new ArrayList<>();
        fillList(root, list, 0);
        return list;
    }

    private static void fillList(com.artsem.leetcode.TreeNode curr, List<Integer> result, int currDepth) {
//        if(node == null){
//            return;
//        }
//        if(node.right==null){
//            list.add(node.val);
//            fillList(node.left, list);
//        }else {
//            list.add(node.val);
//            fillList(node.right, list);
//        }

        if (curr == null) {
            return;
        }
        if (currDepth == result.size()) {
            result.add(curr.val);
        }

        fillList(curr.right, result, currDepth + 1);
        fillList(curr.left, result, currDepth + 1);

    }

    public static int goodNodes(TreeNode root) {

        int count = 0;
        int max = root.val;
        count = countNodes(root, count, max);


        return count;


    }

    private static int countNodes(TreeNode root, int count, int max) {
        if (root == null) {
            return count;
        }
        if (root.val >= max) {
            System.out.println("root>max: " + root.val);
            max = root.val;
            count++;
        }
        System.out.println("before left, count = " + count);
        count = countNodes(root.left, count, max);
        count = countNodes(root.right, count, max);


        return count;


    }

    public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int i : nums1){
//            map.put(i, 0);
//        }
//        for(int i : nums2){
//            if(map.containsKey(i)){
//                map.put(i, 1);
//            }else map.put(i,0);
//        }
//        for(int i : nums3){
//            if(map.containsKey(i)){
//                map.put(i, 1);
//            }
//        }
//        List<Integer> list = new ArrayList<>();
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
//            if (entry.getValue()>0){
//                list.add(entry.getKey());
//            }
//        }
//        return list;
        List<Integer> arr = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums1.length; i++)
            map.put(nums1[i], 1);
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                if (map.get(nums2[i]) == 1) {
                    arr.add(nums2[i]);
                    map.put(nums2[i], 2);
                }
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (!map.containsKey(nums2[i]))
                map.put(nums2[i], 1);
        }
        for (int i = 0; i < nums3.length; i++) {
            if (map.containsKey(nums3[i])) {
                if (map.get(nums3[i]) == 1) {
                    arr.add(nums3[i]);
                    map.put(nums3[i], 2);
                }
            }
        }
        return arr;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        TreeNode res = null;
        if (root.val == val) {
            res = copySubtreeRecursive(root);
            return res;
        }
        res = searchBST(root.left, val);
        if (res != null) {
            return res;
        }
        res = searchBST(root.right, val);
        return res;
    }

    private TreeNode copySubtreeRecursive(TreeNode originalNode) {
        if (originalNode == null) {
            return null;
        }
        // Create a new node with the same value
        TreeNode copiedNode = new TreeNode(originalNode.val);
        // Recursively copy left and right subtrees
        copiedNode.left = copySubtreeRecursive(originalNode.left);
        copiedNode.right = copySubtreeRecursive(originalNode.right);
        return copiedNode;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        collectLeaf(root1, list1);
        List<Integer> list2 = new ArrayList<>();
        collectLeaf(root2, list2);
        return list1.equals(list2);
    }

    private static void collectLeaf(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
        } else {
            collectLeaf(root.left, list);
            collectLeaf(root.right, list);
        }

    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int pairSum(ListNode head) {
        // create ListNode copy
        ListNode newNode = new ListNode(head.val);
        ListNode currOrig = head;
        ListNode currCopy = newNode;
        int size = 1;
        while (currOrig.next != null) {
            currCopy.next = new ListNode(currOrig.next.val);
            currOrig = currOrig.next;
            currCopy = currCopy.next;
            size++;
        }

        // reverse ListNode copy
        ListNode curr = newNode;
        ListNode prev = null;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode origCurr = head;
        ListNode revCurr = prev;
        int max = 0;
        int currTwinS = 0;
        while (origCurr != null && revCurr != null) {
            currTwinS = origCurr.val + revCurr.val;
            if (currTwinS > max) {
                max = currTwinS;
            }
            origCurr = origCurr.next;
            revCurr = revCurr.next;
        }

        //traverse both Lists and count twin sum
        System.out.println("Copy list");
        ListNode trav1 = head;
        while (trav1 != null) {
            System.out.println(trav1.val + "");
            trav1 = trav1.next;
        }

        System.out.println("reversed list");
        ListNode trav = prev;
        while (trav != null) {
            System.out.println(trav.val + "");
            trav = trav.next;
        }


        return max;
    }

    public ListNode deleteMiddle(ListNode head) {
        int size = 0;
        ListNode curr = head;
        ListNode nodeToRemove = null;
        // traverse list and count size
        while (curr != null) {
            size++;
            System.out.println(curr.val);
            curr = curr.next;
        }
        System.out.println("size = " + size);
        ListNode oddNode = head;
        int count = 0;
        // find node to remove
        while (oddNode != null) {
            if (count == size / 2) {
                nodeToRemove = oddNode;
                System.out.println("remove : " + nodeToRemove.val);
                break;
            }
            System.out.println(oddNode.val);
            oddNode = oddNode.next;
            count++;
        }
        ListNode currNode = head;
        ListNode prevNode = null;
        // remove node
        while (currNode != null) {
            if (currNode == nodeToRemove) {
                if (prevNode != null) {
                    prevNode.next = currNode.next;
                } else {
                    // If there is no previous node, the head is the middle, so update the head
                    head = currNode.next;
                }
                break;
            }
            prevNode = currNode;
            currNode = currNode.next;
        }
        return head;
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode evenHead = evenNode;
        while (oddNode.next != null && evenNode.next != null) {
            oddNode.next = evenNode.next;
            evenNode.next = evenNode.next.next;
            oddNode = oddNode.next;
            evenNode = evenNode.next;

        }
        oddNode.next = evenHead;
        return head;
    }

    public int minBitFlips1(int start, int goal) {
        int count = 0;
        while (goal > 0 || start > 0) {
            int bStart = start & 1;
            int bGoal = goal & 1;
            if (bStart != bGoal) {
                count++;
            }
            start >>= 1;
            goal >>= 1;
        }
        return count;
    }
}