class Solution {
    public int[][] generateMatrix(int n) {
        int columnMin = 0, columnMax = n, rowMin = 0, rowMax = n;
        int[][] matrix = new int[n][n];
        int num = 1;
        
        while (rowMin <= rowMax && columnMin <= columnMax) {
            for (int i = columnMin; i < columnMax; i ++) {
                matrix[rowMin][i] = num++;
            }
            rowMin++;
            for (int i = rowMin; i < rowMax; i++) {
                matrix[i][columnMax-1] = num++;
            }
            columnMax--;
            for (int i = columnMax-1; i >= columnMin; i--) {
                matrix[rowMax-1][i] = num++;
            }
            rowMax--;
            for (int i = rowMax-1; i >= rowMin; i--) {
                matrix[i][columnMin] = num++;
            }
            columnMin++;
        }
        return matrix;
    }
}