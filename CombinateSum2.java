class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        List<Integer> ans = new ArrayList<Integer>();
        backpropagation(res, ans, candidates, 0, target);
        return res;
    }
    public void backpropagation(List<List<Integer>> res, List<Integer> ans, int[] candidates, int start, int remain) {
        if (remain < 0) return;
        if (remain == 0) {
            res.add(new ArrayList(ans));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // if (remain < candidates[i]) return;
            if (i > start && candidates[i] == candidates[i-1]) continue;
            ans.add(ans.size(), candidates[i]);
            backpropagation(res, ans, candidates, i+1, remain - candidates[i]);
            ans.remove(ans.size() - 1);
        }
    }
}

