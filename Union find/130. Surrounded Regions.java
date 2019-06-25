class Solution1 {
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
    public void solve(char[][] board) {
       //灌水法 bfs
        //从border上的O出发，把可以用O相连接上的O都灌上水W
        //把是W的设置成O，不是W的设置成X
        int m = board.length;
        if(m == 0){
            return;
        }
        int n = board[0].length;
        for(int i = 0; i < m; i++){ //从border出发
            bfs(board, i, 0);
            bfs(board, i, n-1);
        }
        for(int j = 0; j < n; j++){
            bfs(board, 0, j);
            bfs(board, m-1, j);
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'W'){
                    board[i][j] = 'O';
                }
                else{
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void bfs(char[][] board, int x, int y){
        if(board[x][y] != 'O'){
            return;
        }
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.offer(x);
        qy.offer(y);
        board[x][y] = 'W'; //灌水
        while(!qx.isEmpty() && !qy.isEmpty()){
            int cx = qx.poll();
            int cy = qy.poll();
            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(0 <= nx && nx < board.length && 0 <= ny && ny < board[0].length && board[nx][ny] == 'O'){
                    qx.offer(nx);
                    qy.offer(ny);
                    board[nx][ny] = 'W';
                }
            }
        }
    }
}