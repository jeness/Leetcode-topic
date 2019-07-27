class MyQueue {

    /** Initialize your data structure here. */
     Stack<Integer> input;
    Stack<Integer> output;
    public MyQueue() {
        input = new Stack<Integer>();
        output = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!output.isEmpty()){
            input.push(output.pop());
        }
        input.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!input.isEmpty()) {
            output.push(input.pop());
        }
        int res = output.pop();
        return res;
    }
    
    /** Get the front element. */
    public int peek() {
         while(!input.isEmpty()) {
            output.push(input.pop());
        }
        int res = output.peek();
       
        return res;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */