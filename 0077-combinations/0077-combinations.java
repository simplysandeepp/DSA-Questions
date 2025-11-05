class Solution {
    int K, N;

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] visited = new int[n + 1]; 
        K = k;
        N = n;
        solve(ans, 1, new ArrayList<>(), visited);
        return ans;
    }

    public void solve(List<List<Integer>> ans, int st, List<Integer> res, int[] visited) {
        if (res.size() == K) {
            ans.add(new ArrayList<>(res));
            return; 
        }

        for (int i = st; i <= N; i++) {
            if (visited[i] == 1) continue;

            res.add(i);
            visited[i] = 1;

            solve(ans, i + 1, res, visited); 

            res.remove(res.size() - 1);
            visited[i] = 0;
        }
    }
}