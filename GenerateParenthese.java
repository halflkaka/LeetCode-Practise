class Solution {
    private List<String> result;
    
    public List<String> generateParenthesis(int n) {
        result = new LinkedList<>();
        String ans = new String();
        helper(ans, 0, 0, n);
        return result;
    }
    
    public void helper(String cur, int lp, int rp, int N) {
        if (cur.length() == N * 2) {
            result.add(cur);
            return;
        } 
        if (lp > rp) {
            helper(cur + ")", lp, rp+1, N);
        } 
        if (lp < N) {
            helper(cur + "(", lp+1, rp, N);
        }
    }
}