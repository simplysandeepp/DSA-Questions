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
    private int cameras = 0;
    public int minCameraCover(TreeNode root) {
        return helper(root) == -1 ? cameras + 1 : cameras;
    }
    private int helper(TreeNode root) {
        if (root==null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if (left == -1 || right == -1) {
            cameras++;
            return 1; 
        }
        if (left == 1 || right == 1)
            return 0; 
        return -1;
    }
}