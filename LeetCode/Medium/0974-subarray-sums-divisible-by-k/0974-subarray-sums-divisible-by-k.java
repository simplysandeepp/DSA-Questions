class Solution
{
    HashMap<Integer,Integer> map;
    public int subarraysDivByK(int[] nums, int k) 
    {
        map=new HashMap<>();
        map.put(0,1);
        int count=0;
        int currsum=0;
        for(int i=0;i<nums.length;i++)
        {
            currsum=currsum+nums[i];
            int rem=(currsum%k);
            if(rem<0)
            rem=((currsum%k)+k)%k;
            count+=map.getOrDefault(rem,0);
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return count;
    }

}