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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        while (!s.isEmpty() || root != null) {
            if (root != null) {
                s.push(root);
                res.addFirst(root.val);
                root = root.right;
            } else {
                TreeNode top = s.pop();
                root = top.left;
            }
        }
        return res;
    }
}