class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        helper(root, res, ans, 0, sum);
        return res;
    }
    public void helper(TreeNode root, List<List<Integer>> res, List<Integer> ans, int count, int sum) {
        if (root == null) return;
        
        ans.add(root.val);

        if (count + root.val == sum && root.left == null && root.right == null) {
            res.add(new ArrayList(ans));
            ans.remove(ans.size()-1);
            return;
        }

        helper(root.left, res, ans, count+root.val, sum);
        helper(root.right, res, ans, count+root.val, sum);

        ans.remove(ans.size() - 1);
    }
}