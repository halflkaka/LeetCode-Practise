class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> ans = new ArrayList<>();
        ans = helper(n,n);
        return ans;
    }
    public List<String> helper(int n, int count) {
        if (n == 0) return Arrays.asList("");
        if (n == 1) {
            return Arrays.asList(new String[]{"0", "8", "1"});
        }
        List<String> tmp = helper(n-2, count);
        List<String> ans = new ArrayList<>();
        
        for (String s : tmp) {
            if (n != count) {
                ans.add("0" + s + "0");
            }
            ans.add("1" + s + "1");
            ans.add("6" + s + "9");
            ans.add("8" + s + "8");
            ans.add("9" + s + "6");
        }
    }
}