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
}
