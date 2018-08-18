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
    public int countNodes(TreeNode root) {
        int lf = lefth(root);
        int rg = righth(root);
        if (lf == rg) return (1 << lf) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    public int lefth(TreeNode root) {
        int dp = 0;
        while (root != null) {
            root = root.left;
            dp++;
        }
        return dp;
    }
    public int righth(TreeNode root) {
        int dp = 0;
        while (root != null) {
            root = root.right;
            dp++;
        }
        return dp;
    }
}