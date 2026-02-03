class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust.length ==0 && n==1) return n;
        int indeg[] = new int[n+1];
        for(int i=0; i<trust.length; i++) {
            indeg[trust[i][1]]++;
            indeg[trust[i][0]]--;
        }

        for(int i=0;i <n+1; i++) {
            if(indeg[i] ==n-1) return i;
        }
        return -1;
    }
}



