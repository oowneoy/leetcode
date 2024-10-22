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
    record Node(TreeNode root, int depth) {}

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int depth = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 1));
        
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            TreeNode treeNode = currentNode.root;
            depth = Math.max(currentNode.depth(), depth);
            
            if(treeNode.left != null) {
                queue.offer(new Node(treeNode.left, depth + 1));
            }
            if(treeNode.right != null) {
                queue.offer(new Node(treeNode.right, depth + 1));
            }
        }

        return depth;
    }
}