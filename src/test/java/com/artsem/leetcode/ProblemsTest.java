package com.artsem.leetcode;

import com.artsem.leetcode.easy.AppleRedistributionIntoBoxes;
import com.artsem.leetcode.easy.FindTheSumOfEncryptedIntegers;
import com.artsem.leetcode.easy.MaximumLengthSubstringWithTwoOccurrences;
import org.junit.Assert;
import org.junit.Before;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;


public class ProblemsTest {
    final static List<Integer> ints = new ArrayList<>();


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
    private static Object[][] provideArrays() {
//        apple = [1,3,2], capacity = [4,3,1,5,2]
        return new Object[][] {
                { new int[]{4,3,1,5,2}, new int[]{1,3,2}, 2 },

        };
    }
    static Stream<Arguments> arraysProvider() {
        return Stream.of(
                arguments(new int[]{4,3,1,5,2},  new int[]{1,3,2}, 2),
                arguments(new int[]{2,4,2,7},  new int[]{5,5,5}, 4)

        );
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
        int [] provided = new int[]{2,3,4};
        int [] expected = new int[]{1,3};
        int num = 6;
        Assert.assertArrayEquals(expected,Problems.twoSum(provided,num));
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
    @Test
    public void testBuyChoco(){
        int [] st = new int[]{1,2,2};
        Assert.assertEquals(0,Problems.buyChoco(st,3));
    }
    @Test
    public void testBuyChoco1(){
        int [] st = new int[]{46,56,41};
        Assert.assertEquals(79,Problems.buyChoco(st,79));
    }
    @Test
    public void testFindTheArrayConcVal(){
        int [] st = new int[]{5,14,13,8,12};
        Assert.assertEquals(673,Problems.findTheArrayConcVal(st));
    }
    @Test
    public void testFindTheArrayConcVal2(){
        int [] st = new int[]{2848,9866,372,4727,3207,6705,5001,1521,8267,3943,8568,3255,8622,1592,7030,6277,3757,5885,4513,7553,8342,2491,9735,5697,2886,5989,9812,7808,4799,1648,8518,4545,4473,6328,5215,8287,6906,7115,2777,57,1550,5068,1450,6194,4731,101,2343,9511,3856,7446,7581,3239,9060,2796,3037,6215,5350,208,4015,5195,3712,2974,5660,9320,5678,1117,5067,8518,7921,4261,3267,5754,6109,5075,8405,1342,4313,6535,1632,7894,8827,7818,5904,1090,38,4129,2909,329,1774,5496,6127,2612,8891,6455,9636,4157,6297,1487,4113,8666,8305,2300,7249,9912,3716,1113,3313,6521,1898,5740,6789,2183,6999,329,4175,4691,2334,5739,1723,3061,5838,8040,1997,4972,1949,2943,6254,8851,8447,3878,2987,8876,3770,6129,1797,2310,4822,8407,9777,9250,7103,3808,510,7203,2993,5054,7421,912,8706,8376,2176,5342,850,9922,6162,7473,4528,4005,1921,2976,5484,7362,396,9263,9154,4712,942,3454,5829,3230,6595,7363,3774,8795,7326,36,9036,9901,6258,2068,6567,4635,7388,9016,1333,1761,4005,3135,1528,7508,5863,7929,4401,5334,7507,5041,436,4345,9553,4214,7199,5933,6106,4072,3675,9173,4333,6663,6678,523,6507,4956,1285,1782,5551,6586,6558,352,7467,663,2104,902,4012,2711,8663,9866,3728,6006,3140,3788,6601,4881,3643,3318,4062,176,3889,4191,9054,3612,7789,5329,8691,6753,9302,459,2503,148,9854,7834,9388,1597,8170,7189,3749,8988,495,7905,3845,3427,3866,5869,1606,2425,1980,3851,7855,3913,823,2072,4144,1401,7049,1315,1668,4830,7798,3163,3353,9958,7144,9939,7944,9281,7658,1071,5127,5140,6119,588,7938,3771,6018,9524,9035,5241,8254,2987,2481,8738,3314,6139,5421,4678,182,236,9416,8267,5259,5060,8844,9357,1404,9048,7858,9140,8637,3181,7727,6113,694,1257,2551,5706,7844,9794,9936,600,8811,2772,8436,8954,2564,505,8947,145,8167,7619,2587,5685,5030,9592,2661,5209,6557,9842,3232,221,9843,4773,4418,1964,4785,772,1687,1582,8023,264,1508,3080,3297,4725,4569,6518,6146,1061,5673,4254,9487,2102,1378,696,8138,4022,9125,1227,2160,6881,167,33,6286,5230,9935,126,8255,1867,8878,7261,982,467,1919,3455,458,9299,1783,3750,8246,783,4863,1408,9378,3038,6341,8208,663,9583,7397,2411,3857,727,8361,9792,7095,4268,9628,5018,5963,2685,4531,7531,3502,5162,9532,5195,3501,1346,110,666,4731,1826,1259,4871,2313,7986,9727,124,1097,8677,2365,3296,7372,5633,8065,653,8619,5216,239,9925,2852,8221,1238,5520,6020,7643,6501,1127,1804,3604,9962,1481,1443,5817,2415,4395,2511,7318,51,333,945,7160,6413,2152,9560,7980,4680,5962,7712,8115,5478,9582,9621,6457,638,1161,6269,4589,7612,5580,7753,5856,3277,3372,1249,3081,7601,8229,6650,2740,4562,2200,730,8504,929,2152,5234,9041,4556,1843,9515,8499,2292,1248,6278,715,7981,8434,1969,9613,320,5263,5107,4200,3502,5319,3358,8285,6116,3128,4147,572,6370,5350,7304,363,9212,2627,7483,3142,3043,8837,2750,8951,9972,2946,5141,3373,5566,8835,2886,273,1658,8328,8479,1340,4903,4560,3139,3376,4653,4950,8355,7291,3799,34,6514,6576,3685,5538,5272,4445,9205,9900,1787,2207,1878,3674,11,8393,4870,190,105,9888,6108,7411,3204,3542,7413,6622,2229,9733,10000,701,8909,6550,2869,6928,8437,6087,9309,8810,7947,2953,2638,2430,9263,9601,3125,1703,6131,577,1554,786,2436,2967,3530,792,8779,5899,3913,9311,1172,699,8265,633,2260,7376,6185,584,8737,8870,7846,8881,317,5685,359,1319,8430,4236,3362,6758,1820,2983,5140,5769,7851,4590,3025,4496,4078,1670,4382,3319,6002,2884,6846,6644,2513,2107,7367,8489,1595,2294,5264,6444,6951,7578,1571,1148,7837,4063,1813,1876,6346,1306,7918,5271,6599,8498,6332,7246,8889,3618,3676,3401,7965,310,6469,7185,7167,2442,6666,9212,8410,6698,3128,4290,2275,4360,4888,5706,2146,2086,2321,6012,431,2460,4527,5160,7815,1973,8326,2702,6134,2522,1879,4958,4106,8374,7119,9994,8105,3631,5178,7571,2592,6747,3547,3670,265,1201,7330,2735,8475,5646,5478,1097,6439,6589,1618,9552,8925,5149,8451,9477,5234,8600,2524,3660,6452,658,3278,2735,4669,6496,8611,1093,9565,3558,7834,1467,7403,6151,5210,2045};
        Assert.assertEquals(18123938694L,Problems.findTheArrayConcVal(st));
    }

    @Test
    public void testMinimumAbsDifference(){
        int [] st = new int[]{4,2,1,3};
        Assert.assertEquals(673,Problems.minimumAbsDifference(st));
    }
    @Test
    public void testRotate(){
        int [] st = new int[]{1,2,3,4,5,6,7};
        int [] exp = new int[]{5,6,7,1,2,3,4};
        Assert.assertArrayEquals(exp,Problems.rotate(st,3));
    }

    @Test
    public void testRotate2(){
        int [] st = new int[]{-1};
        int [] exp = new int[]{-1};
        Assert.assertArrayEquals(exp,Problems.rotate(st,2));
    }
    @Test
    public void testRotate3(){
        int [] st = new int[]{1,2};
        int [] exp = new int[]{2,1};
        Assert.assertArrayEquals(exp,Problems.rotate(st,3));
    }

    @Test
    public void testIntersect(){
        int [] st = new int[]{1,2,2,1};
        int [] st2 = new int[]{2,2};
        int [] exp = new int[]{2,2};
        Assert.assertArrayEquals(exp,Problems.intersect(st,st2));
    }
    @Test
    public void testIntersect2(){
        int [] st = new int[]{4,9,5};
        int [] st2 = new int[]{9,4,9,8,4};
        int [] exp = new int[]{4,9};
        Assert.assertArrayEquals(exp,Problems.intersect(st,st2));
    }
    @Test
    public void testRemoveElement(){
        int [] st = new int[]{0,1,2,2,3,0,4,2};
        int [] exp = new int[]{2,1};
        Assert.assertEquals(5,Problems.removeElement(st,2));
    }
    @Test
    public void testMinSubArrayLen(){
        int [] st = new int[]{1,4,4};
        int [] exp = new int[]{2,1};
        Assert.assertEquals(1,Problems.minSubArrayLenSlidWin(4,st));
    }
    @Test
    public void testMinSubArrayLen2(){
        int [] st = new int[]{1,1,1,1,1,1,1,1};
        int [] exp = new int[]{2,1};
        Assert.assertEquals(0,Problems.minSubArrayLenSlidWin(11,st));
    }
    @Test
    public void testMinSubArrayLen3(){
        int [] st = new int[]{1,2,3,4,5};
        Assert.assertEquals(3,Problems.minSubArrayLenSlidWin(11,st));
    }
    @Test
    public void testMinSubArrayLen4(){
        int [] st = new int[]{1,2,3,4,5};
        Assert.assertEquals(5,Problems.minSubArrayLenSlidWin(15,st));
    }
    @Test
    public void testReverse(){
        int st = -2147483648;
        Assert.assertEquals(5,Problems.reverseMath(st));
    }

    @Test
    public void testCodelandUsernameValidation(){
        int st = -2147483648;
        Assert.assertEquals("true",Problems.codelandUsernameValidation("u__hello_world123"));
    }

    @Test
    public void testMaxDepth(){
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(19);
        int st = -2147483648;
        Assert.assertEquals("true",Problems.isUnivalTree(root));
    }
    @Test
    public void testIncreasingBST(){
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(19);
        int st = -2147483648;
        Assert.assertEquals("true",Problems.increasingBST(root));
    }

    @ParameterizedTest(name = "testMaximumLengthSubstring prov: {0} - expect: {1}")
    @CsvSource({
            "eebadadbfa, 9",
            "bcbbbcba, 4",
            "bcbc, 4"
    })
    public void testMaximumLengthSubstring(String s, int exp){
        Assert.assertEquals(exp, MaximumLengthSubstringWithTwoOccurrences.maximumLengthSubstring(s));
    }

    @Test
    public void testSumOfEncryptedInt(){
        int [] st = new int[]{1,2,3};
        Assert.assertEquals(6, FindTheSumOfEncryptedIntegers.sumOfEncryptedInt(st));
    }
    @ParameterizedTest(name = "decreasing number prov: {0} - expect: {1}")
    @CsvSource({
            "2718, 2",
            "4, 0",
            "19, 2"
    })
    public void testDecrNum(int num, int ex){
        Assert.assertEquals(ex, Problems.decrNum(num));
    }
    @Test
    public void testMinOperationsBinS(){
        int [] st = new int[]{2,11,10,1,3};
        Assert.assertEquals(3, Problems.minOperationsBinS(st,10));
    }
    @Test
    public void testMinOperationsBinS1(){
        int [] st = new int[]{1,1,2,4,9};
        Assert.assertEquals(4, Problems.minOperationsBinS(st,9));
    }

    @ParameterizedTest
    @ValueSource()
    public void testMinOperationsBinS2() {

        int[] st = new int[]{1, 1, 2, 4, 9};
        Assert.assertEquals(0, Problems.minOperationsBinS(st, 1));
    }

    @ParameterizedTest(name = "prov: {0} - expect: {1}")
    @CsvSource({
            "abcabc, 2",
            "cccc, 4",
            "19, 2"
    })
    public void testStringChallenge(String input, int expected) {

        int[] st = new int[]{1, 1, 2, 4, 9};
        Assert.assertEquals(expected, Problems.stringChallenge(input));
    }
//    apple = [1,3,2], capacity = [4,3,1,5,2]

    @ParameterizedTest(name = "prov: {0} - expect: {1}")
    @MethodSource("arraysProvider")
    public void testStringChallenge(int[] capacity,int[] apple, int expected) {

        int[] st = new int[]{1, 1, 2, 4, 9};
        Assert.assertEquals(expected, AppleRedistributionIntoBoxes.minimumBoxes(apple,capacity));
    }
}

