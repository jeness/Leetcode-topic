public class Solution {
    /**
     * @param word1: A string
     * @param word2: A string
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // dp 解法
        // d[i][j]: 从word1[0:i-1] 到word2[0:j-1] 的min distance
        //         d(i, j) 表示把 str1 前 i 个字符编辑成 str2 前 j 个字符所需要的最小 edit distance
//         d(2, 1)     = 1 + d(1, 1)
// edit("ab", "a")  = 1 + edit("a", "a")  <- delete "b" from str1
//         d(1, 2)     = 1 + d(1, 1)
// edit("a", "ab") = 1 + edit("a", "a")  <- insert "b" into str1
//         d(2, 2)     = 1 + d(1, 1)
// edit("ab", "ac") = 1 + edit("a", "a") <- replace "b" with "c" in str1
        int m = word1.length();
        int n = word2.length();
        int[][] d = new int[m+1][n+1];
        for(int i = 0; i < m+1; i++){
            d[i][0] = i;
        }
        for(int j = 0; j < n+1; j++){
            d[0][j] = j;
        }
        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    d[i][j] = d[i-1][j-1];
                }
                else{
                    d[i][j] = Math.min(Math.min(d[i][j-1], d[i-1][j]), d[i-1][j-1]) + 1;
                                        //insert          delete         replace
                }
            }
        }
        return d[m][n];
    }
}

class Solution {
    private int[][] d; //min distance from word[0:m-1] to word[0:n-1]
    public int minDistance(String word1, String word2) {
        //recursive memo
        int m = word1.length();
        int n = word2.length();
        
        d = new int[m+1][n+1];
        for(int[] row: d){
            Arrays.fill(row, -1);
        }
        return minDistanceHelper(word1, m, word2, n);
    }
    private int minDistanceHelper(String word1, int m, String word2, int n){
        if(m == 0){
            return n;
        }
        if(n == 0){
            return m;
        }
        if(d[m][n] >= 0) {
            return d[m][n];
        }
        int ans = 0;
        if(word1.charAt(m-1) == word2.charAt(n-1)){
            ans = minDistanceHelper(word1, m-1, word2, n-1);
        }
        else{
            ans = Math.min(minDistanceHelper(word1, m-1, word2, n-1), //replace
                Math.min(minDistanceHelper(word1, m-1, word2, n), //insert
        minDistanceHelper(word1, m, word2, n-1))) + 1; //delete
        }
        d[m][n] = ans;
        return ans;
    }
}