class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        int lo = 0, lw = nums.length - 1;
        while (lo < lw) {
            int mid = (lo + lw) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] == nums[lo] && nums[mid] == nums[lw]) {
                lo++;
                lw--;
            } else if (nums[mid] >= nums[lo]) {
                if (nums[lo] <= target && nums[mid] > target) {
                    lw = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else if (nums[mid] <= nums[lw]) {
                if (nums[mid] < target && target <= nums[lw]) {
                    lo = mid + 1;
                } else {
                    lw = mid - 1;
                }
            }
        }
        return nums[lo] == target;
    }
}