class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[1001];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] edge: edges) {
            int s = edge[0], e = edge[1];
            if (find(parent, s) == find(parent, e)) return edge;
            else {
                parent[find(parent, s)] = find(parent, e);
            }
        }
        return new int[2];
    }
    public int find (int[] parent, int child) {
        while (parent[child] != child) {
            child = parent[child];
        }
        return child;
    }
}