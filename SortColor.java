class Solution {
    public void sortColors(int[] nums) {
        int lo = 0, lw = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] == 2 && i < lw) swap(nums[i], nums[lw--]);
            while (nums[i] == 0 && i > lo) swap(nums[i], nums[lo++]);
        }
    }
}