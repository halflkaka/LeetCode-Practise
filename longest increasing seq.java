class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;;
        int[] dp = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j]+1 > dp[i]) {
                        dp[i] = dp[j]+1;
                    }
                }
            }
        }
        
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}