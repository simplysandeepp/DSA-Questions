class Solution {

    static int[] parent;
    static int[] rank;
    static int component;

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static boolean union(int a, int b) {
        int p_a = find(a);
        int p_b = find(b);

        if (p_a == p_b) return false;

        if (rank[p_a] < rank[p_b]) {
            parent[p_a] = p_b;
        } else if (rank[p_a] > rank[p_b]) {
            parent[p_b] = p_a;
        } else {
            parent[p_b] = p_a;
            rank[p_a]++;
        }

        component--;   // decrease number of components
        return true;
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;

        parent = new int[n];
        rank = new int[n];
        component = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || 
                    stones[i][1] == stones[j][1]) {
                    union(i, j);
                }
            }
        }

        return n - component;
    }
}
