class MyHashMap1 {
    //like design hashset
    class ListNode{
        int key;
        int value;
        ListNode next;
        public ListNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    class Bucket{
        ListNode head = new ListNode(-1, -1);
    }
    /** Initialize your data structure here. */
    public MyHashMap() {
        
    }
    int size = 10000;
    Bucket[] bucket = new Bucket[size];
    
    private int hash(int key){ // get which bucket to use
        return key % size; 
    }
    
    private ListNode find(Bucket bucket, int key){ // in one bucket, find where the pre of key is (in the list)
        ListNode head = bucket.head;
        ListNode pre = head;
        while(head != null && head.key != key){
            pre = head;
            head = head.next;
        }
        return pre;
    }
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = hash(key);
        if(bucket[i] == null) {
            bucket[i] = new Bucket();
        }
        ListNode pre = find(bucket[i], key);
        if(pre.next == null){
            pre.next = new ListNode(key, value);
        }
        else{
            pre.next.value = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = hash(key);
        if(bucket[i] == null){
            return -1;
        }
        ListNode pre = find(bucket[i], key);
        if(pre.next == null){
            return -1;
        }
        else{
            return pre.next.value;
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = hash(key);
        if(bucket[i] == null){
            return;
        }
        ListNode pre = find(bucket[i], key);
        if(pre.next == null){
            return;
        }
        else{
            pre.next = pre.next.next;
        }
    }
}



class MyHashMap2 {
    int[] map; // hash function : f[x] = x
    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new int[1000000];
        Arrays.fill(map, -1); //not contains key，return -1
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        map[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return map[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map[key] = -1;
    }
}
