class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                ArrayList<Integer> component = new ArrayList<>();
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                visited[i] = true;
                while (!q.isEmpty()) {
                    int node = q.poll();
                    component.add(node);

                    for (int neigh : adj.get(node)) {
                        if (!visited[neigh]) {
                            visited[neigh] = true;
                            q.offer(neigh);
                        }
                    }
                }
                components.add(component);
            }
        }
        return components;
    }
}
