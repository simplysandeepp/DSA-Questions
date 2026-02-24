class Solution {
    class tuple{
        int row;
        int col;
        TreeNode data;
        tuple(int row,int col,TreeNode data){
            this.row=row;
            this.col=col;
            this.data=data;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<tuple> q=new LinkedList<>();
        q.offer(new tuple(0,0,root));
        while(!q.isEmpty()){
            tuple curr=q.poll();
            int r=curr.row;
            int c=curr.col;
            TreeNode node=curr.data;
            map.putIfAbsent(c,new TreeMap<>());
            map.get(c).putIfAbsent(r,new PriorityQueue<>());
            map.get(c).get(r).add(node.val);
            if(node.left!=null){
                q.offer(new tuple(r+1,c-1,node.left));
            }
            if(node.right!=null){
                q.offer(new tuple(r+1,c+1,node.right));
            }
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> rows:map.values()){
            List<Integer> result=new ArrayList<>();
            for(PriorityQueue<Integer> pq:rows.values()){
                while(!pq.isEmpty()){
                    result.add(pq.poll());
                }
            }
            ans.add(result);
        }
        return ans;
    }
}