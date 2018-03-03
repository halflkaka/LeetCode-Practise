class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int closestSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int lo = i + 1, lw = nums.length - 1;
            while (lo < lw) {
                if (Math.abs(nums[i] + nums[lo] + nums[lw] - target) == 0) return target;
                if (Math.abs(nums[i] + nums[lo] + nums[lw] - target) < diff) {
                    diff = Math.abs(nums[i] + nums[lo] + nums[lw] - target);
                    closestSum = nums[i] + nums[lo] + nums[lw];
                    if (nums[i] + nums[lo] + nums[lw] - target > 0) {
                        lw --;
                    } else {
                        lo ++;
                    }
                } else {
                    if (nums[i] + nums[lo] + nums[lw] - target > 0) {
                        lw --;
                    } else {
                        lo ++;
                    }
                }
            }
        }
        return closestSum;
    }
}