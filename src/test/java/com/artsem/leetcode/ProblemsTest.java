package com.artsem.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProblemsTest {

    TreeNode treeNode = new TreeNode(1);
    private int[] numbers;
    private int[] numbers2;
    private int[] expected;

    @Before
    public void testReadContentFileFromResources() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("content.txt");
        if (inputStream == null) {
            throw new IOException("Resource not found: content.txt");
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = reader.readLine();
            if (line != null) {
                String[] numberStrings = line.split(",");
                numbers = new int[numberStrings.length];
                for (int i = 0; i < numberStrings.length; i++) {
                    numbers[i] = Integer.parseInt(numberStrings[i].trim());
                }
            }
        }
    }
    @Before
    public void testReadContent2FileFromResources() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("content2.txt");
        if (inputStream == null) {
            throw new IOException("Resource not found: content.txt");
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = reader.readLine();
            if (line != null) {
                String[] numberStrings = line.split(",");
                numbers2 = new int[numberStrings.length];
                for (int i = 0; i < numberStrings.length; i++) {
                    numbers2[i] = Integer.parseInt(numberStrings[i].trim());
                }
            }
        }
    }
    @Before
    public void testReadExpectedFileFromResources() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("expected.txt");
        if (inputStream == null) {
            throw new IOException("Resource not found: content.txt");
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = reader.readLine();
            if (line != null) {
                String[] numberStrings = line.split(",");
                expected = new int[numberStrings.length];
                for (int i = 0; i < numberStrings.length; i++) {
                    expected[i] = Integer.parseInt(numberStrings[i].trim());
                }
            }
        }
    }
    @Test
    public void testTwoOutOfThree(){
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(1);
        var objects = list.toArray();

        int [] nums = new int[]{3,1};
        int [] nums1 = new int[]{2,3};
        int [] nums2 = new int[]{1,2};
        List<Integer> res = Problems.twoOutOfThree(nums, nums1, nums2);
        var objects1 = res.toArray();
        Assert.assertArrayEquals(objects, objects1);
    }

    @Test
    public void testRightSideView(){
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(4);
        treeNode.right = new TreeNode(3);
        List<Integer> res = Problems.rightSideView(treeNode);
        List<Integer> exp = List.of(1, 3, 4);

        Assert.assertEquals(exp, res);
    }

    @Test
    public void testGetNodesAtEachLevel(){
        treeNode.left = new TreeNode(7);
        treeNode.right = new TreeNode(0);
        treeNode.left.left = new TreeNode(7);
        treeNode.left.left = new TreeNode(-8);

        int res = Problems.getNodesAtEachLevel(treeNode);
        List<Integer> exp = List.of(1, 3, 4);

        Assert.assertEquals(exp, res);
    }

    @Test
    public void testTribonacci(){

        Assert.assertEquals(4, Problems.tribonacci(4));
    }
    @Test
    public void testIsPositiveNumberNegative(){
        Assert.assertFalse( Problems.isPositiveNumber("-11.22"));
    }
    @Test
    public void testIsPositiveNumberPositiveDouble(){
        boolean res = Problems.isPositiveNumber("11.22");
        Assert.assertTrue(res);
    }
    @Test
    public void testIsPositiveNumberPositive(){
        boolean res = Problems.isPositiveNumber("5");
        Assert.assertTrue(res);
    }
    @Test
    public void testIsPositiveNumberNull(){
        boolean res = Problems.isPositiveNumber("null");
        Assert.assertFalse(res);
    }
    @Test
    public void testIsPositiveNumberEmpty(){
        boolean res = Problems.isPositiveNumber("");
        Assert.assertFalse(res);
    }
    @Test
    public void testIsPositiveNumberSpace(){
        boolean res = Problems.isPositiveNumber(" ");
        Assert.assertFalse(res);
    }
    @Test
    public void testIsPositiveNumberNul(){
        boolean res = Problems.isPositiveNumber(null);
        Assert.assertFalse(res);
    }
    @Test
    public void testIsPositiveNumberZero(){
        boolean res = Problems.isPositiveNumber("088");
        Assert.assertTrue(res);
    }
    @Test
    public void testIsAllPositiveNumbersNeg(){
        boolean res = Problems.isAllPositiveNumbers(List.of("-11.22", "0", "33", "87"));
        Assert.assertFalse(res);
    }
    @Test
    public void testIsAllPositiveNumbersNull(){
        boolean res = Problems.isAllPositiveNumbers(List.of( "0", "33", "87", "-5"));
        Assert.assertFalse(res);
    }

    @Test
    public void testMinCostClimbingStairs(){
        int [] nums = new int[]{10, 15,20};
        Assert.assertEquals(15, Problems.minCostClimbingStairs(nums));
    }

    @Test
    public void testCountOperations(){
        Assert.assertEquals(3, Problems.countOperations(2,3));
    }

    @Test
    public void testCanVisitAllRooms(){
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> room1 = List.of(1);
        List<Integer> room2 = List.of(2);
        List<Integer> room3 = List.of(3);
        List<Integer> room4 = List.of();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        Assert.assertTrue(Problems.canVisitAllRooms(rooms));
    }
    @Test
    public void testCanVisitAllRooms2(){
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> room1 = List.of(4);
        List<Integer> room2 = List.of(3);
        List<Integer> room3 = List.of();
        List<Integer> room4 = List.of(2,5,7);
        List<Integer> room5 = List.of(1);
        List<Integer> room6 = List.of();
        List<Integer> room7 = List.of(8,9);
        List<Integer> room8 = List.of();
        List<Integer> room9 = List.of();
        List<Integer> room10 = List.of(6);

        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        rooms.add(room5);
        rooms.add(room6);
        rooms.add(room7);
        rooms.add(room8);
        rooms.add(room9);
        rooms.add(room10);

        Assert.assertFalse(Problems.canVisitAllRooms(rooms));
    }

    @Test
    public void testMinTimeToType(){
        Assert.assertEquals(7, Problems.minTimeToType("bza"));
    }

    @Test
    public void testSuccessfulPairsFromResources(){
        Assert.assertArrayEquals(expected,Problems.successfulPairs(numbers, numbers2, 1651505078));
    }
    @Test
    public void testSuccessfulPairs(){
        int [] nums = new int[]{5,1,3};
        int [] nums2 = new int[]{1,2,3,4,5};
        int [] exp = new int[]{4,0,3};
        Assert.assertArrayEquals(exp,Problems.successfulPairs(nums, nums2, 7));
    }
    @Test
    public void testSuccessfulPairs2(){
        int [] nums = new int[]{15,14,39};
        int [] nums2 = new int[]{22};
        int [] exp = new int[]{1,1,1};
        Assert.assertArrayEquals(exp,Problems.successfulPairs(nums, nums2, 224));
    }

    @Test
    public void testFindPeaks(){
        int [] nums = new int[]{1,4,3,8,5};

        Assert.assertEquals(List.of(1,3),Problems.findPeaks(nums));
    }

    @Test
    public void testCountSymmetricIntegers(){
        Assert.assertEquals(9,Problems.countSymmetricIntegers(1,100));
    }
    @Test
    public void testCountSymmetricIntegers2(){
        Assert.assertEquals(4,Problems.countSymmetricIntegers(1200,1230));
    }
    @Test
    public void testCountSymmetricIntegers3(){
        Assert.assertEquals(44,Problems.countSymmetricIntegers(100,1782));
    }

    @Test
    public void testDailyTemperatures(){
        int [] nums = new int[]{73,74,75,71,69,72,76,73};
        int [] exp = new int[]{1,1,4,2,1,1,0,0};
        Assert.assertArrayEquals(exp,Problems.dailyTemperatures(nums));
    }

    @Test
    public void testIsSumEqual(){
        Assert.assertTrue(Problems.isSumEqual("j","j","bi"));
    }
    @Test
    public void testIsSumEqual2(){
        Assert.assertTrue(Problems.isSumEqual("acb","cba","cdb"));
    }

    @Test
    public void testPascalTriangleGenerate(){
        List<Integer> list1 = new ArrayList<>(List.of(1));
        List<Integer> list2 = new ArrayList<>(List.of(1,1));
        List<Integer> list3 = new ArrayList<>(List.of(1,2,1));
        List<Integer> list4 = new ArrayList<>(List.of(1,3,3,1));
        List<Integer> list5 = new ArrayList<>(List.of(1,4,6,4,1));
        List<List<Integer>> res = new ArrayList<>(List.of(list1,list2,list3,list4,list5));
//        res.add(list1);
//        res.add(list2);
//        res.add(list3);
//        res.add(list4);
//        res.add(list5);
        Assert.assertEquals(res,Problems.pascalTriangleGenerate(5));
    }

    @Test
    public void tetsFindKthLargest(){
        int [] nums = new int[]{3,2,1,5,6,4};
        Assert.assertEquals(5,Problems.findKthLargest(nums,2));
    }
    @Test
    public void tetsFindKthLargest2(){
        int [] nums = new int[]{3,2,3,1,2,4,5,5,6};
        Assert.assertEquals(4,Problems.findKthLargest(nums,4));
    }

    @Test
    public void testMaximumUnits(){
        int [][] nums = new int[][]{{1,3},{2,2},{3,1}};
        Assert.assertEquals(8, Problems.maximumUnits(nums,4));
    }
    @Test
    public void testMaximumUnits2(){
        int [][] nums = new int[][]{{5,10},{2,5},{4,7},{3,9}};
        Assert.assertEquals(91, Problems.maximumUnits(nums,10));
    }

    @Test
    public void testKWeakestRows(){
        int [][] nums = new int[][]{{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        int [] exp = new int[]{2,0,3};
        Assert.assertArrayEquals(exp, Problems.kWeakestRows2(nums,3));
    }

    @Test
    public void testCountBalls(){
        Assert.assertEquals(2, Problems.countBalls(1,10));
    }
    @Test
    public void testCountBalls2(){
        Assert.assertEquals(2, Problems.countBalls(5,15));
    }
    @Test
    public void testCountBalls3(){
        Assert.assertEquals(2, Problems.countBalls(19,28));
    }

    @Test
    public void testMergeArrays(){
        int [][] nums1 = new int[][]{{1,2},{2,3},{4,5}};
        int [][] nums2 = new int[][]{{1,4},{3,2},{4,1}};
        int [][] exp = new int[][]{{1,6},{2,3},{3,2},{4,6}};
        Assert.assertArrayEquals(exp, Problems.mergeArraysMergeSort(nums1,nums2));
    }
    @Test
    public void testMergeArrays2(){
        int [][] nums1 = new int[][]{{2,4},{3,6},{5,5}};
        int [][] nums2 = new int[][]{{1,3},{100,3},{900,3},{700,3}};
        int [][] exp = new int[][]{{1,3},{2,4},{3,6},{4,3},{5,5}};
        Assert.assertArrayEquals(exp, Problems.mergeArrays(nums1,nums2));
    }

    @Test
    public void testSplitWordsBySeparator(){
        List<String> list1 = new ArrayList<>(List.of("one.two.three","four.five","six"));
        List<String> exp = new ArrayList<>(List.of("one","two","three","four","five","six"));
        Assert.assertEquals(exp,Problems.splitWordsBySeparator(list1,'.'));
    }
    @Test
    public void testSplitWordsBySeparator2(){
        List<String> list1 = new ArrayList<>(List.of("one.two.three","four.five","six"));
        List<String> exp = new ArrayList<>(List.of("one","two","three","four","five","six"));
        Assert.assertEquals(exp,Problems.splitWordsBySeparator(list1,'.'));
    }
    @Test
    public void testSplitWordsBySeparator3(){
        List<String> list1 = new ArrayList<>(List.of("$easy$","$problem$"));
        List<String> exp = new ArrayList<>(List.of("easy","problem"));
        Assert.assertEquals(exp,Problems.splitWordsBySeparator(list1,'$'));
    }
}
