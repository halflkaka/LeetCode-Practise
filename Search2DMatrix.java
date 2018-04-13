class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||(matrix.length==1&&matrix[0].length==0)) return false;
        int row = matrix.length, column = matrix[0].length;
        int begin = 0, end = row * column - 1;
        while (begin != end) {
            int mid = (begin + end - 1) / 2;
            if (matrix[mid/column][mid%column] == target) return true;
            if (matrix[mid/column][mid%column] > target) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return matrix[end/column][end%column] == target;
    }
}