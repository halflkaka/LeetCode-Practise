class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        bp(ans, new ArrayList<Integer>(), nums, 0);
        return ans;
    }
    public void bp(List<List<Integer>> ans, List<Integer> res, int[] nums, int start) {
        if (!ans.contains(new ArrayList<Integer>(res))) {
            ans.add(new ArrayList<Integer>(res));
        }
        for (int i = start; i < nums.length; i++) {
            res.add(nums[i]);
            bp(ans, res, nums, i+1);
            res.remove(res.size()-1);
        }
    }
}