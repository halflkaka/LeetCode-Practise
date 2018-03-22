class Solution {
    public boolean canJump(int[] nums) {
        int maxPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxPos < i) return false;
            maxPos = maxPos < nums[i] + i? nums[i] + i : maxPos;
        }
        return true;
    }
}