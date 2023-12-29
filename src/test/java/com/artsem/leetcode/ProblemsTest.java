package com.artsem.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProblemsTest {

    TreeNode treeNode = new TreeNode(1);
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
}
