class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);  //因为没有返回值，所以另起一个递归的函数solve做为主函数
    }
    
    private boolean solve(char[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    continue;
                }
                for(int k = 1; k <= 9; k++){
                    board[i][j] = (char)(k + '0');
                    if(isValid(board, i, j) && solve(board)){
                        return true;
                    }
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return true;
    }
    
    private boolean isValid(char[][] board, int x, int y){
        Set<Character> set = new HashSet<>();
        for(int j = 0; j < 9; j++){
            if(set.contains(board[x][j])){
                return false;
            }
            if(board[x][j] >= '1' && board[x][j] <= '9'){
                set.add(board[x][j]);
            }
        }
        
        set = new HashSet<>();
        for(int i = 0; i < 9; i++){
            if(set.contains(board[i][y])){
                return false;
            }
            if(board[i][y] >= '1' && board[i][y] <= '9'){
                set.add(board[i][y]);
            }
        }
        set = new HashSet<>();
        for(int m = 0; m < 3; m++){
            for(int n = 0; n < 3; n++){
                int curX = x / 3 * 3 + m;
                int curY = y / 3 * 3 + n;
                if(set.contains(board[curX][curY])){
                    return false;
                }
                if(board[curX][curY] >= '1' && board[curX][curY] <= '9'){
                    set.add(board[curX][curY]);
                }
            }
        }
        return true;
    }
}