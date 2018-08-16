class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                int lf = mid, rg = mid;
                while (lf >= 0 && nums[lf] == target) {
                    lf--;
                }
                while (rg < nums.length && nums[rg] == target) {
                    rg++;
                }
                ans[0] = lf+1;
                ans[1] = rg-1;
                return ans;
            }
        }
        return ans;
    }
}