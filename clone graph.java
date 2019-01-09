/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    Map<Integer, UndirectedGraphNode> map = new HashMap<>();
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        if (map.containsKey(node.label)) return map.get(node.label);
        
        UndirectedGraphNode ans = new UndirectedGraphNode(node.label);
        map.put(node.label, ans);
        
        for (UndirectedGraphNode n : node.neighbors) {
            ans.neighbors.add(cloneGraph(n));
        }

        return ans;
    }
}