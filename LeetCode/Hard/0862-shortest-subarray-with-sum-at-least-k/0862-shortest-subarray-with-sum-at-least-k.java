class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n=nums.length;
        if(n==1){
            if(nums[0]>=k){
                return 1;
            }
            else{
                return -1;
            }
        }
        long[] psum=new long[n+1];
        for(int i=0;i<n;i++){
            psum[i+1]=psum[i]+nums[i];
        }
        int minLength=Integer.MAX_VALUE;
        int[] q=new int[n+1];
        int l=0,r=0;
        for(int i=0;i<=n;i++){
            while(r>l && psum[i]-psum[q[l]]>=k){
                minLength=Math.min(minLength,i-q[l++]);
            }
            while(r>l && psum[i]<=psum[q[r-1]]){
                r--;
            }
            q[r++]=i;
        }
        return minLength>n?-1:minLength;
    }
}