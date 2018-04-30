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
    public boolean isSymmetric(TreeNode root) {
        return (root == null || helper(root.left, root.right));
    }
    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if ((left != null && right ==null) || (left == null && right != null)) return false;
        else {
            if (left.val != right.val) return false;
            else {
                return (helper(left.right, right.left) && helper(left.left, right.right));
            }
        }
    }
}