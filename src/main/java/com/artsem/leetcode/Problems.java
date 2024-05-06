package com.artsem.leetcode;

import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;

public class Problems {
    public static void main(String[] args) {

        Character c = 'c';
        c = Character.toTitleCase(c);
        System.out.println(c);
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
        List<Integer> ls = new ArrayList<>(List.of(1,2,3));
        ls.remove(2);
    }


    public static int stringChallenge(String str){
        StringBuilder sb = new StringBuilder(str);
        boolean canBeReduced = true;
        while (canBeReduced) {
            canBeReduced=false;
            for (int i = 0; i < sb.length() - 1; i++) {
                char curr = sb.charAt(i);
                char next = sb.charAt(i+1);
                if (curr != next) {
                    String newChar = guessChar(curr, next);
                    sb.deleteCharAt(i).deleteCharAt(i).insert(i, newChar);
                    canBeReduced=true;
                }
            }
        }
        return sb.length();
    }
    private static String guessChar(char a, char b){
        if ((a == 'a' && b == 'b')||(a == 'b' && b == 'a')){
            return "c";
        } else if ((a == 'b' && b == 'c')||(a == 'c' && b == 'b')){
            return "a";
        } else return "b";
    }
    public static int decrNum(int num){
        int count = 0;
        while(num>=10){
            int currSum = 0;
            while(num>0){
                int digit = num % 10;
                currSum += digit;
                num /= 10;
            }
            num = currSum;
            count++;
        }
        return count;
    }
    public int countKeyChanges(String s) {
        String low = s.toLowerCase();
        int count = 0;
        for(int i = 0; i<s.length()-1; i++){
            char curr = low.charAt(i);
            char next = low.charAt(i+1);
            if(next!=curr)count++;
        }
        return count;
    }
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for(int i = 0; i<words.length; i++){
            for(int j = i + 1; j< words.length; j++){
                if(isPrefixAndSuffix(words[i], words[j])){
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isPrefixAndSuffix(String str1, String str2){
        if(str1.length()>str2.length()){
            return false;
        }
        for(int i = 0; i<str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)){
                return false;
            }
        }
        for(int i = str1.length()-1, j = str2.length()-1; i>=0; i--, j--){
            if(str1.charAt(i) != str2.charAt(j)){
                return false;
            }
        }
        return true;
    }
    public int addedInteger(int[] nums1, int[] nums2) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int i = 0; i<nums1.length; i++){
            min1 = Math.min(min1, nums1[i]);
            min2 = Math.min(min2, nums2[i]);
        }
        return min2 - min1;
    }

    public static int addedIntegerSort(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        return nums2[0] - nums1[0];
    }
    public static boolean isSubstringPresentOnePath(String s) {
        for (int index = 0; index + 1 < s.length(); index++) {
            if (s.charAt(index) == s.charAt(index + 1))
                return true;
        }
        for (int index = 1; index + 1 < s.length(); index++) {
            if (s.charAt(index - 1) == s.charAt(index + 1))
                return true;
        }
        return false;
    }
    public static boolean isSubstringPresent(String s) {
        Set<String> sub = new HashSet<>();
        for(int i = 0; i<s.length()-1; i++){
            sub.add("" + s.charAt(i)+s.charAt(i+1));
        }
        for(int i = s.length()-1; i>0; i--){
            String str = "" + s.charAt(i) + s.charAt(i-1);
            if(sub.contains(str)){
                return true;
            }
        }
        return false;
    }

    public static int minOperationsBinS(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length-1;
        while(l<r){
            int mid = l + (r-l)/2;
            if(nums[mid]==k){
                while (nums[mid]==k){
                    mid--;
                    if (mid<0) break;
                }
                return mid+1;
            }
            if(nums[mid]<k){
                l = mid + 1;
            } else r = mid;
        }
        return l;
    }
    public int minOperations(int[] nums, int k) {
        int count = 0;
        for(int n : nums){
            if(n<k) count++;
        }
        return count;
    }

    public int longestMonotonicSubarray(int[] nums) {
        int maxInc = 1;
        int currInc = 1;
        for(int i = 0; i<nums.length-1; i++){
            if(nums[i]<nums[i+1]){
                currInc++;
                maxInc = Math.max(maxInc, currInc);
            } else currInc = 1;
        }
        int maxDec = 1;
        int currDec = 1;
        for(int i = 0; i<nums.length-1; i++){
            if(nums[i]>nums[i+1]){
                currDec++;
                maxDec = Math.max(maxDec, currDec);
            } else currDec = 1;
        }
        return Math.max(maxInc, maxDec);
    }
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int digSum = 0;
        int temp = x;
        while(x>0){
            digSum += x % 10;
            x /= 10;
        }
        if(temp % digSum == 0){
            return digSum;
        }
        return -1;
    }
    public int scoreOfString(String s) {
        int res = 0;
        for(int i = 0; i<s.length()-1; i++){
            res += Math.abs(s.charAt(i) - s.charAt(i+1));
        }
        return res;
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        if(compareMatrix(mat, target) == 0){
            return true;
        }
        rotate(mat);
        int res = compareMatrix(mat, target);
        rotate(mat);
        res += compareMatrix(mat, target);
        rotate(mat);
        res += compareMatrix(mat, target);

        return res<3;
    }

    private static int compareMatrix(int[][] mat, int[][] target){
        int count = 0;
        for(int i = 0; i<mat.length; i++){
            boolean flag = false;
            for(int j = 0; j<mat[0].length; j++){
                if(mat[i][j] != target[i][j]){
                    count++;
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }
        return count;
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode res = new TreeNode();
        res.val = root1.val + root2.val;

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.offer(root1);
        q2.offer(root2);
        while(!q1.isEmpty() || !q2.isEmpty()){
            TreeNode node = new TreeNode();
            int newVal = 0;
            if(root1.left != null){
                newVal = root1.left.val;
            }
            if(root2.left != null){
                newVal += root2.left.val;
            }
            node.val = newVal;
        }
        return new TreeNode();

    }
    public static TreeNode increasingBST(TreeNode root) {
        return increasingBST(root, null);
    }

    private static TreeNode increasingBST(TreeNode root, TreeNode tail){
        if(root == null){
            return tail;
        }
        TreeNode res = increasingBST(root.left, root);
        root.left = null;
        root.right = increasingBST(root.right, tail);
        return res;
    }
    public static boolean isUnivalTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode n = q.poll();
            if(n.val != root.val){
                return false;
            }
            if (n.left!=null) q.offer(n.left);
            if (n.right!=null) q.offer(n.right);
        }
        return true;
    }
    public boolean isUnivalTreeRecurs(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        UtilityClass.dfs(root, set);
        return set.size() == 1;
    }
    public boolean evaluateTree(TreeNode root) {
        if(root.val == 1){
            return true;
        }
        if(root.val == 0){
            return false;
        }
        if(root.val == 2){
            return evaluateTree(root.left) || evaluateTree(root.right);
        }
        return evaluateTree(root.left) && evaluateTree(root.right);
    }
    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left =  maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right) + 1;
    }
    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        while(l<r){
            int mid = l + (r-l)/2;
            if(guess(mid) == 0){
                return mid;
            }
            if(guess(mid) == -1) {
                r = mid;
            }
            if(guess(mid) == 1){
                l = mid+1;
            }
        }
        return l;
    }
    private static int guess(int n){
        return 1;
    }
    public static String codelandUsernameValidation(String str) {

        if(str.length() < 4 || str.length() > 25 || str.charAt(str.length()-1) == '_'){
            return "false";
        }
        for(char c : str.toCharArray()){
            if(c != '_' && !isLetter(c) && !isDigit(c)){
                return "false";
            }
        }
        // code goes here
        return "true";
    }
    public static boolean isLetter(char c) {
        return Character.isLetter(c);
    }
    public static boolean isDigit(char c) {
        return Character.isDigit(c);
    }
    public static int reverseMath(int x) {

        int result = 0;
        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x = x / 10;
        }
        return result;
    }
    public static int reverse(int x) {
        try {
            String num = String.valueOf(Math.abs(x));
            StringBuilder sb = new StringBuilder(num);
            int res = Integer.parseInt(sb.reverse().toString());
            res = x < 0 ? res*(-1) : res;
            return res;
        } catch (NumberFormatException a){
            return 0;
        }
    }
    public void rotate(int[][] matrix) {
        for(int i = 0; i<matrix.length; i++){
            for(int j = i+1; j<matrix[0].length; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length/2; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = tmp;
            }
        }
    }
    public void moveZeroes(int[] nums) {
        int k = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]!=0){
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                k++;
            }
        }
    }
    public static int minSubArrayLenSlidWin(int target, int[] nums) {
        int sum = 0;
        int k = 0;
        int curLen = 0;
        int minLen = Integer.MAX_VALUE;

        for(int i = 0; i<nums.length; i++){
            sum += nums[i];
            curLen++;
            if(sum>=target){
                while(sum>=target){
                    if(minLen>curLen){
                        minLen=curLen;
                    }
                    sum -= nums[k];
                    k++;
                    curLen--;
                }
            }
        }
        if (minLen==Integer.MAX_VALUE) return 0;
        return minLen;
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int len = 0;
        int minLen = Integer.MAX_VALUE;
        int k = 0;
        for (int i = 0; i<nums.length; i++) {
            sum += nums[i];
            len++;
            if (sum >= target) {
                if (minLen > len) {
                    minLen = len;
                }
                k++;
                i=k;
                len = 0;
                sum = 0;
            }
        }
        if (minLen==Integer.MAX_VALUE) return 0;
        return minLen;
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