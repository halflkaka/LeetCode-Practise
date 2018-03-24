class Solution {
    public String getPermutation(int n, int k) {
        StringBuffer res = new StringBuffer("");
        StringBuffer original = new StringBuffer("");
        for (int i = 1; i <= n; i++) {
            original.append(i);
        }
        
        k--;
        int index = k / helper(n-1);
        int cur = n - 1;
        while (cur >= 0) {
            res.append(original.charAt(index));
            original.deleteCharAt(index);
            
            if (k - index * helper(cur) >= 0) {
                k = k - index * helper(cur);
            } else {
                k = 1;
            }
            cur--;
            if (cur >= 0) index = k / helper(cur);
        }
        return res.toString();
    }
    public int helper(int n) {
        if (n == 1 || n == 0) return 1;
        return n * helper(n-1);
    }
   
}