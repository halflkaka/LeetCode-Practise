class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    public boolean helper(char[][] board, String word, int i, int j, int cur) {
        if (cur == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
            || board[i][j] != word.charAt(cur)) {
            return false;
        }
        board[i][j] = '%';
        boolean check = helper(board, word, i+1, j, cur+1) || 
            helper(board, word, i, j+1, cur+1) ||
            helper(board, word, i-1, j, cur+1) ||
            helper(board, word, i, j-1, cur+1);
        board[i][j] = word.charAt(cur);
        return check;
    }
}