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

    @Test
    public void testProductExceptSelf(){
        int [] nums = new int[]{1,2,3,4};
        int [] exp = new int[]{24,12,8,6};
        Assert.assertArrayEquals(exp,Problems.productExceptSelf(nums));
    }

    @Test
    public void testIncreasingTriplet(){
        int [] nums = new int[]{20,100,10,12,5,13};
        Assert.assertTrue(Problems.increasingTriplet(nums));
    }
    @Test
    public void testIncreasingTriplet1(){
        int [] nums = new int[]{6,7,1,2};
        Assert.assertFalse(Problems.increasingTriplet(nums));
    }
    @Test
    public void testIncreasingTriplet2(){
        int [] nums = new int[]{1,2,3,4,5};
        Assert.assertTrue(Problems.increasingTriplet(nums));
    }
    @Test
    public void testIncreasingTriplet3(){
        int [] nums = new int[]{5,4,3,2,1};
        Assert.assertFalse(Problems.increasingTriplet(nums));
    }
    @Test
    public void testIncreasingTriplet4(){
        int [] nums = new int[]{2,1,5,0,4,6};
        Assert.assertTrue(Problems.increasingTriplet(nums));
    }

    @Test
    public void testCompress(){
        char [] nums = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        Assert.assertEquals(6, Problems.compress(nums));
    }
    @Test
    public void testCompress2(){
        char [] nums = new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        Assert.assertEquals(4, Problems.compress(nums));
    }
    @Test
    public void testCompress3(){
        char [] nums = new char[]{'a', 'a', 'a', 'b', 'b', 'a', 'a'};
        Assert.assertEquals(6, Problems.compress(nums));
    }

    @Test
    public void testCanPlaceFlower(){
        int [] nums = new int[]{1,0,0,0,1};
        Assert.assertTrue( Problems.canPlaceFlowers(nums, 1));
    }
    @Test
    public void testCanPlaceFlower2(){
        int [] nums = new int[]{1,0,0,0,1};
        Assert.assertTrue( Problems.canPlaceFlowers(nums, 2));
    }
    @Test
    public void testCanPlaceFlower3(){
        int [] nums = new int[]{1,0,0,0,0,1};
        Assert.assertFalse( Problems.canPlaceFlowers(nums, 2));
    }
    @Test
    public void testCanPlaceFlower4(){
        int [] nums = new int[]{0,1,0};
        Assert.assertFalse( Problems.canPlaceFlowers(nums, 1));
    }

    @Test
    public void testUniqueOccurrences(){
        int [] nums = new int[]{1,2,2,1,1,3};
        Assert.assertTrue( Problems.uniqueOccurrences(nums));
    }

    @Test
    public void testCloseStrings(){
        Assert.assertTrue( Problems.closeStrings("abc", "cba"));
    }
    @Test
    public void testCloseStrings2(){
        Assert.assertFalse( Problems.closeStrings("a", "aa"));
    }
    @Test
    public void testCloseStrings3(){
        Assert.assertTrue( Problems.closeStrings("cabbba", "abbccc"));
    }
    @Test
    public void testCloseStrings4(){
        Assert.assertFalse( Problems.closeStrings("uau", "ssx"));
    }
    @Test
    public void testCloseStrings5(){
        Assert.assertFalse( Problems.closeStrings("mkmczky", "cckcmmy"));
    }

}
