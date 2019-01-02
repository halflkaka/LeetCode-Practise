class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> cube = new HashSet<>();
            //borad[i][j], borad[j][i]
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && row.contains(board[i][j])) return false;
                if (board[j][i] != '.' && col.contains(board[j][i])) return false;
                if (board[3*(i/3)+j/3][3*(i%3)+j%3] != '.' && cube.contains(board[3*(i/3)+j/3][3*(i%3)+j%3])) return false;
                    //3*(i/3)+j/3, 3*(i%3)+j%3
                row.add(board[i][j]);
                col.add(board[j][i]);
                cube.add(board[3*(i/3)+j/3][3*(i%3)+j%3]);
            }
        }
        return true;
    }
}