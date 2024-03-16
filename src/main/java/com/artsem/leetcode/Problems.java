package com.artsem.leetcode;


import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Problems {


    public static void main(String[] args) {

        String dirname = "/leetcode";
        File dir = new File(dirname);
        System.out.println(dir.getAbsolutePath());

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
        GregorianCalendar gregorianCalendar = new GregorianCalendar();

        int [][] ma = new int[3][];
        int length = ma.length;

    }

    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char [] sAr = s.toCharArray();
        char [] tAr = t.toCharArray();
        Arrays.sort(sAr);
        Arrays.sort(tAr);
        for(int i = 0; i<s.length(); i++){
            if(sAr[i]!=tAr[i]) return false;
        }
        return true;
    }
    public static int countCharacters(String[] words, String chars) {
        int count = 0;
        char [] arr = chars.toCharArray();
        Arrays.sort(arr);
        for(String s : words){
            if (s.length()>arr.length){
                continue;
            }
            char [] sArr = s.toCharArray();
            Arrays.sort(sArr);
            for(int i = 0, j =0; i<chars.length();){
                if (arr[i]==sArr[j]){
                    if (j==sArr.length-1){
                        count += sArr.length;
                        break;
                    }
                    i++;
                    j++;
                }else i++;
            }
        }
        return count;
    }
    public int fibDP(int N) {
        if(N <= 1)
            return N;

        int[] fib_cache = new int[N + 1];
        fib_cache[1] = 1;

        for(int i = 2; i <= N; i++)
        {
            fib_cache[i] = fib_cache[i - 1] + fib_cache[i - 2];
        }
        return fib_cache[N];
    }
    public int fib(int n) {
        if(n<2){
            return n;
        }
        int n1 = 0;
        int n2 = 1;
        int f = 0;
        for(int i = 2; i<=n; i++){
            f = n1+n2;
            n1 = n2;
            n2 = f;
        }
        return f;
    }

    public static int countStudentsR(int[] students, int[] sandwiches) {

        int count = 0;
        for (int i = 0, j = 0; j<sandwiches.length;) {
            if (students[i]==sandwiches[j]){
                sandwiches[j] = -1;
                students[i] = -1;
                i++;
                j++;
                count = 0;
            } else {
                i++;
                count++;
            }
            if (i>students.length-1){
                i = 0;
            }
            if (count>students.length){
                break;
            }
        }
        count = 0;
        for (int s : sandwiches) {
            if (s!=-1) count++;
        }
        return count;
    }
    public static int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> stackSand = new Stack<>();
        Queue<Integer> queueStud = new LinkedList<>();
        for (int i = sandwiches.length-1; i>=0; i--){
            stackSand.push(sandwiches[i]);
        }
        for (int s : students){
            queueStud.add(s);
        }
        int count = 0;
        while (!stackSand.isEmpty() && !(count > queueStud.size())){
            if(stackSand.peek().equals(queueStud.peek())){
                stackSand.pop();
                queueStud.poll();
                count = 0;
            } else {
                if (queueStud.size()>1){
                    int temp = queueStud.poll();
                    queueStud.add(temp);
                }
                count++;
            }
        }
        return queueStud.size();
    }
    public static int[] resultArray(int[] nums) {
        int n = nums.length;
        Stack<Integer> intStack1 = new Stack<>();
        Stack<Integer> intStack2 = new Stack<>();
        intStack1.push(nums[0]);
        intStack2.push(nums[1]);
        for(int i = 2; i<n; i++){
            if (intStack1.peek()>intStack2.peek()){
                intStack1.push(nums[i]);
            } else intStack2.push(nums[i]);
        }
        while (!intStack2.isEmpty()){
            nums[n-1] = intStack2.pop();
            n--;
        }
        while (!intStack1.isEmpty()){
            nums[n-1] = intStack2.pop();
            n--;
        }
        return nums;
    }
    public int unequalTriplets(int[] nums) {
        int count = 0;
        for(int i = 0; i< nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                for(int k = j+1; k<nums.length; k++){
                    if(nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int [][] res = new int [n][m];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int [][] res = new int [n+1][m+1];
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    res[i][j] = 1 + res[i-1][j-1];
                } else {
                    res[i][j] = Math.max(res[i-1][j], res[i][j-1]);
                }
            }
        }
        return res[n][m];
    }
    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int count = 1;
        int curr = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0]>curr){
                curr = points[i][1];
                count++;
            }
        }
        return count;
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0]<intervals[i-1][1]){
                intervals[i][1] = intervals[i-1][1];
                count++;
            }
        }
        return count;
    }
    public List<List<Integer>> findMatrixRemove(int[] nums) {
        Map<Integer, Integer> um = new HashMap<>();
        for (int i : nums) {
            um.put(i, um.getOrDefault(i, 0) + 1);
        }

        List<List<Integer>> ans = new ArrayList<>();
        while (!um.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            List<Integer> toErase = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : um.entrySet()) {
                int f = entry.getKey();
                int s = entry.getValue();
                temp.add(f);
                s--;
                if (s == 0) {
                    toErase.add(f);
                }
                um.put(f, s);
            }
            ans.add(temp);
            for (int i : toErase) {
                um.remove(i);
            }
        }
        return ans;
    }

    public static List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else map.put(num, 1);
        }
        int max = map.values().stream().mapToInt(Integer::intValue).max().getAsInt();
        while (max > 0) {
            List<Integer> curr = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() <= 0) {
                    continue;
                }
                curr.add(entry.getKey());
                map.put(entry.getKey(), entry.getValue() - 1);
            }
            res.add(curr);
            max--;
        }
        return res;
    }
    public static boolean isStrictlyPalindromic(int n) {
        for(int i = 2; i<=n-2; i++){
            String convNum = Integer.toString(n,i);
            if(!isPalindrom(convNum)) return false;
        }
        return true;
    }

    private static boolean isPalindrom(String str){
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

    public static int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        if (nums[1]<nums[0]){
            return 0;
        }
        if (nums[nums.length-2]<nums[nums.length-1]){
            return nums.length-1;
        }
        for (int i = 1; i<nums.length-1; i++){
            int prev = nums[i-1];
            int cur = nums[i];
            int next = nums[i+1];
            if(cur>next && cur>prev){
                return i;
            }
        }
        return -1;
    }
    public static List<List<Integer>> groupThePeopleOnePass(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i<groupSizes.length; i++){
            if(!map.containsKey(groupSizes[i])){
                map.put(groupSizes[i], new ArrayList<>());
            }
            List<Integer> currLS = map.get(groupSizes[i]);
            currLS.add(i);
            map.put(groupSizes[i], currLS);
            if (currLS.size()==groupSizes[i]){
                res.add(currLS);
                map.remove(groupSizes[i]);
            }
        }
        return res;
    }
    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i<groupSizes.length; i++){
            if(map.containsKey(groupSizes[i])){
                List<Integer> currLS = map.get(groupSizes[i]);
                currLS.add(i);
                map.put(groupSizes[i], currLS);
                continue;
            }
            List<Integer> ls = new ArrayList<>();
            ls.add(i);
            map.put(groupSizes[i], ls);
        }
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            List <Integer> ls = entry.getValue();
            int subListLength = entry.getKey();
            List<Integer> listToResList = new ArrayList<>();
            for (int i = 0; i < ls.size(); i++) {
                int num = ls.get(i);
                listToResList.add(num);
                if (listToResList.size() == subListLength) {
                    res.add(listToResList);
                    listToResList = new ArrayList<>();
                }
            }
        }
        return res;
    }

    public int[] replaceElements(int[] arr) {
        int [] res = new int [arr.length];
        int max = Integer.MIN_VALUE;
        for(int i = arr.length-1; i>0; i--){
            if(arr[i]>max){
                max=arr[i];
            }
            res[i-1] = max;
        }
        res[arr.length-1] = -1;
        return res;
    }
    public List<Integer> luckyNumbers (int[][] matrix) {
        int row = matrix[0].length;
        int col = matrix.length;
        List<Integer> ls = new ArrayList<>();
        for (int[] ints : matrix) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int pos = 0;
            for (int j = 0; j < row; j++) {
                if (ints[j] < min) {
                    min = ints[j];
                    pos = j;
                }
            }
            for (int k = 0; k < col; k++) {
                if (matrix[k][pos] > max) {
                    max = matrix[k][pos];
                }
            }
            if (max == min) {
                ls.add(min);
            }
        }
        return ls;
    }

    public int maximumCountBinSearch(int[] nums) {
        int pos = nums.length - binSearch(nums, 1);
        int neg = binSearch(nums, 0);
        return Math.max(pos,neg);
    }

    private int binSearch(int [] nums, int target){
        int l = 0;
        int r = nums.length;

        while(l<r){
            int mid = l+(r-l)/2;
            if(nums[mid]<target){
                l=mid+1;
            } else r = mid;
        }
        return l;
    }
    public int maximumCount(int[] nums) {
        int pos = 0;
        int neg = 0;
        for(int num : nums){
            if(num < 0) neg++;
            if(num > 0) pos++;
        }
        return Math.max(pos,neg);
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode head = helper(nums, 0, nums.length - 1);
        return head;
    }

    public TreeNode helper(int[] num, int low, int high) {
        if (low > high) { // Done
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
    }
    public static void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }
    public static boolean checkString(String s) {
        char f = s.charAt(0);
        for(char c : s.toCharArray()){
            if (f=='b'){
                if (c=='a'){
                    return false;
                }
                continue;
            }
            if(c!=f){
                f=c;
            }
        }
        return true;
    }
    public static int[] shortestToChar1Pass(String S, char C) {
        int n = S.length(), pos = -n, res[] = new int[n];
        for (int i = 0; i < n; ++i) {
            if (S.charAt(i) == C) pos = i;
            res[i] = i - pos;
        }
        for (int i = pos - 1; i >= 0; --i) {
            if (S.charAt(i) == C)  pos = i;
            res[i] = Math.min(res[i], pos - i);
        }
        return res;
    }
    public static int[] shortestToChar(String s, char c) {
        int [] res = new int [s.length()];
        int prevC = Integer.MAX_VALUE;
        for(int i = 0; i<s.length(); i++){
            for(int j = i; j<s.length(); j++){
                if(s.charAt(j)==c){
                    int ahead = Math.abs(j-i);
                    int behind = Math.abs(i-prevC);
                    res[i] = Math.min(ahead, behind);
                    prevC = ahead <= behind ? j : prevC;
                    break;
                }
                if (j==s.length()-1){
                    res[i] = Math.abs(i-prevC);
                }
            }
        }
        return res;
    }
    public static int findFinalValue(int[] nums, int original) {
        int res = original;
        int prev = 0;
        Arrays.sort(nums);
        while(res!=-1){
            prev = res;
            res = binarySearch(nums, res);
        }
        return prev;
    }


    private static int binarySearch(int[]nums, int num){
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid]==num){
                return num*2;
            }
            if(nums[mid]<num){
                l=mid+1;
            } else r=mid-1;
        }
        return -1;
    }
    public static int[] answerQueriesStorePrefix(int[] nums, int[] queries) {
        int [] ans = new int [queries.length];
        Arrays.sort(nums);
        for (int i = 1; i<nums.length; i++){
            nums[i] += nums[i-1];
        }
        
        for(int i = 0; i<ans.length; i++){
            int j = Arrays.binarySearch(nums, queries[i]);
            ans[i] = Math.abs(j+1);
        }
        return ans;
    }
    public static int[] answerQueries(int[] nums, int[] queries) {
        int [] ans = new int [queries.length];
        Arrays.sort(nums);
        for(int i = 0; i<ans.length; i++){
            int sum = 0;
            int j = 0;
            while(sum<queries[i] && j<nums.length){
                sum += nums[j++];
                if (sum>queries[i]){
                    j--;
                }
            }
            ans[i] = j;
        }
        return ans;
    }
    public int minCostToMoveChips(int[] position) {
        int even = 0;
        int odd = 0;
        for(int n : position){
            if(n%2==0){
                even++;
            } else odd++;
        }
        return Math.min(even, odd);
    }
    public static int[] sortedSquares2Pointers(int[] nums) {
        int [] res = new int [nums.length];
        int n = nums.length;
        int l = 0;
        int r = n-1;
        for(int i = n-1; i>0; i--){
            if(Math.abs(nums[l])<Math.abs(nums[r])){
                res[i] = nums[r] * nums[r];
                r--;
            }else {
                res[i] = nums[l] * nums[l];
                l++;
            }
        }
        return res;
    }
    public int[] sortedSquares(int[] nums) {
        int [] res = new int [nums.length];
        for(int i = 0; i<nums.length; i++){
            res[i] = nums[i] * nums[i];
        }
        Arrays.sort(res);
        return res;
    }
    public static int maximumValue(String[] strs) {
        int max = 0;
        for (String s : strs){
            try {
                max = Math.max(Integer.parseInt(s), max);
            } catch (NumberFormatException e){
                    max = Math.max(s.length(),max);
            }
        }
        return max;
    }
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        for(int i = 0; i<arr.length; i++){
            if(target[i]!=arr[i]){
                return false;
            }
        }
        return true;
    }
    public static int[] evenOddBits(int n) {
        int n1 = 0;
        int n2 = 0;
        if(n == 0) return new int[]{0, 0};
        int idx = 0;

        while(n > 0) {
            if(idx % 2 == 0) {
                if((n & 1) == 1) n1++;
            }
            else {
                if((n & 1) == 1) n2++;
            }
            idx++;
            n = (n >> 1);
        }

        return new int[]{n1, n2};
    }
    public static int[] evenOddBit(int n) {
        int [] res = new int [2];
        String bin = new StringBuilder(Integer.toBinaryString(n)).reverse().toString();
        for(int i = 0; i<bin.length(); i++){
            if(bin.charAt(i)=='0'){
                continue;
            }
            if(bin.charAt(i)=='1' && i%2 == 0){
                res[0]++;
            } else res[1]++;
        }
        return res;
    }
    public static int[] nextGreaterElementMap(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }
        for (int i = 0; i < nums1.length; i++)
            nums1[i] = map.getOrDefault(nums1[i], -1);
        return nums1;
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int [] res = new int[nums1.length];
        boolean equal = false;
        for(int i = 0; i<nums1.length; i++){
            for(int j = 0; j<nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    equal = true;
                }
                if(equal && nums1[i]<nums2[j]){
                    res[i] = nums2[j];
                    equal = false;
                    break;
                }
            }
            if(equal){
                res[i] = -1;
                equal = false;
            }
        }
        return res;
    }
    public static int minimumOperationsArr(int[] nums) {
        int count = 0;
        int prev = 0;
        Arrays.sort(nums);
        for(int i : nums){
            if(i!=0 && i!=prev){
                count++;
                prev = i;
            }
        }
        return count;
    }

    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            if(i!=0){
                set.add(i);
            }
        }
        return set.size();
    }
    public int[] intersectionSet(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for(int num : nums1){
            set1.add(num);
        }
        for (int num : nums2) {
            if (set1.contains(num)){
                res.add(num);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> set1 = new HashMap<>();
        Map<Integer, Integer> set2 = new HashMap<>();
        for(int num : nums1){
            set1.put(num, 0);
        }
        for(int num : nums2){
            set2.put(num, 0);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : set1.keySet()) {
            if (set2.containsKey(num)){
                list.add(num);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    public static boolean digitCount(String num) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : num.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) +1);
        }
        for(int i = 0; i<num.length(); i++){
            char iChar = (char)('0' +i);
            int charAtI = Integer.parseInt(num.charAt(i)+"");
            if (!map.containsKey(iChar) && charAtI!=0){
                return false;
            }
            if(map.get(iChar)!=null && charAtI!= map.get(iChar)){
                return false;
            }
        }
        return true;
    }
    public List<String> removeAnagramsString(String[] words) {
        List<String> list = new ArrayList<>();
        String prev = "";
        for (String word : words) {
            char[] currArr = word.toCharArray();
            Arrays.sort(currArr);
            String curr = String.valueOf(currArr);
            if (!curr.equals(prev)) {
                list.add(word);
                prev = curr;
            }
        }
        return list;
    }
    public static List<String> removeAnagramsSort(String[] words) {
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            char [] curr = words[i].toCharArray();
            char [] prev = words[i-1].toCharArray();
            Arrays.sort(curr);
            Arrays.sort(prev);
            if (Arrays.equals(curr, prev)){
                continue;
            }
            list.add(words[i]);
        }
        return list;
    }
    public static List<String> removeAnagrams(String[] words) {
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (areSameCharacters(words[i], words[i-1])){
                continue;
            }
            list.add(words[i]);
        }
        return list;
    }

    public static boolean areSameCharacters(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : str1.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        for (char c : str2.toCharArray()) {
            int count = charCountMap.getOrDefault(c, 0);
            if (count == 0) {
                return false;
            }
            charCountMap.put(c, count - 1);
        }
        return true;
    }
    public int smallestEqual(int[] nums) {
        for(int i = 0; i<nums.length; i++){
            if(i%10 == nums[i]){
                return i;
            }
        }
        return -1;
    }
    public static int countPrefixesStartWith(String[] words, String s) {
        int count = 0;

        for(String word : words){
            if (word.startsWith(s)){
                count++;
            }
        }
        return count;
    }
    public static int countPrefixes(String[] words, String s) {
        int count = 0;
        for (String word : words) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) != word.charAt(j)) {
                    break;
                }
                if (j == word.length() - 1) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    public static String kthDistinctMap(String[] arr, int k) {
        Map<String, Integer> map = new LinkedHashMap<>();
        int count = 0;
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
//        for(Map.Entry<String,Integer> entry : map.entrySet()){
//            if (entry.getValue()==1){
//                count++;
//            }
//            if(count==k){
//                return entry.getKey();
//            }
//        }
        int i = 0;
        for (String s : arr){
            if (map.get(s) == 1 && ++i==k){
                return s;
            }
        }

        return "";
    }
    public static String kthDistinct(String[] arr, int k) {
        int count = 0;
        boolean flag = true;
        for(int i = 0; i<arr.length; i++){
            for (int j = 0; j < arr.length; j++) {
                if (arr[i].equals(arr[j]) && i!=j){
                    flag = false;
                    break;
                }
            }
            if (flag){
                count++;
            } else flag = true;
            if (count==k) return arr[i];
        }
        return "";
    }

    public int maxFrequencyElementsMap(int[] nums) {
        Map<Integer, Integer> um = new HashMap<>();
        for (int x : nums) {
            um.put(x, um.getOrDefault(x, 0) + 1);
        }

        int maxi = 0;
        for (int value : um.values()) {
            maxi = Math.max(maxi, value);
        }

        int ans = 0;
        for (int value : um.values()) {
            if (value == maxi) {
                ans += value;
            }
        }

        return ans;
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