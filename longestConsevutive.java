class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        if (nums.length == 0) return 0;
        
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                int left = map.getOrDefault(nums[i]-1, 0);
                int right = map.getOrDefault(nums[i]+1,0);
                int size = left + right + 1;
                if (size > ans) {
                    ans = size;
                }
                map.put(nums[i], size);
                map.put(nums[i]-left, size);
                map.put(nums[i]+right, size);
            }
        }
        
        return ans;
    }
}