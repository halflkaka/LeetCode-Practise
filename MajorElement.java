class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);

        if (nums.length == 0) return ans;
        if (nums.length == 1) {
            ans.add(nums[0]);
            return ans;
        }
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            while (i < nums.length - 1 && nums[i] == nums[i+1]) {
                i++;
                count ++;
            }
            if (count > nums.length / 3) {
                ans.add(nums[i]);
            }
        }
        return ans;
        
    }
}