class Result {

    /*
     * Complete the 'maxShared' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts WEIGHTED_INTEGER_GRAPH friends as parameter.
     */

    /*
     * For the weighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i]. The weight of the edge is <name>Weight[i].
     *
     */
    private int[][] edge;
    private int maxEdge = 0;
    private int maxShare = 0;

    public static int maxShared(int friendsNodes, List<Integer> friendsFrom, List<Integer> friendsTo, List<Integer> friendsWeight) {
        if (friendsNodes == 0) return 0;

        edge = new int[friendsNodes+1][friendsNodes+1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < friendsFrom.size(); i++) {
            int from = friendsFrom.get(i), to = friendsTo.get(i), w = friendsWeight.get(i);
            List<Integer> cur = map.getOrDefault(w, new ArrayList<Integer>());
            if (cur.size() == 0) {
                cur.add(from);
                cur.add(to);
                map.put(w, cur);
                updateEdge(from, to);
                continue;
            }
            if (!cur.contains(from)) {
                for (int j = 0; j < cur.size(); j++) {
                    int node = cur.get(j);
                    updateEdge(from, node);
                }
                cur.add(from);
            }
            if (!cur.contains(to)) {
                for (int j = 0; j < cur.size(); j++) {
                    int node = cur.get(j);
                    updateEdge(node, to);
                }
                cur.add(to);
            }
            map.put(w, cur);
        }
        return maxShare;
    }

    public static void updateEdge(int from , int to) {
        edge[from][to] ++;
        edge[to][from] ++;
        if (edge[from][to] >= maxEdge) {
            maxEdge = edge[from][to];
            if (from * to > maxShare) {
                maxShare = from * to;
            }
        }
    }

}


