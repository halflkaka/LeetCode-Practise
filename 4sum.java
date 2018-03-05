class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        if (nums.length == 0) return ans;
        
        for (int i = 0; i < nums.length - 3; i++) {
            while (i != 0 && i < nums.length - 3 && nums[i] == nums[i-1]) i++;
            for (int j = i + 1; j < nums.length - 2; j++) {
                while (j - 1 != i && j < nums.length - 2 && nums[j] == nums[j - 1]) j++;
                int lo = j + 1, lw = nums.length -1;
                while (lo < lw) {
                    if (nums[i] + nums[j] + nums[lo] + nums[lw] == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[lw]));
                        while (lo < lw && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < lw && nums[lw] == nums[lw - 1] ) lw--;
                        lo++;
                        lw--;
                    } else if (nums[i] + nums[j] + nums[lo] + nums[lw] < target) {
                        while (lo < lw && nums[lo] == nums[lo+1]) lo++;
                        lo++;
                    } else {
                        while (lo < lw && nums[lw] == nums[lw-1]) lw--;
                        lw--;
                    }
                }
            }
        }
        return ans;
    }
}