class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new ArrayList<>();   
        List<Integer> leaf2 = new ArrayList<>();   
        getLeaf(root1, leaf1);  
        getLeaf(root2, leaf2);  
        return leaf1.equals(leaf2); 
    }

    public void getLeaf(TreeNode root, List<Integer> leaf) {
        if (root == null) return;                 
        if (root.left == null && root.right == null) {
            leaf.add(root.val);                   
        }
        getLeaf(root.left, leaf);  
        getLeaf(root.right, leaf);  
    }
}