import java.util.Hashtable;
class LRUCache {
    class DlinkedNode{
        int key;
        int value;
        DlinkedNode pre;
        DlinkedNode post;
    }
    private void addNode(DlinkedNode node) {//after head node, add node
        node.pre = head;
        node.post = head.post;
        
        head.post.pre = node;
        head.post = node;
    }
    
    private void removeNode(DlinkedNode node) {
        DlinkedNode pre = node.pre;
        DlinkedNode post = node.post;
        
        pre.post = post;
        post.pre = pre;
    }
    
    private DlinkedNode popTail() {
        DlinkedNode node = tail.pre;
        this.removeNode(node);
        return node;
    }
    
    private void moveToHead(DlinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }
    
    private Hashtable<Integer, DlinkedNode> cache = new Hashtable<Integer, DlinkedNode>();
    private int capacity;
    private int count;
    private DlinkedNode tail, head;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        tail = new DlinkedNode();
        tail.post = null;
        head = new DlinkedNode();
        head.pre = null;
        
        tail.pre = head;
        head.post = tail;
    }
    
    public int get(int key) {
        DlinkedNode node = this.cache.get(key);
        if(node == null) {
            return -1;
        }
        this.moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DlinkedNode node = this.cache.get(key);
        if(node == null) {
            DlinkedNode newNode = new DlinkedNode();
            newNode.key = key;
            newNode.value = value;
            this.addNode(newNode);
            this.cache.put(key,newNode);
            count++;
            if(count>capacity) {
                DlinkedNode tail = new DlinkedNode();
                tail = this.popTail();
                this.cache.remove(tail.key);
                count--;
            }
        }
        else{
            node.value = value;
            this.moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */