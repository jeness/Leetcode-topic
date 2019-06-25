class Solution1 {
    public int findCircleNum(int[][] M) {
        //dfs
        int n = M.length;
        boolean[] visited = new boolean[n];
        int circle = 0;
        for(int i = 0; i < M.length; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(M, visited, i);
                circle++;
            }
        }
        return circle;
    }
    
    private void dfs(int[][] M, boolean[] visited, int i){
        for(int j = 0; j < M[0].length; j++){
            if(!visited[j] && M[i][j] == 1){
                //move from i to j
                visited[j] = true;
                dfs(M, visited, j);
            }
        }
    }
}

class Solution2 {
    public int findCircleNum(int[][] M) {
        //bfs-queue
        Queue<Integer> q = new LinkedList<>();
        int n = M.length;
        int[] visited = new int[n];
        int count = 0;
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                q.add(i);
                while(!q.isEmpty()){
                    int cur = q.remove();
                    for(int j = 0; j < n; j++){
                        if(M[cur][j] == 1 && visited[j] == 0){
                            visited[j] = 1;
                            q.add(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
}

class Solution3 {
    //union find
    public int findCircleNum(int[][] M) {
        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);
        for(int i = 0; i < M.length; i++){
            for(int j = 0; j < M.length; j++){
                if(M[i][j] == 1 && i != j){
                    union(parent, i, j);
                }
            }
        }
        int count = 0;
        for(int i = 0; i < parent.length; i++){
            if(parent[i] == -1){
                count++;
            }
        }
        return count;
    }
    
    private int find(int parent[], int i){
        if(parent[i] == -1){
            return i;
        }
        return find(parent, parent[i]);
    }
    private void union(int parent[], int x, int y){
        int xset = find(parent, x);
        int yset = find(parent, y);
        if(xset != yset){
            parent[xset] = yset;
        }
    }
}