class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        helper(res, ans, candidates, 0, target);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> ans, int[] candidates, int start, int target) {
        if (target < 0) return;
        else if (target == 0) {
            res.add(new ArrayList(ans));
        } else {
            for (int i = start; i < candidates.length; i++) {
                ans.add(candidates[i]);
                helper(res, ans, candidates, i, target - candidates[i]);
                ans.remove(ans.size() - 1);
            }
        }
    }
}