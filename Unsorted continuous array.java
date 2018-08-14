class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int i = 0, j = nums.length-1;
        while (i < j && nums[i] <= nums[i+1]) {
            i++;
        }
        if (i == j) return 0;
        while (nums[j] >= nums[j-1]) {
            j--;
        }
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            max = Math.max(max, nums[k]);
            min = Math.min(min, nums[k]);
        }
        while (j < nums.length && max > nums[j]) j++;
        while (i >= 0 && nums[i] > min) i--;
        return j-i-1;
    }
}