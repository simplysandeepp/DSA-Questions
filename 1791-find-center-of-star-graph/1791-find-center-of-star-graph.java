class Solution {
    public int findCenter(int[][] edges) {
        int a = edges[0][0];
        int b = edges[0][1];
        int n = edges.length;
        int m = edges[0].length;

        for(int i=1;i<n;i++) {
            for(int j=0; j<m; j++) {
                if(edges[i][j] == a) {
                   return a;
                } 
                else if(edges[i][j] == b){
                    return b;
                }
            }
        }
        return 0; 
    }
}