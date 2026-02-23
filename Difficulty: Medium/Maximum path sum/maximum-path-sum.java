class Solution {
    
    int maxPath;
    
    int findMaxSum(Node root) {
        maxPath = Integer.MIN_VALUE;
        helper(root);
        return maxPath;
    }
    
    int helper(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSum = Math.max(0, helper(root.left));
        int rightSum = Math.max(0, helper(root.right));

        // Path passing through current node
        int currentPath = root.data + leftSum + rightSum;
        maxPath = Math.max(maxPath, currentPath);

        // Return max single path
        return root.data + Math.max(leftSum, rightSum);
    }
}