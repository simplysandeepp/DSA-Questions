import java.util.*;

class Solution {
    static class Edge {
        String src;
        double wt;
        String dest;

        public Edge(String src, double wt, String dest) {
            this.src = src;
            this.wt = wt;
            this.dest = dest;
        }
    }

    Map<String, Integer> map; 

    public double[] findPath(String src, String dest, ArrayList<Edge> graph[], double ans, double t[], Set<String> visited) {
        if (src.equals(dest)) {
            t[0] = 1.0;
            t[1] = ans;
            return t; 
        }

        visited.add(src);

        for (Edge e : graph[map.get(src)]) {
            if (!visited.contains(e.dest)) {
                double[] temp = findPath(e.dest, dest, graph, ans * e.wt, t, visited);
                if (temp[0] == 1.0) {
                    return temp;
                }
            }
        }

        t[0] = 0.0;
        t[1] = -1.0;
        return t; 
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double res[] = new double[queries.size()];
        Set<String> set = new HashSet<>();
        for (List<String> list : equations) {
            set.add(list.get(0));
            set.add(list.get(1));
        }


        map = new HashMap<>();
        int idx = 0;
        for (String s : set) {
            map.put(s, idx++);
        }

        ArrayList<Edge> graph[] = new ArrayList[set.size()];
        for (int i = 0; i < set.size(); i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> list = equations.get(i);
            String s = list.get(0);
            String d = list.get(1);
            double val = values[i];
            graph[map.get(s)].add(new Edge(s, val, d));
            graph[map.get(d)].add(new Edge(d, 1 / val, s)); 
        }


        for (int j = 0; j < queries.size(); j++) {
            String src = queries.get(j).get(0);
            String dest = queries.get(j).get(1);

            if (!set.contains(src) || !set.contains(dest)) {
                res[j] = -1.0;
            } else {
                double t[] = new double[2];
                Set<String> visited = new HashSet<>();
                double[] ans = findPath(src, dest, graph, 1.0, t, visited);
                if (ans[0] == 1.0) {
                    res[j] = ans[1];
                } else {
                    res[j] = -1.0;
                }
            }
        }

        return res;
    }
}
