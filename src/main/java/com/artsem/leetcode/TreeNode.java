package com.artsem.leetcode;

public class TreeNode {
    int val;
    Problems.TreeNode left;
    Problems.TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, Problems.TreeNode left, Problems.TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
