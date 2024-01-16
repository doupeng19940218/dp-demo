package org.example.leetcode.easy;

/**
 * @author walker.dou
 */
public class Class101 {
    public static void main(String[] args) {


    }


    /**
     * 输入：root = [1,2,2,3,4,4,3]
     * 输出：true
     * [1,2,2,null,3,null,3]
     */
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val == right.val) {
            return compare(left.left, right.right) && compare(right.left, left.right);
        } else {
            return false;
        }
    }
}

class TreeNode {
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