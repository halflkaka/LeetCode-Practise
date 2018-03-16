class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return;
        int diff = Integer.MAX_VALUE;
        int flag = 0;
        int ls = 0, lw = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                ls = i;
                flag = 1;
                break;
            }
        }
        for (int i = ls + 1; i < nums.length; i++) {
            if (nums[i] > nums[ls] && nums[i] - nums[ls] <= diff) {
                diff = nums[i] - nums[ls];
                lw = i;
            }
        }
        if (flag == 0) {
            Arrays.sort(nums);
        } else {
            int cur = nums[ls];
            nums[ls] = nums[lw];
            nums[lw] = cur;
            int i = ls + 1, j = nums.length - 1;
            while (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        return;
    }
}