import java.util.*;

class Solution {

    public void DFSUtil(int curr, List<List<Integer>> adj,
                        boolean vis[], List<Integer> ans) {

        vis[curr] = true;
        ans.add(curr);

        for (int neighbour : adj.get(curr)) {
            if (!vis[neighbour]) {
                DFSUtil(neighbour, adj, vis, ans);
            }
        }
    }

    public List<Integer> dfsOfGraph(int V, List<List<Integer>> edges) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean vis[] = new boolean[V];
        List<Integer> ans = new ArrayList<>();

        DFSUtil(0, adj, vis, ans);

        return ans;
    }

    public List<Integer> bfsOfGraph(int V, List<List<Integer>> edges) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean vis[] = new boolean[V];
        List<Integer> ans = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()) {

            int curr = q.remove();
            ans.add(curr);

            for (int neighbour : adj.get(curr)) {

                if (!vis[neighbour]) {
                    vis[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }

        return ans;
    }
}
