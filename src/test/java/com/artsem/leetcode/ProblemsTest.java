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
    public void testAddBinary(){
        Assert.assertEquals("100",Problems.addBinary("11", "1"));
    }


    @Test
    public void testAddBinary2(){
        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        Assert.assertEquals("100",Problems.addBinary(a, b));
    }
    @Test
    public void testRemoveDuplicates(){
        int [] st = new int[]{1,1,2};
        Assert.assertEquals(2,Problems.removeDuplicates(st));
    }
    @Test
    public void testRemoveDuplicates2(){
        int [] st = new int[]{0,0,1,1,1,2,2,3,3,4};
        Assert.assertEquals(5,Problems.removeDuplicates(st));
    }
    @Test
    public void testRemoveDuplicates3(){
        int [] st = new int[]{1,1,1};
        Assert.assertEquals(1,Problems.removeDuplicates(st));
    }
    @Test
    public void testTwoSum(){
        int [] st = new int[]{2,7,11,15};
        int [] res = new int[]{1,2};
        Assert.assertArrayEquals(res,Problems.twoSum(st,9));
    }
    @Test
    public void testTwoSum1(){
        int [] st = new int[]{2,3,4};
        int [] res = new int[]{1,3};
        Assert.assertArrayEquals(res,Problems.twoSum(st,6));
    }
    @Test
    public void testTwoSum2(){
        int [] st = new int[]{-1,0};
        int [] res = new int[]{1,2};
        Assert.assertArrayEquals(res,Problems.twoSum(st,-1));
    }
    @Test
    public void testTwoSum3(){
        int [] st = new int[]{5,25,75};
        int [] res = new int[]{2,3};
        Assert.assertArrayEquals(res,Problems.twoSum(st,100));
    }
    @Test
    public void testTwoSum4(){
        int [] st = new int[]{12,13,23,28,43,44,59,60,61,68,70,86,88,92,124,125,136,168,173,173,180,199,212,221,227,230,277,282,306,314,316,321,325,328,336,337,363,365,368,370,370,371,375,384,387,394,400,404,414,422,422,427,430,435,457,493,506,527,531,538,541,546,568,583,585,587,650,652,677,691,730,737,740,751,755,764,778,783,785,789,794,803,809,815,847,858,863,863,874,887,896,916,920,926,927,930,933,957,981,997};
        int [] res = new int[]{24,32};
        Assert.assertArrayEquals(res,Problems.twoSum_bs(st,542));
    }
    @Test
    public void testTwoSum5(){
        int [] st = new int[]{-1,-1,1,1,1,1,1,1,1,1,1,1,1};
        int [] res = new int[]{1,2};
        Assert.assertArrayEquals(res,Problems.twoSum(st,-2));
    }
    @Test
    public void testMaxProfit(){
        int [] st = new int[]{7,1,5,3,6,4};
        Assert.assertEquals(7,Problems.maxProfit(st));
    }

    @Test
    public void testMaxProfitFee(){
        int [] st = new int[]{1,3,2,8,4,9};
        Assert.assertEquals(8,Problems.maxProfit(st,2));
    }
    @Test
    public void testMaxProfitFee2(){
        int [] st = new int[]{1,3,7,5,10,3};
        Assert.assertEquals(6,Problems.maxProfit(st,3));
    }
    @Test
    public void testMaxProfitFee3(){
        int [] st = new int[]{7,1,5,3,6,4};
        Assert.assertEquals(5,Problems.maxProfit1(st));
    }
    @Test
    public void testMaxProfitFee4(){
        int [] st = new int[]{1,2};
        Assert.assertEquals(1,Problems.maxProfit1(st));
    }
}

