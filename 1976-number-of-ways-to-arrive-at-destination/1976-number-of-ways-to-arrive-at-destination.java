import java.util.*;

class Solution {
    static class Pair {
        int city;
        long time;

        Pair(int city, long time) {
            this.city = city;
            this.time = time;
        }
    }

    public int countPaths(int n, int[][] roads) {
        int MOD = (int) 1e9 + 7; 

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int time = road[2];
            graph.get(u).add(new Pair(v, time));
            graph.get(v).add(new Pair(u, time)); 
        }

        long[] minTime = new long[n];
        int[] ways = new int[n];
        Arrays.fill(minTime, Long.MAX_VALUE); 

        minTime[0] = 0;
        ways[0] = 1; 
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.time, b.time));
        pq.offer(new Pair(0, 0)); 

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.city;
            long currentTime = current.time;

            if (currentTime > minTime[u]) {
                continue;
            }
            for (Pair neighbor : graph.get(u)) {
                int v = neighbor.city;
                long travelDuration = neighbor.time;
                long newTime = currentTime + travelDuration;

                if (newTime < minTime[v]) {
                    minTime[v] = newTime;
                    ways[v] = ways[u];
                    pq.offer(new Pair(v, newTime));
                } else if (newTime == minTime[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD; 
                }
            }
        }
        return ways[n-1];
    }
}