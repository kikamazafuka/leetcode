package com.artsem.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchiveTest {

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
        Assert.assertArrayEquals(expected,Archive.getAverages(numbers, 40000));
    }

    @Test
    public void testGetAveragesSame(){
        int [] nums = new int[]{100000, 4};
        int [] exp = new int[]{100000,4};
        Assert.assertArrayEquals(exp,Archive.getAverages(nums, 0));
    }

    @Test
    public void testGetAveragesSmallLength(){
        int [] nums = new int[]{8};
        int [] exp = new int[]{-1};
        Assert.assertArrayEquals(exp,Archive.getAverages(nums, 100000));
    }

    @Test
    public void testKidsWithCandies(){
        int [] candies = new int[]{2,3,5,1,3};
        List<Boolean> list = new ArrayList<>(List.of(true,true,true,false,true));
        Assert.assertEquals(list, Archive.kidsWithCandies(candies,3));
    }
    @Test
    public void testKidsWithCandies1(){
        int [] candies = new int[]{4,2,1,1,2};
        List<Boolean> list = new ArrayList<>(List.of(true,false,false,false,false));
        Assert.assertEquals(list, Archive.kidsWithCandies(candies,1));
    }
    @Test
    public void testKidsWithCandies2(){
        int [] candies = new int[]{12,1,12};
        List<Boolean> list = new ArrayList<>(List.of(true,false,true));
        Assert.assertEquals(list, Archive.kidsWithCandies(candies,10));
    }

    @Test
    public void testReverseWordsMed(){
        Assert.assertEquals("example good a", Archive.reverseWordsMed("a good   example"));
    }


    @Test
    public void testMaxVowels(){
        Assert.assertEquals(3, Archive.maxVowels("abciiidef", 3));
    }
    @Test
    public void testMaxVowels2(){
        Assert.assertEquals(2, Archive.maxVowels("aeiou", 2));
    }
    @Test
    public void testMaxVowels3(){
        Assert.assertEquals(2, Archive.maxVowels("leetcode", 3));
    }

    @Test
    public void testLongestOnes(){
        int [] nums = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        Assert.assertEquals(6, Archive.longestOnes(nums, 2));

    }

    @Test
    public void testProductExceptSelf(){
        int [] nums = new int[]{1,2,3,4};
        int [] exp = new int[]{24,12,8,6};
        Assert.assertArrayEquals(exp,Archive.productExceptSelf(nums));
    }

    @Test
    public void testIncreasingTriplet(){
        int [] nums = new int[]{20,100,10,12,5,13};
        Assert.assertTrue(Archive.increasingTriplet(nums));
    }
    @Test
    public void testIncreasingTriplet1(){
        int [] nums = new int[]{6,7,1,2};
        Assert.assertFalse(Archive.increasingTriplet(nums));
    }
    @Test
    public void testIncreasingTriplet2(){
        int [] nums = new int[]{1,2,3,4,5};
        Assert.assertTrue(Archive.increasingTriplet(nums));
    }
    @Test
    public void testIncreasingTriplet3(){
        int [] nums = new int[]{5,4,3,2,1};
        Assert.assertFalse(Archive.increasingTriplet(nums));
    }
    @Test
    public void testIncreasingTriplet4(){
        int [] nums = new int[]{2,1,5,0,4,6};
        Assert.assertTrue(Archive.increasingTriplet(nums));
    }

    @Test
    public void testCompress(){
        char [] nums = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        Assert.assertEquals(6, Archive.compress(nums));
    }
    @Test
    public void testCompress2(){
        char [] nums = new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        Assert.assertEquals(4, Archive.compress(nums));
    }
    @Test
    public void testCompress3(){
        char [] nums = new char[]{'a', 'a', 'a', 'b', 'b', 'a', 'a'};
        Assert.assertEquals(6, Archive.compress(nums));
    }

    @Test
    public void testCanPlaceFlower(){
        int [] nums = new int[]{1,0,0,0,1};
        Assert.assertTrue( Archive.canPlaceFlowers(nums, 1));
    }
    @Test
    public void testCanPlaceFlower2(){
        int [] nums = new int[]{1,0,0,0,1};
        Assert.assertTrue( Archive.canPlaceFlowers(nums, 2));
    }
    @Test
    public void testCanPlaceFlower3(){
        int [] nums = new int[]{1,0,0,0,0,1};
        Assert.assertFalse( Archive.canPlaceFlowers(nums, 2));
    }
    @Test
    public void testCanPlaceFlower4(){
        int [] nums = new int[]{0,1,0};
        Assert.assertFalse( Archive.canPlaceFlowers(nums, 1));
    }

    @Test
    public void testUniqueOccurrences(){
        int [] nums = new int[]{1,2,2,1,1,3};
        Assert.assertTrue( Archive.uniqueOccurrences(nums));
    }

    @Test
    public void testCloseStrings(){
        Assert.assertTrue( Archive.closeStrings("abc", "cba"));
    }
    @Test
    public void testCloseStrings2(){
        Assert.assertFalse( Archive.closeStrings("a", "aa"));
    }
    @Test
    public void testCloseStrings3(){
        Assert.assertTrue( Archive.closeStrings("cabbba", "abbccc"));
    }
    @Test
    public void testCloseStrings4(){
        Assert.assertFalse( Archive.closeStrings("uau", "ssx"));
    }
    @Test
    public void testCloseStrings5(){
        Assert.assertFalse( Archive.closeStrings("mkmczky", "cckcmmy"));
    }
    @Test
    public void testCloseStrings6(){
        Assert.assertFalse( Archive.closeStrings("aaac", "aacc"));
    }

    @Test
    public void testEqualPairs(){
        int [][] nums = new int[][]{{3,2,1},{1,7,6},{2,7,7}};
        Assert.assertEquals(1, Archive.equalPairs(nums));
    }
    @Test
    public void testEqualPairs2(){
        int [][] nums = new int[][]{{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
        Assert.assertEquals(3, Archive.equalPairs(nums));
    }

    @Test
    public void testRemoveStars(){
        String s = "leet**cod*e";
        Assert.assertEquals("lecoe", Archive.removeStars(s));
    }

    @Test
    public void testBackspaceCompare(){
        String s = "ab#c";
        String t = "ad#c";
        Assert.assertTrue( Archive.backspaceCompare(s, t));
    }
    @Test
    public void testBackspaceCompare2(){
        String s = "y#fo##f";
        String t = "y#f#o##f";
        Assert.assertTrue( Archive.backspaceCompare(s, t));
    }

    @Test
    public void testMakeGood(){
        Assert.assertEquals("", Archive.makeGood("Pp"));
    }
    @Test
    public void testMakeGood1(){
        Assert.assertEquals("leetcode", Archive.makeGood( "leEeetcode"));
    }
    @Test
    public void testMakeGood2(){
        Assert.assertEquals("", Archive.makeGood("abBAcC"));
    }

    @Test
    public void testPredictPartyVictory(){
        Assert.assertEquals("Dire", Archive.predictPartyVictory( "DDRRR"));
    }
    @Test
    public void testPredictPartyVictory1(){
        Assert.assertEquals("Radiant", Archive.predictPartyVictory( "RD"));
    }
    @Test
    public void testPredictPartyVictory2(){
        Assert.assertEquals("Dire", Archive.predictPartyVictory( "RDD"));
    }

    @Test
    public void testSingleNumber(){
        int [] nums = new int[]{6,1,2,1,2};
        Assert.assertEquals(4, Archive.singleNumber(nums));
    }

    @Test
    public void testCountBits1(){
        int [] nums = new int[]{0,1,1};
        Assert.assertArrayEquals(nums, Archive.countBits1(5));
    }

    @Test
    public void testCountBits11(){
        int [] nums = new int[]{0};
        Assert.assertArrayEquals(nums, Archive.countBits1(0));
    }

    @Test
    public void testMinFlips(){
        Assert.assertEquals(3, Archive.minFlips(2,6,5));
    }
    @Test
    public void testMinFlips1(){
        Assert.assertEquals(1, Archive.minFlips(4,2,7));
    }
    @Test
    public void testMinFlips2(){
        Assert.assertEquals(0, Archive.minFlips(1,2,3));
    }



}
