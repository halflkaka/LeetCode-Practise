class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        int count = 1;
        while (count <= numRows) {
            List<Integer> cur = new ArrayList<>();
            helper(cur,ans);
            count ++;
        }
        
        return ans;
    }
    public void helper(List<Integer> cur, List<List<Integer>> ans) {
        cur.add(1);
        if (ans.size() == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        if (ans.size() == 1) {
            cur.add(1);
            ans.add(new ArrayList<>(cur));
            return;
        }
        List<Integer> last = ans.get(ans.size()-1);
        for (int i = 0; i < last.size() - 1; i++) {
            cur.add(last.get(i) + last.get(i+1));
        }
        cur.add(1);
        ans.add(new ArrayList<>(cur));
        return;
    }
}