class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rowMax = matrix.length, rowMin = 0;
        if (rowMax == 0) return res;
        int columnMax = matrix[0].length, columnMin = 0;
        int[][] flag = new int[rowMax][columnMax];
        while (rowMin < rowMax && columnMin < columnMax) {
            for (int i = columnMin; i < columnMax; i++) {
                if (flag[rowMin][i] == 0) {
                    res.add(matrix[rowMin][i]);
                    flag[rowMin][i] = 1;
                }
            }
            rowMin ++;
            for (int i = rowMin; i < rowMax; i++) {
                if (flag[i][columnMax-1] == 0) {
                    res.add(matrix[i][columnMax-1]);
                    flag[i][columnMax-1] = 1;
                }
            }
            columnMax --;
            for (int i = columnMax-1; i >= columnMin; i--) {
                if (flag[rowMax-1][i] == 0) {
                    res.add(matrix[rowMax-1][i]);
                    flag[rowMax-1][i] = 1;
                }
            }
            rowMax--;
            for (int i = rowMax-1; i >= rowMin; i--) {
                if (flag[i][columnMin] == 0) {
                    res.add(matrix[i][columnMin]);
                    flag[i][columnMin] = 1;
                }
            }
            columnMin ++;
        }
        return res;
    }
}