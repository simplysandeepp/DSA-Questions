class Solution {
    static class SegmentTree{
        int n;
        int[] tree;
        public SegmentTree(int n){
            this.n=n;
            tree=new int[4*n];
        }

        public int query(int node,int leftR,int rightR,int querySt,int queryEnd){
            if(leftR> queryEnd || rightR<querySt){
                return 0;
            }
            if(querySt<=leftR && rightR<=queryEnd){
                return tree[node];
            }
            int mid=leftR+(rightR-leftR)/2;
            int leftChild=2*node+1;
            int rightChild=2*node+2;
            int left=query(leftChild,leftR,mid,querySt,queryEnd);
            int right=query(rightChild,mid+1,rightR,querySt,queryEnd);
            return left+right;
        }
        public void update(int node,int leftR,int rightR,int idx){
            if(leftR==rightR){
                tree[node]++;
                return;
            }
            int mid=leftR+(rightR-leftR)/2;
            int leftChild=2*node+1;
            int rightChild=2*node+2;
            if(idx<=mid){
                update(leftChild,leftR,mid,idx);
            }else{
                update(rightChild,mid+1,rightR,idx);
            }
            tree[node]=tree[leftChild]+tree[rightChild];
        }
    }
    public int reversePairs(int[] nums) {
        int n=nums.length;
        TreeSet<Long> set=new TreeSet<>();
        for(int i: nums){
            set.add(i*1L);
            set.add(i*2L);
        }
        List<Long> ans=new ArrayList<>(set);
        int idx=0;
        HashMap<Long,Integer> hm=new HashMap<>();
        for(int i=0;i<ans.size();i++){
            if(!hm.containsKey(ans.get(i))){
                hm.put(ans.get(i),idx++);
            }
        }
        SegmentTree seg=new SegmentTree(idx);
        int result=0;
        for(int j=0;j<n;j++){
            // Condition-- arr[i]=2*arr[j] 
            int value=hm.get((long)(nums[j]*2L));
            result+=seg.query(0,0,idx-1,value+1,idx-1);
            seg.update(0,0,idx-1,hm.get((long)nums[j]));

        }
        return result;
    }
}