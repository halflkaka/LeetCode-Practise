class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        bp(res, ans, 0, n, k, 1);
        return res;
    }
    public void bp(List<List<Integer>> res, List<Integer> ans, int cur, int n, int k, int start) {
        if (cur == n && ans.size() == k) {
            res.add(new ArrayList<>(ans));
            return;
        }
        if (ans.size() >= k) return;
        for (int i = start; i < 10; i++) {
            ans.add(i);
            bp(res, ans, cur+i, n, k, i+1);
            ans.remove(ans.size()-1);
        }
    }
}