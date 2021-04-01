import java.util.*;

public class EvalRPN {
    class Solution {
        Deque<Integer> stk = new LinkedList<Integer>();
    
        public int evalRPN(String[] tokens) {
            for (String s : tokens) {
                if (s.equals("+")) {
                    stk.push(stk.pop() + stk.pop());
                }
                else if (s.equals("*")) {
                    stk.push(stk.pop() * stk.pop());
                }
                else if (s.equals("/")) {
                    int right = stk.pop();
                    int left = stk.pop();
                    stk.push(left / right);
                }
                else if (s.equals("-")) {
                    int right = stk.pop();
                    int left = stk.pop();
                    stk.push(left - right);
                }
                else {
                    stk.push(Integer.parseInt(s));
                }
            }
            int res = 0;
            for (int i : stk) {
                res += i;
            }
            return res;
        }
    }
}
