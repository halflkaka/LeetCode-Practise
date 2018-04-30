/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();
        if (root == null) return res;
        nodes.add(root);
        helper(res, nodes);
        return res;
    }
    public void helper(List<List<Integer>> res, List<TreeNode> nodes) {
        if (nodes.size() == 0) return;
        List<TreeNode> nextNodes = new ArrayList<>();
        List<Integer> curVals = new ArrayList<>();
        for (TreeNode node:nodes) {
            if (res.size() % 2 == 0) {
                curVals.add(node.val);
            } else {
                curVals.add(0,node.val);
            }
            if (node.left != null) {
                nextNodes.add(node.left);
            }
            if (node.right != null) {
                nextNodes.add(node.right);
            }
        }
        res.add(curVals);
        helper(res,nextNodes);
    }
}