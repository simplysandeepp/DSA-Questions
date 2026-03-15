class Solution {
    public int longestArithmetic(int[] v) {
        int n = v.length;
        int[] dpl = new int[n];
        int[] dpr = new int[n];
        Arrays.fill(dpl,2);
        Arrays.fill(dpr,2);

        int ans = 2;
        dpl[0] = 1;

        for(int i=2;i<n;i++){
            if(v[i]-v[i-1] == v[i-1]-v[i-2])
                dpl[i] = dpl[i-1] + 1;
            else
                dpl[i] = 2;
        }

        dpr[n-1] = 1;

        for(int i=n-3;i>=0;i--){
            if(v[i+1]-v[i] == v[i+2]-v[i+1])
                dpr[i] = dpr[i+1] + 1;
            else
                dpr[i] = 2;
        }

        for(int i=0;i<n;i++){

            if(i>0) ans = Math.max(ans , dpl[i-1] + 1);
            if(i+1<n) ans = Math.max(ans , dpr[i+1] + 1);

            if(i>0 && i+1<n){
                int diff = v[i+1] - v[i-1];

                if(diff % 2 != 0) continue;

                int len = 1;

                if(i-2>=0 && v[i-1]-v[i-2] == diff/2)
                    len += dpl[i-1];
                else
                    len += 1;

                if(i+2<n && v[i+2]-v[i+1] == diff/2)
                    len += dpr[i+1];
                else
                    len += 1;

                ans = Math.max(ans , len);
            }
        }

        return ans;
    }
}