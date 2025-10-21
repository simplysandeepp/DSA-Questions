class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        int tot=0;
        if(root==null){
            return 0;
        }
        HashMap<Long, Integer>map = new HashMap<>();
        map.put(0L,1);

        return helper(root,targetSum,0L,map);
    }

    public int helper(TreeNode root, int tar, long sum, HashMap<Long, Integer>map){
        if(root==null){
            return 0;
        }
        int ans=0;
        sum+=root.val;
        if(map.containsKey(sum-tar)){
            ans+=map.get(sum-tar);
        }
        map.put(sum,map.getOrDefault(sum,0)+1);
        ans+= helper(root.left,tar,sum,map);
        ans+= helper(root.right,tar,sum,map);
        map.put(sum,map.get(sum)-1);
        return ans;
        
    }
}