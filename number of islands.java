class Solution {
    public int numIslands(char[][] grid) {
        int num = 0;
        if (grid.length == 0) return 0;
        int height = grid.length, width = grid[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    DFS(i,j,height,width, grid);
                }
            }
        }
        return num;
    }
    public void DFS(int i, int j, int m, int n, char[][] grid) {
        if (i >= m || j >= n || i < 0 || j < 0 || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFS(i,j+1,m,n,grid);
        DFS(i,j-1,m,n,grid);
        DFS(i-1,j,m,n,grid);
        DFS(i+1,j,m,n,grid);
    }
}