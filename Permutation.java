class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutation = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        helper(permutation, set, nums);
        return permutation;
    }
    public void helper(List<List<Integer>> permutation, List<Integer> set, int[] nums) {
        if (set.size() == nums.length) {
            permutation.add(new ArrayList(set));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);
            helper(permutation, set, nums);
            set.remove(set.size()-1);
        }
    }
}