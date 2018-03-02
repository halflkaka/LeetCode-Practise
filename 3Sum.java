class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> set = new LinkedList<>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int lo = i + 1, lw = nums.length - 1, sum = 0 - nums[i];
                while (lo < lw) {
                    if (nums[lo] + nums[lw] == sum) {
                        set.add(Arrays.asList(nums[i], nums[lo], nums[lw]));
                        while (lo < lw && nums[lo] == nums[lo+1]) lo++;
                        while (lo < lw && nums[lw] == nums[lw-1]) lw--;
                        lo++;
                        lw--;
                    } else if (nums[lo] + nums[lw] < sum) {
                        while (lo < lw && nums[lo] == nums[lo+1]) lo++;
                        lo++;
                    } else {
                        while (lo < lw && nums[lw] == nums[lw-1]) lw--;
                        lw--;
                    }
                }
            }
        }
        
        return set;
    }
}

