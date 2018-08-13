class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums.length == 0) return ans;
        if (nums.length == 1) {
            ans.add(String.valueOf(nums[0]));
            return ans;
        }
        
        for (int i = 0; i < nums.length; i++) {
            StringBuilder cur = new StringBuilder("");
            int j = i;
            if (i < nums.length - 1 && nums[i] + 1 == nums[i+1]) {
                cur.append(String.valueOf(nums[i]) + "->");
                j = i + 1;
                while (j < nums.length - 1 && nums[j] + 1 == nums[j+1]) {
                    j++;
                }
                cur.append(String.valueOf(nums[j]));
            } else {
                cur.append(String.valueOf(nums[i]));
            }
            ans.add(cur.toString());
            i = j;
        }
        return ans;
    }
}