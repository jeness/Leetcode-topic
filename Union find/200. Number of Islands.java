class Solution1 {
    //bfs
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    count++;
                    bfs(grid, visited, i, j);
                }
            }
        }
        return count;
    }
    
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
    private void bfs(char[][] grid, boolean[][] visited, int x, int y){
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.add(x);
        qy.add(y);
        visited[x][y] = true;
        while(!qx.isEmpty() && !qy.isEmpty()){
            int cx = qx.poll();
            int cy = qy.poll();
            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(0 <= nx && nx < grid.length && 0 <= ny && ny < grid[0].length && visited[nx][ny] == false && grid[nx][ny] == '1'){
                    qx.add(nx);
                    qy.add(ny);
                    visited[nx][ny] = true;
                }
            }
        }
    }
}


class Solution2 {  //union find
    public int numIslands(char[][] grid) {
         if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    for(int k = 0; k < 4; k++){
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == '1') { 
                            int id1 = i*col+j;
                            int id2 = x*col+y;
                            uf.union(id1, id2);  
                        }  
                    }
                }
            }
        }
        return uf.count;
    }
    
class UnionFind{
    int[] father;
    int m, n;
    int count = 0;
    UnionFind(char[][] grid){
        m = grid.length;
        n = grid[0].length;
        father = new int[m * n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    int id = i * n + j;
                    father[id] = id;
                    count++;
                }
            }
        }
    }
    
    public void union(int id1, int id2){
        int find1 = find(id1);
        int find2 = find(id2);
        if(find1 != find2){
            father[find1] = find2;
            count--;
        }
    }
    
    public int find(int id){
        if(father[id] == id){
            return id;
        }
        father[id] = find(father[id]);
        return father[id];
    }
}
}