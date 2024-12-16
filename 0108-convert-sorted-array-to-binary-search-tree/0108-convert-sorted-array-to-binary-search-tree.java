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
    public TreeNode sortedArrayToBST(int[] nums) {
        return toBST(0, nums.length - 1, nums);
    }

    private TreeNode toBST(int first, int last, int[] nums) {
        if(first > last) return null;
        int mid = first + (last - first) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = toBST(first, mid - 1, nums);
        treeNode.right = toBST(mid + 1, last, nums);
        return treeNode;
    }
}