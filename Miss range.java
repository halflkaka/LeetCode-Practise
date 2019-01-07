class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        int next = lower;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < next) continue;
            if (nums[i] == next) {
                if (next == Integer.MAX_VALUE) return ans;
                next ++;
                continue;
            }
            ans.add(getRange(next, nums[i]-1));
            if (nums[i] == Integer.MAX_VALUE) return ans;
            next = nums[i]+1;
        }
        if (next <= upper) {
            ans.add(getRange(next, upper));
        }
        return ans;
    }
    public String getRange(int n1, int n2) {
        return (n1 == n2) ? String.valueOf(n1) : String.format("%d->%d", n1, n2);
    }
}