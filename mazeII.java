class Solution {
    public int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze.length == 0) return 0;
        int m = maze.length, n = maze[0].length;
        int[][] best = new int[m][n];
        // Set all cell as -1
        for(int[] a:best){
            Arrays.fill(a,-1);
        }
        
        best[start[0]][start[1]] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        
        while (q.size() > 0) {
            int[] cur = q.poll();
            
            for (int k = 0; k < 4; k++) {
                int x = cur[0], y = cur[1], l = best[x][y];
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x += dir[k][0];
                    y += dir[k][1];
                    l ++;
                }
                x -= dir[k][0];
                y -= dir[k][1];
                l --;
                if (best[x][y] == -1 || best[x][y] > l) {
                    best[x][y] = l;
                    q.offer(new int[]{x,y});
                }
            }
        }
        return best[destination[0]][destination[1]];
    }
    
}