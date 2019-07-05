public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here
        TrieNode root = buildTrie(words); 
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, root, i, j, ans);   //dfs 从每个点出发，dfs，寻找路径
            }
        }
        return ans;
    }
    
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    private void dfs(char[][] board, TrieNode p, int i, int j, List<String> ans){
        char c = board[i][j];
        if(c == '#' || p.next[c - 'a'] == null) { // visited or not a word in the dict
            return;
        }
        p = p.next[c - 'a']; // go to next letter
        if(p.word != null){
            ans.add(p.word);
            p.word = null; //deduplicate
        }
        board[i][j] = '#'; // mark as visited
        for(int k = 0; k < 4; k++){
            int cx = i + dx[k];
            int cy = j + dy[k];
            if(cx >= 0 && cx <board.length && cy >= 0 && cy < board[0].length){
                dfs(board, p, cx, cy, ans);
            }
        }
        board[i][j] = c; //回溯，因为还有可能别的路径经过
    }
    
    
    class TrieNode{
        char c;
        TrieNode[] next = new TrieNode[26];
        String word;
    }
    
    public TrieNode buildTrie(List<String> words){
        TrieNode root = new TrieNode();
        for(int i = 0; i < words.size(); i++){
            TrieNode p = root;
            for(char c : words.get(i).toCharArray()){
                int k = c - 'a';
                if(p.next[k] == null){
                    p.next[k] = new TrieNode();
                }
                p = p.next[k];
            }
            p.word = words.get(i);
        }
        return root;
    }
}