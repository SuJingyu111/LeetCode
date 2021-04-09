class MinStack {

    class Node {
        public int val;
        public Node next;
        public Node() {}
        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    Node top;
    int min = Integer.MAX_VALUE;

    public MinStack() { 
    }
    
    public void push(int val) {
        if (top == null) {
            top = new Node(val);
        }
        else {
            top = new Node(val, top);
        }
        if (val < min)
            min = val;
    }
    
    public void pop() {
        if (top == null)
            return;
        int thisVal = top.val;
        top = top.next;
        if (thisVal == min) {
            Node cursor = top;
            min = Integer.MAX_VALUE;
            while (cursor != null) {
                if (cursor.val < min)
                    min = cursor.val;
                cursor = cursor.next;
            }
        }
    }
    
    public int top() {
        return top.val;
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
