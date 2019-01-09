class Solution {
    public int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> ans = new ArrayList<>();
        if (matrix.length == 0) return ans;
        int m = matrix.length, n = matrix[0].length;
        boolean[][] pac = new boolean[m][n], atl = new boolean[m][n];
        Queue<int[]> pq = new LinkedList<>(), aq = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            pac[i][0] = true;
            atl[i][n-1] = true;
            pq.offer(new int[]{i,0});
            aq.offer(new int[]{i, n-1});
        }
        
        for (int i = 0; i < n; i++) {
            pac[0][i] = true;
            atl[m-1][i] = true;
            pq.offer(new int[]{0,i});
            aq.offer(new int[]{m-1,i});
        }
        
        bfs(matrix, pac, pq);
        bfs(matrix, atl, aq);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] && atl[i][j]) {
                    ans.add(new int[]{i,j});
                }
            }
        }
        return ans;
    }
    
    public void bfs(int[][] matrix, boolean[][] visited, Queue<int[]> q) {
        int m = matrix.length, n = matrix[0].length;
        
        while (q.size() > 0) {
            int[] cur = q.poll();
            for (int[] d : dir) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];

                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || matrix[x][y] < matrix[cur[0]][cur[1]] ) {
                    continue;
                }

                visited[x][y] = true;
                q.offer(new int[]{x,y});
            }
        }
        
    }
}