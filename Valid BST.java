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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        int[] nums = new int[list.size()];
        int j = 0;
        for (Integer n : list) {
            nums[j++] = (int)n;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i-1]) {
                return false;
            }
        }
        return true;
    }
    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root != null) {
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }
}