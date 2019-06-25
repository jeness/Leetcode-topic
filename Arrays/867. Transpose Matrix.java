class Solution {
    //求转置矩阵
    public int[][] transpose(int[][] A) {
        int row = A[0].length;
        int col = A.length;
        int[][] ans = new int[row][col];
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                ans[j][i] = A[i][j];
            }
        }
        return ans;
    }
}