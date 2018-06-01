class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        int count = 0;
        if (root == null) return false;
        return helper(root, 0, sum);
    }
    public boolean helper(TreeNode root, int count, int sum) {
        
        if (root == null) return false;
            
        if (count + root.val == sum && root.left == null && root.right == null) return true;

        return helper(root.left, count+root.val, sum) || helper(root.right, count+root.val, sum);

    }
}