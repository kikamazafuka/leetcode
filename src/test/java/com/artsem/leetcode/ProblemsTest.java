package com.artsem.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class ProblemsTest {

    private int[] numbers;

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

    @Test
    public void testGetAverages(){
        int [] exp = new int[]{-1,-1,-1,5,4,4,-1,-1,-1};
        Assert.assertArrayEquals(exp,Problems.getAverages(numbers, 3));
    }

    @Test
    public void testGetAveragesSame(){
        int [] nums = new int[]{100000};
        int [] exp = new int[]{100000};
        Assert.assertArrayEquals(exp,Problems.getAverages(nums, 0));
    }

    @Test
    public void testGetAveragesSmallLength(){
        int [] nums = new int[]{8};
        int [] exp = new int[]{-1};
        Assert.assertArrayEquals(exp,Problems.getAverages(nums, 100000));
    }
}
