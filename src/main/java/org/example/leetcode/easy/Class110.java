package org.example.leetcode.easy;

/**
 * @author walker.dou
 */
public class Class110 {
    public boolean isBalanced(TreeNode root) {
        return isBalancedInner(root, 0).balanced;
    }

    private TreeNodeModel isBalancedInner(TreeNode root, int currDepth) {
        if (root == null) {
            return new TreeNodeModel(currDepth, true);
        }
        int thisDepth = currDepth + 1;
        final TreeNodeModel leftBalancedInner = isBalancedInner(root.left, thisDepth);
        final TreeNodeModel rightBalancedInner = isBalancedInner(root.right, thisDepth);
        boolean isBalanced = leftBalancedInner.balanced && rightBalancedInner.balanced && Math.abs(leftBalancedInner.depth - rightBalancedInner.depth) <= 1;
        return new TreeNodeModel(Math.max(leftBalancedInner.depth, rightBalancedInner.depth), isBalanced);
    }


    public static class TreeNodeModel {
        int depth;
        boolean balanced;

        public TreeNodeModel(int depth, boolean balanced) {
            this.depth = depth;
            this.balanced = balanced;
        }
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
