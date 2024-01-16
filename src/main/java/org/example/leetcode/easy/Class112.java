package org.example.leetcode.easy;

import java.util.HashMap;

/**
 * @author walker.dou
 */
public class Class112 {

    public boolean hasPathSum(TreeNode node, int targetSum) {
        final HashMap<TreeNode, TreeNode> relationMap = new HashMap<>();
        if (node == null) {
            return false;
        }
        return handle(node, relationMap, targetSum);
    }

    private boolean handle(TreeNode node, HashMap<TreeNode, TreeNode> relationMap, int targetSum) {
        if (node.left == null && node.right == null){
            int sum = node.val;
            while (relationMap.containsKey(node)) {
                final TreeNode treeNode = relationMap.get(node);
                sum += treeNode.val;
                node = treeNode;
            }
            return sum == targetSum;
        }

        if (node.left != null && node.right != null) {
            relationMap.put(node.left, node);
            relationMap.put(node.right, node);
            return handle(node.left, relationMap, targetSum) || handle(node.right, relationMap, targetSum);
        }
        if (node.left != null && node.right == null) {
            relationMap.put(node.left, node);
            return handle(node.left, relationMap, targetSum);
        }
        if (node.left == null && node.right != null) {
            relationMap.put(node.right, node);
            return handle(node.right, relationMap, targetSum);
        }
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


    public boolean hasPathSum2(TreeNode root, int targetSum) {
        return dfs(root,0,targetSum);
    }

    public boolean dfs(TreeNode node,int sum,int target){
        if (node==null) return false;
        sum += node.val;
        if (node.left==null && node.right==null){
            if (sum==target){
                return true;
            }
        }
        boolean bl = dfs(node.left,sum,target);
        boolean rl = dfs(node.right,sum,target);
        sum -= node.val;
        return bl||rl;
    }

}

