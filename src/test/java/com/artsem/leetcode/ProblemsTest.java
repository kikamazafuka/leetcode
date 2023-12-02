package com.artsem.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProblemsTest {

    private int[] numbers;
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
    public void testGetAverages(){
        int [] exp = new int[]{-1,-1,-1,5,4,4,-1,-1,-1};
        Assert.assertArrayEquals(expected,Problems.getAverages(numbers, 40000));
    }

    @Test
    public void testGetAveragesSame(){
        int [] nums = new int[]{100000, 4};
        int [] exp = new int[]{100000,4};
        Assert.assertArrayEquals(exp,Problems.getAverages(nums, 0));
    }

    @Test
    public void testGetAveragesSmallLength(){
        int [] nums = new int[]{8};
        int [] exp = new int[]{-1};
        Assert.assertArrayEquals(exp,Problems.getAverages(nums, 100000));
    }

    @Test
    public void testKidsWithCandies(){
        int [] candies = new int[]{2,3,5,1,3};
        List<Boolean> list = new ArrayList<>(List.of(true,true,true,false,true));
        Assert.assertEquals(list, Problems.kidsWithCandies(candies,3));
    }
    @Test
    public void testKidsWithCandies1(){
        int [] candies = new int[]{4,2,1,1,2};
        List<Boolean> list = new ArrayList<>(List.of(true,false,false,false,false));
        Assert.assertEquals(list, Problems.kidsWithCandies(candies,1));
    }
    @Test
    public void testKidsWithCandies2(){
        int [] candies = new int[]{12,1,12};
        List<Boolean> list = new ArrayList<>(List.of(true,false,true));
        Assert.assertEquals(list, Problems.kidsWithCandies(candies,10));
    }

    @Test
    public void testReverseWordsMed(){
        Assert.assertEquals("example good a", Problems.reverseWordsMed("a good   example"));
    }


    @Test
    public void testMaxVowels(){
        Assert.assertEquals(3, Problems.maxVowels("abciiidef", 3));
    }
    @Test
    public void testMaxVowels2(){
        Assert.assertEquals(2, Problems.maxVowels("aeiou", 2));
    }
    @Test
    public void testMaxVowels3(){
        Assert.assertEquals(2, Problems.maxVowels("leetcode", 3));
    }

    @Test
    public void testLongestOnes(){
        int [] nums = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        Assert.assertEquals(6, Problems.longestOnes(nums, 2));

    }
}
