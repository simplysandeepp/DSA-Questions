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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if(root == null) return res;
        Queue<TreeNode> Q = new LinkedList<>();

        Q.offer(root);
        while(!Q.isEmpty()){
            int size = Q.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode np = Q.remove();
                if(i == size-1){
                   res.add(np.val);
                    
                }
                if(np.left != null){
                    Q.offer(np.left);
                }
                if(np.right != null){
                    Q.offer(np.right);
                }
            }
        
        }
        return res;
        
    }
}