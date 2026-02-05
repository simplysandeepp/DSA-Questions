class Solution {
    public void solve(char[][] board) {
        if(board ==null || board.length==0){
            return;
        }
        int rows = board.length;
        int cols = board[0].length;

        //border conditions check krne k liye
        for (int i=0; i<rows; i++) {
            dfs(board, i, 0);
            dfs(board, i, cols - 1);
        }
        for (int j=0; j<cols; j++) {
            dfs(board, 0, j);
            dfs(board, rows - 1, j);
        }
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {

                //trap krne k liye
                if(board[i][j]=='O') {
                    board[i][j]='X';
                } else if(board[i][j]=='#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    public void dfs(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != 'O') {
            return;
        }
 
        board[r][c] = '#';
        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);    
    }
}

