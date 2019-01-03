class Solution {
    public int shortestDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n], reach = new int[m][n];
        int numBuilding = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    numBuilding++;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (!bfs(grid, i, j, m, n, dist, reach, numBuilding)) {
                        return -1;
                    }
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && reach[i][j] == numBuilding) {
                    min = Math.min(min, dist[i][j]);
                }
            }
        }
        return min == Integer.MAX_VALUE? -1 : min;
    }
    
    public boolean bfs(int[][] grid, int i, int j, int m, int n, int[][] dist, int[][] reach, int numBuilding) {
        int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        int level = 0, count = 0;
        
        while (q.size() > 0) {
            int size = q.size();
            level ++;
            for (int x = 0; x < size; x++) {
                int[] cur = q.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = cur[0] + dx[k], ny = cur[1] + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny])                     {
                        if (grid[nx][ny] == 0 && !visited[nx][ny]) {
                            visited[nx][ny] = true;
                            dist[nx][ny] += level;
                            reach[nx][ny]++;
                            q.offer(new int[]{nx, ny});
                        } else if (grid[nx][ny] == 1) {
                            count ++;
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
        return count == numBuilding;
    }
}