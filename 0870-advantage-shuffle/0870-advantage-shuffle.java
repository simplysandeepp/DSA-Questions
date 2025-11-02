class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Arrays.sort(nums1);
        int[] ans = new int[n];
        boolean[] vis = new boolean[n];
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            int ub = upperBound(nums1, nums2[i]);
            if(ub!=n && vis[ub]==false){
                 ans[i] = nums1[ub];
                 vis[ub] = true;
            }
            else if(ub<n-1 && vis[ub]==true){
                while(ub<n && vis[ub]==true){
                    ub++;
                }
                if(ub==n){
                    arr.add(i);
                }
                else{
                     ans[i] = nums1[ub];
                     vis[ub]=true;
                }
            }
            else{
              arr.add(i);
            }
        }
        int j=0;
        for(int x: arr){
            while(j<n && vis[j]==true){
                j++;
            }
            ans[x]=nums1[j];
            vis[j]=true;
        }
        return ans;
    }
    public int upperBound(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]<=target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return low;
    }
}