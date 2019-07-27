class MyStack {

    /** Initialize your data structure here. */
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    private void moveItems(){
        //moveItems from q1 to q2, q1 留 1 个元素
        while(q1.size() != 1){
            q2.add(q1.remove());
        }
    }
    
    private void swapQueue(){
        //swap all items in q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        moveItems();
        int res = q1.remove();
        swapQueue();
        return res;
        
    }
    
    /** Get the top element. */
    public int top() {
        moveItems();
        int item = q1.peek();
        swapQueue();
        q1.add(q2.remove());
        return item;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */