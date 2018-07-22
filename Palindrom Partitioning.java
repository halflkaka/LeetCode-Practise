class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> res = new ArrayList<>();
        
        helper(ans, res, s, 0);
        return ans;
    }
    public void helper(List<List<String>> ans, List<String> res, String s, int start) {
        if (res.size() > 0 && start >= s.length()) {
            ans.add(new ArrayList(res));
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                if (i == start) {
                    res.add(Character.toString(s.charAt(i)));
                } else {
                    res.add(s.substring(start, i+1));
                }
                helper(ans, res, s, i+1);
                res.remove(res.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int start, int end) {
        if (start == end) return true;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}