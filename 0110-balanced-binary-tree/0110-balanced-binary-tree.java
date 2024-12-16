/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return counting(root) != -1;
    }

    private int counting(TreeNode node) {
        if(node == null) return 0;
        
        int leftCount = counting(node.left);
        if(leftCount == -1) return -1;
        int rightCount = counting(node.right);
        if(rightCount == -1) return -1;

        if(Math.abs(leftCount - rightCount) > 1) return -1;
        return Math.max(leftCount, rightCount) + 1;
    }
}