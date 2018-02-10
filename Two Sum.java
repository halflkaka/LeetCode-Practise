class Solution {
     public int[] twoSum(int[] nums, int target) {
        int[] flag = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            flag[i] = 1;
        }
        int k = 0;
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            flag[i] --;
            if (has(nums, flag, target - x)) {
                flag [i] ++;
                result[k++] = i;
            }
        }
        return result;
    }

    public boolean has(int[] nums, int[] flag, int num) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num && flag[i] != 0) {
                return true;
            }
        }
        return false;
    }

}