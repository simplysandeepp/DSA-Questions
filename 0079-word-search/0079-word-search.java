class Solution {
    public boolean exist(char[][] board, String word) {
        int n = word.length();
        StringBuilder arr = new StringBuilder();
        return helper(1,1,arr); 
    }
    public static boolean helper(char i, char j, StringBuilder arr) {
        if(n==0) return false;
        if(n==1) {
            if(board[i][j] == word.charAt(0)) return true;
            else return false; 
        }
        int m=board.length;
        for(char i; i<m;i++) {
            for(char j;j<board[0].length(); j++) {
                if(board[i][j] == word.charAt(0)) {
                    arr.append(board[i][j]);
                } 
            }
        }
        if(word.equals(arr.toString())) {
            return true; 
        } else return false;
    }
}