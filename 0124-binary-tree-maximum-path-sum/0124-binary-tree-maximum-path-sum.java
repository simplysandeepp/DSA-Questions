import java.util.*;

class Solution {
    int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxPath;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = Math.max(0, helper(root.left));
        int rightSum = Math.max(0, helper(root.right));

        maxPath = Math.max(maxPath, root.val + leftSum + rightSum);

        return root.val + Math.max(leftSum, rightSum);
    }
}