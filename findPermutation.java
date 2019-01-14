class Solution {
    public int[] findPermutation(String s) {
        s = s + ".";
        int min = 1, i = 0;
        int[] ans = new int[s.length()];
        
        while (i < s.length()) {
            if (s.charAt(i) != 'D') {
                ans[i++] = min++;
            } else {
                int j = i;
                while (j < s.length() && s.charAt(j) == 'D') j++;
                for (int k = j; k >= i; k--) {
                    ans[k] = min++;
                }
                i = j+1;
            }
        }
        return ans;
    }
}