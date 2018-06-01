class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        
        TreeNode left = root.left;
        TreeNode right = root.right;

        flatten(root.left);
        flatten(root.right);

        root.right = root.left;
        root.left = null;

        TreeNode cur = root;
        while (cur.right != null) cur = cur.right;
        cur.right = right;
    }
}