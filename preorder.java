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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        while (root != null) {
            res.add(root.val);
            if (root.right != null) {
                s.push(root.right);
            }
            root = root.left;
            if (root == null && !s.isEmpty()) {
                root = s.pop();
            }
        }
        return res;
    }

}