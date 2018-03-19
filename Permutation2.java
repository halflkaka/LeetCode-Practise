class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] flag = new int[nums.length];
        Arrays.sort(nums);
        helper(res, new ArrayList<Integer>(), flag, nums);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> set, int[] flag, int[] nums) {
        if (set.size() == nums.length && !res.contains(set)) {
            res.add(new ArrayList(set));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (flag[i] == 0) {
                    if (i>0 && nums[i-1] == nums[i] && flag[i-1] == 0) continue;
                    flag[i] = 1;
                    set.add(nums[i]);
                    helper(res, set, flag, nums);
                    flag[i] = 0;
                    set.remove(set.size()-1);
                }   
            }
        }
    }
}