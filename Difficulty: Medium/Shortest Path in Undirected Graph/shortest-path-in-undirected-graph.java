import java.util.*;

class Solution {
    public int[] shortestPath(int V, int[][] edges, int src) {
        
        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        // Add edges (undirected graph)
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        // Distance array
        int[] dist = new int[V];
        Arrays.fill(dist, -1);  // -1 means unreachable
        
        // BFS
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        dist[src] = 0;
        
        while(!q.isEmpty()){
            int node = q.poll();
            
            for(int neighbor : adj.get(node)){
                if(dist[neighbor] == -1){
                    dist[neighbor] = dist[node] + 1;
                    q.add(neighbor);
                }
            }
        }
        
        return dist;
    }
}
