package com.artsem.leetcode;

import java.io.*;
import java.util.*;

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

    public static int countOperations(int num1, int num2) {
        int count = 0;
        while(num1>0 && num2>0){
            if(num1>=num2){
                num1 -= num2;
            } else {
                num2 -= num1;
            }
            count++;
        }
        return count;
    }

    public int rob(int[] nums) {
        if(nums.length==0){
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
        for(int i = 1; i<nums.length; i++){
            int tmp = Math.max(second, first+nums[i]);
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
        for(int i = 2; i<cost.length; i++){
            int res = cost[i] + Math.min(first, sec);
            first = sec;
            sec = res;
        }
        return Math.min(first,sec);
    }

    public static boolean isAllPositiveNumbers(List<String> args) {
        //magic happens here
        for(String s : args){
            if(!Problems.isPositiveNumber(s)){
                return false;
            }
        }
        return true;
    }

    public static boolean isPositiveNumber(String str) {
        if (str == null || str.length()<1 || str.charAt(0)=='-'){
            return false;
        }

        double num;
        try {
            num = Double.parseDouble(str);
        }catch (NullPointerException | NumberFormatException ex){
            return false;
        }

        return num>0;
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
        if(n==0){
            return 0;
        }
        int a = 0;
        int b = 1;
        int c = 1;
        int d = 0;
        for(int i = 3; i<=n; i++){
            d = a+b+c;
            a=b;
            b=c;
            c=d;
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
        for (List<Integer> list : result){
            int curr = list.stream().mapToInt(v -> v).sum();
            if (curr>max){
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

    private static void fillList(com.artsem.leetcode.TreeNode curr, List<Integer> result, int currDepth){
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

        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }

        fillList(curr.right, result, currDepth + 1);
        fillList(curr.left, result, currDepth + 1);

    }
    public static int goodNodes(TreeNode root) {

        int count = 0;
        int max = root.val;
        count = countNodes(root,count, max);


        return count;


    }

    private static int countNodes(TreeNode root, int count, int max) {
        if(root == null){
            return count;
        }
        if(root.val>=max){
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
        List<Integer> arr= new ArrayList<>();
        HashMap<Integer, Integer> map= new HashMap();
        for(int i=0; i<nums1.length; i++)
            map.put(nums1[i], 1);
        for(int i=0; i<nums2.length; i++)
        {
            if(map.containsKey(nums2[i]))
            {
                if(map.get(nums2[i])==1)
                {
                    arr.add(nums2[i]);
                    map.put(nums2[i], 2);
                }
            }
        }
        for(int i=0; i<nums2.length; i++)
        {
            if(!map.containsKey(nums2[i]))
                map.put(nums2[i], 1);
        }
        for(int i=0; i<nums3.length; i++)
        {
            if(map.containsKey(nums3[i]))
            {
                if(map.get(nums3[i])==1)
                {
                    arr.add(nums3[i]);
                    map.put(nums3[i], 2);
                }
            }
        }
        return arr;
    }
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        TreeNode res = null;
        if(root.val == val){
            res = copySubtreeRecursive(root);
            return res;
        }
        res = searchBST(root.left, val);
        if(res != null){
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
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        collectLeaf(root1,list1);
        List<Integer> list2 = new ArrayList<>();
        collectLeaf(root2,list2);
        return list1.equals(list2);
    }

    private static void collectLeaf(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            list.add(root.val);
        }else {
            collectLeaf(root.left, list);
            collectLeaf(root.right, list);
        }

    }
        public static int maxDepth(TreeNode root) {
            if(root == null){
                return 0;
            }
            int left =  maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left,right) + 1;
        }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public int pairSum(ListNode head) {
        // create ListNode copy
        ListNode newNode = new ListNode(head.val);
        ListNode currOrig = head;
        ListNode currCopy = newNode;
        int size = 1;
        while(currOrig.next != null){
            currCopy.next = new ListNode(currOrig.next.val);
            currOrig = currOrig.next;
            currCopy = currCopy.next;
            size++;
        }

        // reverse ListNode copy
        ListNode curr = newNode;
        ListNode prev = null;
        ListNode next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode origCurr = head;
        ListNode revCurr = prev;
        int max = 0;
        int currTwinS = 0;
        while(origCurr != null && revCurr != null){
            currTwinS = origCurr.val + revCurr.val;
            if(currTwinS>max){
                max = currTwinS;
            }
            origCurr = origCurr.next;
            revCurr = revCurr.next;
        }

        //traverse both Lists and count twin sum
        System.out.println("Copy list");
        ListNode trav1 = head;
        while(trav1 != null){
            System.out.println(trav1.val + "");
            trav1 = trav1.next;
        }

        System.out.println("reversed list");
        ListNode trav = prev;
        while(trav != null){
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
        while(curr != null){
            size++;
            System.out.println(curr.val);
            curr = curr.next;
        }
        System.out.println("size = " + size);
        ListNode oddNode = head;
        int count = 0;
        // find node to remove
        while( oddNode != null){
            if(count==size/2){
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
        while(currNode != null){
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
        if(head == null){
            return null;
        }
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode evenHead = evenNode;
        while(oddNode.next != null && evenNode.next != null){
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
        while(goal>0 || start>0){
            int bStart = start & 1;
            int bGoal = goal & 1;
            if(bStart!=bGoal){
                count++;
            }
            start >>=1;
            goal >>=1;
        }
        return count;
    }
}