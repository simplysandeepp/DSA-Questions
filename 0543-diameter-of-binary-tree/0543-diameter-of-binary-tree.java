class Solution {
    static int maxi;

    public int diameterOfBinaryTree(TreeNode root) {
        maxi = 0;
        if (root == null) {
            return 0;
        }
        height(root);
        return maxi;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);
        maxi = Math.max(maxi, lh + rh);
        return Math.max(lh, rh) + 1;
    }
}