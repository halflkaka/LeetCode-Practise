class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(helper(nums, 0, nums.length-2), helper(nums, 1, nums.length-1));
    }
    public int helper(int[] nums, int lo, int hi) {
        int pre2 = 0,pre = 0, cur = 0;
        for (int i = lo; i <= hi; i++) {
            cur = Math.max(pre2 + nums[i], pre);
            pre2 = pre;
            pre = cur;
        }
        return cur;
    }
}