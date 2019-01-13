class Solution {
    public int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze.length == 0) return false;
        return dfs(maze, start[0], start[1], destination, new boolean[maze.length][maze[0].length]);
    }
    
    public boolean dfs(int[][] maze, int i, int j, int[] destination, boolean[][] visited) {
        if (i == destination[0] && j == destination[1]) return true;
        int m = maze.length, n = maze[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j]) return false;
        visited[i][j] = true;
        
        for (int k = 0; k < 4; k++) {
            int x = i, y = j;
            while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                x += dir[k][0];
                y += dir[k][1];
            }
            if (dfs(maze, x-dir[k][0], y-dir[k][1], destination, visited)) return true;
        }
        return false;
    }
}