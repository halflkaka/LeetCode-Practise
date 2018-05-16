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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();
        if (root == null) return res;
        nodes.add(root);
        helper(res, nodes);
        Collections.reverse(res);
        return res;
    }
    public void helper(List<List<Integer>> res, List<TreeNode> nodes) {
        if (nodes.size() == 0) return;
        List<Integer> cur = new ArrayList<>();
        List<TreeNode> newnodes = new ArrayList<>();
        for (TreeNode node:nodes) {
            cur.add(node.val);
            if (node.left != null) {
                newnodes.add(node.left);
            }
            if (node.right != null) {
                newnodes.add(node.right);
            }
        }
        res.add(cur);
        helper(res,newnodes);
    }
}