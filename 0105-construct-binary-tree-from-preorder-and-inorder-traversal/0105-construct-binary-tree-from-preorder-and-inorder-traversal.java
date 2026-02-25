class Solution {
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1, map);
    }

    private TreeNode helper(int[] preorder, int start, int end, HashMap<Integer, Integer> map) {
        if (start > end) {
            return null;
        } 
        
        int rootVal = preorder[index++];
        TreeNode root = new TreeNode(rootVal);
        int inorderIndex = map.get(rootVal);
        root.left = helper(preorder, start, inorderIndex - 1, map);
        root.right = helper(preorder, inorderIndex + 1, end, map);

        return root;
    }
}