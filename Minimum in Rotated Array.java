class Solution {
    public int findMin(int[] nums) {
        int lf = 0, rg = nums.length-1, mid = 0;
        while (lf < rg) {
            mid = (lf + rg) / 2;
            if (nums[lf] > nums[mid] && nums[rg] > nums[mid]) {
                rg = mid;
            } else if (nums[lf] < nums[mid] && nums[rg] < nums[mid]) {
                lf = mid;
            } else if (nums[lf] < nums[mid] && nums[mid] < nums[rg]) {
                return nums[0];
            } else if (mid == lf || mid == rg) {
                return Math.min(nums[lf], nums[rg]);
            }
        }
        return nums[mid];
        
    }
}