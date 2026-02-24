class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode leftmost = null;

        while (!q.isEmpty()) {
            leftmost = q.poll();

            if (leftmost.right != null) {
                q.offer(leftmost.right);
            }
            if (leftmost.left != null) {
                q.offer(leftmost.left);
            }
        }

        return leftmost.val;
    }
}