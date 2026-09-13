class Solution {

    private int[] bfs(ArrayList<ArrayList<Integer>> adj, int start) {
        int n = adj.size();
        int[] dist = new int[n];

        java.util.Arrays.fill(dist, -1);

        java.util.Queue<Integer> q = new java.util.LinkedList<>();
        q.add(start);
        dist[start] = 0;

        int farthest = start;

        while (!q.isEmpty()) {
            int u = q.poll();

            if (dist[u] > dist[farthest]) {
                farthest = u;
            }

            for (int v : adj.get(u)) {
                v--; // given nodes are 1-based

                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }
        }

        return new int[]{farthest, dist[farthest]};
    }

    public int partyHouse(ArrayList<ArrayList<Integer>> adj) {
        if (adj.size() == 1) return 0;

        // Find one end of diameter
        int[] first = bfs(adj, 0);
        int A = first[0];

        // Find diameter
        int[] second = bfs(adj, A);
        int diameter = second[1];

        // Radius of tree
        return (diameter + 1) / 2;
    }
}