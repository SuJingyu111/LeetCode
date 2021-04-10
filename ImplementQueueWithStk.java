import java.util.*;

public class ImplementQueueWithStk {
    class MyQueue {

        /** Initialize your data structure here. */
        Deque<Integer> inStk;
        Deque<Integer> outStk;
        public MyQueue() {
            inStk = new LinkedList<Integer>();
            outStk = new LinkedList<Integer>();
        }
        
        /** Push element x to the back of queue. */
        public void push(int x) {
            inStk.push(x);
        }
        
        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (outStk.size() > 0) {
                return outStk.pop();
            }
            else {
                while (inStk.size() > 0) {
                    outStk.push(inStk.pop());
                }
                return outStk.pop();
            }
        }
        
        /** Get the front element. */
        public int peek() {
            if (outStk.size() > 0) {
                return outStk.peek();
            }
            else {
                while (inStk.size() > 0) {
                    outStk.push(inStk.pop());
                }
                return outStk.peek();
            }
        }
        
        /** Returns whether the queue is empty. */
        public boolean empty() {
            return inStk.size() == 0 && outStk.size() == 0;
        }
    }
}
