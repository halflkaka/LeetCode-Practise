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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int max = height(root.left) + height(root.right);
        return Math.max(max, Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }
    public int height(TreeNode root) {
        if (root != null) {
            return (1 + Math.max(height(root.left),height(root.right)));
        } else {
            return 0;
        }
    }
}