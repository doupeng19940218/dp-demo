package org.example.leetcode.easy;

/**
 * @author walker.dou
 */
public class Class100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        return false;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
