class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        return helper(root, 1);
    }
    public int helper(TreeNode root, int depth) {
        if (root != null && root.left == null && root.right == null) return depth;

        if (root.left != null && root.right != null) {
            return Math.min(helper(root.left, depth+1), helper(root.right, depth+1));
        } else if (root.left != null) {
            return helper(root.left, depth+1);
        } else if (root.right != null) {
            return helper(root.right, depth+1);
        } else {
            return depth;
        }
    }
}