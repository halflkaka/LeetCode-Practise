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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        return helper(0, inorder.length-1, 0, postorder.length-1, inorder, postorder);
    }
    public TreeNode helper(int inStart, int inEnd, int postStart, int postEnd, int[] inorder, int[] postorder) {
        if (inStart > inEnd || postStart > postEnd) return null;
        int index = 0;
        TreeNode root = new TreeNode(postorder[postEnd]);
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        
        root.left = helper(inStart, index-1, postStart, postStart+index-inStart-1, inorder, postorder);
        root.right = helper(index+1, inEnd, postEnd-inEnd+index, postEnd-1, inorder, postorder);
        return root;
        
    }
}