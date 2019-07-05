class Trie {

    /** Initialize your data structure here. */
    class Node{
        char c;
        String word;
        HashMap<Character, Node> children;
        public Node(char c){
            this.c = c;
            this.children = new HashMap<>();
        }
    }
    Node root;
    public Trie() {
        root = new Node('0');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] ch = word.toCharArray();
        Node node = root;
        for(int i = 0; i < ch.length; i++){
            if(!node.children.containsKey(ch[i])){
                node.children.put(ch[i], new Node(ch[i]));
            }
            node = node.children.get(ch[i]);
        }
        node.word = word;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] ch = word.toCharArray();
        Node node = root;
        for(int i = 0; i < ch.length; i++){
            if(!node.children.containsKey(ch[i])){
                return false;
            }
            else{
                node = node.children.get(ch[i]);
            }
        }
        return word.equals(node.word);  
        //注意这里要word写在node.word前面，因为node.word 可能等于null，null取不到equals
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] ch = prefix.toCharArray();
        Node node = root;
        for(int i = 0; i < ch.length; i++){
            if(!node.children.containsKey(ch[i])){
                return false;
            }
            else{
                node = node.children.get(ch[i]);
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */