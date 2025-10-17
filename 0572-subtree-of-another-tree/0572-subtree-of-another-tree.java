class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        root = match(root, subRoot);
        return root != null && check(root, subRoot);
    }

    public boolean check(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.val != subRoot.val) return false;
        return check(root.left, subRoot.left) && check(root.right, subRoot.right);
    }

    public TreeNode match(TreeNode root, TreeNode subRoot) {
        if (root == null) return null;
        if (check(root, subRoot)) return root;
        TreeNode l = match(root.left, subRoot);
        if (l != null) return l;
        TreeNode r = match(root.right, subRoot);
        return r;
    }
}