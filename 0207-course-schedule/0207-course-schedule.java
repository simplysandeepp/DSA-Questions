class Solution {
    public boolean canFinish(int V, int[][] edges) {
        // code here
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for( int i=0; i<V; i++) {
            adj.add(new ArrayList<>());
        }
        
        int [] inDeg = new int[V];
        
        for(int[] edge : edges) {
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            inDeg[v]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<V; i++) {
            if(inDeg[i] == 0) {
                q.offer(i);
            }
        }
        
        ArrayList<Integer> newList = new ArrayList<>();
        while(!q.isEmpty()) {
            int node = q.poll();
            newList.add(node);
            
            for(int neigh : adj.get(node)) {
                inDeg[neigh]--;
                
                if(inDeg[neigh] == 0) {
                    q.offer(neigh);
                }
            }
        }
        if(newList.size() == V) {
            return true;
        } else {
            return false;
        }
        
    }
}