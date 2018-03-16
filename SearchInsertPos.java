class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0, lw = nums.length - 1;
        while (lo <= lw) {
            int mid = (lo + lw) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) {
                lw = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}