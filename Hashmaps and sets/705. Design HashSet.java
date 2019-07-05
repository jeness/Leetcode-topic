class MyHashSet1 {

    class Bucket{
        ListNode head = new ListNode(-1);
    }
    class ListNode{
        int key;
        ListNode next;
        ListNode(int number){
            this.key = number;
        }
    }
    int size = 10000;
    Bucket[] bucket = new Bucket[size];
    private int hash(int num){ // convert key to bucket number
        return num % size;
    }
    
    private ListNode find(Bucket bucket, int key){ // in the current bucket, find the pre ListNode of key
        ListNode head = bucket.head;
        ListNode pre = head;
        while(head != null && head.key != key){
            pre = head;
            head = head.next;
        }
        return pre;
    }
    /** Initialize your data structure here. */
    public MyHashSet2() {
        
    }
    
    public void add(int key) {
        int i = hash(key);
        if(bucket[i] == null){
            bucket[i] = new Bucket();
        }
        ListNode pre = find(bucket[i], key);
        if(pre.next == null){
            pre.next = new ListNode(key);
        }
    }
    
    public void remove(int key) {
        int i = hash(key);
        if(bucket[i] != null){
            ListNode pre = find(bucket[i], key);
            if(pre.next != null){
                pre.next = pre.next.next;
            }
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int i = hash(key);
        if(bucket[i] != null){
            ListNode pre = find(bucket[i], key);
            if(pre.next != null){
                return true;   
            }
            else{
                return false;
            }
        }
        return false;
    }
}



class MyHashSet1 {

    /** Initialize your data structure here. */
    int[] dict;
    public MyHashSet() {
        dict = new int[1000000];
    }
    
    public void add(int key) {
        dict[key] = 1;
    }
    
    public void remove(int key) {
        dict[key] = 0;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(dict[key] == 1){
            return true;
        }
        else{
            return false;
        }
    }
}
