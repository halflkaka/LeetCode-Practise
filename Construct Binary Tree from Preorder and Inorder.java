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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length-1, preorder, inorder);
    }
    public TreeNode helper(int PreStart, int InStart, int InEnd, int[] preorder, int[] inorder) {
        if (PreStart > preorder.length - 1 || InStart > InEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[PreStart]);
        int InIndex = 0;
        for (int i = InStart; i <= InEnd; i++) {
            if (inorder[i] == preorder[PreStart]) {
                InIndex = i;
                break;
            }
        }
        root.left = helper(PreStart+1, InStart, InIndex-1, preorder, inorder);
        root.right = helper(PreStart+InIndex-InStart+1, InIndex+1, InEnd, preorder, inorder);
        return root;
    }
}