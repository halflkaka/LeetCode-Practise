class Solution {
    public int minCut(String s) {
        if (s.length() == 0 || s.length() == 1) return 0;
        int n = s.length();
        boolean pd[][] = new boolean[n][n];
        int dp[] = new int[n];
        
        for (int i = n-1; i >= 0; i--) {
            dp[i] = n - i - 1;
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || pd[i+1][j-1])) {
                    pd[i][j] = true;
                    if (j == n-1) {
                        dp[i] = 0;
                    } else {
                        dp[i] = Math.min(1+dp[j+1], dp[i]);
                    }
                }
            }
        }
        return dp[0];
    }
}