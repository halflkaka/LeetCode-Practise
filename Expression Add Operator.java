class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        if (num == null || num.length() == 0) return ans;
        helper(ans, num, target, "", 0, 0, 0);
        return ans;
    }
    public void helper(List<String> ans, String num, int target, String path, int start, long cur, long last) {
        if (start == num.length() && cur == target) {
            ans.add(path);
            return;
        }
        for (int i = start; i < num.length(); i++) {
            if (i != start && num.charAt(start) == '0') break;
            long pos = Long.parseLong(num.substring(start,i+1));
            if (start == 0) {
                helper(ans, num, target, path+pos, i+1, pos, pos);
            } else {
                helper(ans, num, target, path+"+"+pos, i+1, cur+pos, pos);
                helper(ans, num, target, path+"-"+pos, i+1, cur-pos, -pos);
                helper(ans, num, target, path+"*"+pos, i+1, cur - last + last * pos, last*pos);
            }
        }
    }
}