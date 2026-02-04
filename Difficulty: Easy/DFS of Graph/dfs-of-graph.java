class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> ans = new ArrayList<>();
        dfsHelper(0, adj, visited, ans);
        return ans;
    }

    private void dfsHelper(int node, ArrayList<ArrayList<Integer>> adj,
                           boolean[] visited, ArrayList<Integer> ans) {
        visited[node] = true;
        ans.add(node);

        for (int neigh : adj.get(node)) {
            if (!visited[neigh]) {
                dfsHelper(neigh, adj, visited, ans);
            }
        }
    }
}
