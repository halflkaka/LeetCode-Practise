class Solution {
    public int numberOfPatterns(int m, int n) {
        int[][] skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[7][3] = skip[3][7] = skip[4][6] = skip[6][4]=5;
        boolean[] visited = new boolean[10];
        int res = 0;
        
        for (int i = m; i <= n; i++) {
            res += helper(skip, visited, 1, i-1) * 4;
            res += helper(skip, visited, 2, i-1) * 4;
            res += helper(skip, visited, 5, i-1);
        }
        return res;
    }
    
    public int helper(int[][] skip, boolean[] visited, int cur, int remain) {
        if (remain < 0) return 0;
        if (remain == 0) return 1;
        
        visited[cur] = true;
        int ans = 0;
        
        for (int i = 1; i <= 9; i++) {
            if (!visited[i] && (skip[i][cur] == 0 || visited[skip[i][cur]])) {
                ans += helper(skip, visited, i, remain-1);
            }
        }
        
        visited[cur] = false;
        return ans;
    }
}