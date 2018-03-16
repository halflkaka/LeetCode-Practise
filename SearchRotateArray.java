class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, lw = nums.length - 1;
        while (lo <= lw) {
            int mid = (lo + lw) / 2;
            if (target == nums[mid]) return mid;
            if (nums[lo] <= nums[mid]) {
                if (target >= nums[lo] && target < nums[mid]) {
                    lw = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } 
            if (nums[mid] <= nums[lw]) {
                if (target > nums[mid] && target <= nums[lw]) {
                    lo = mid + 1;
                } else {
                    lw = mid - 1;
                }
            }
        }
        return -1;
    }
}