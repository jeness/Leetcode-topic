public class Solution {
    /**
     * @param words: a list of strings
     * @return: the longest word in words that can be built one character at a time by other words in words
     */
    public String longestWord(String[] words) {
        // Write your code here
        Trie trie = new Trie(words);
        int index = 1;
        for(String word : words){
            trie.insert(word, index++);
        }
        return trie.dfs();
    }
    
    class Node{
        char c;
        HashMap<Character, Node> children;
        int end; // end = 当前单词在words数组中的索引
        public Node(char c){
            this.c = c;
            this.children = new HashMap<>();
        }
    }
    class Trie{
        Node root;
        String[] words;
        public Trie(String[] words){
            this.root = new Node('0');
            this.words = words;
        }
        
        public void insert(String word, int index){
            char[] ch = word.toCharArray();
            Node node = root;
            for(int i = 0; i < ch.length; i++){
                if(!node.children.containsKey(ch[i])){
                    node.children.put(ch[i], new Node(ch[i]));
                }
                node = node.children.get(ch[i]);
            }
            node.end = index;
        }
        
        public String dfs(){
            String ans = "";
            Stack<Node> st = new Stack<>();
            //找一条最长的路径，找路径用dfs，用stack
            st.push(root);
            while(!st.isEmpty()){
                Node cur = st.pop();
                if(cur.end > 0 || cur == root){
                    if(cur != root){
                        String text = words[cur.end - 1]; // 通过cur.end取到当前的字符串内容
                        if(text.length() > ans.length() || (text.length() == ans.length() && text.compareTo(ans) < 0)){
                            ans = text;
                        }
                    }
                    for(Node nei : cur.children.values()){
                        st.push(nei);
                    }
                }
            }
            return ans;
        }
    }
}