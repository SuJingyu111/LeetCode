import java.util.*;

public class BaseBallMatch {
    class Solution {
        Deque<Integer> stk = new LinkedList<Integer>();
    
        public int calPoints(String[] ops) {
            int length = ops.length;
            for (int i = 0; i < length; i++) {
                if (ops[i].equals("+")) {
                    int first = stk.pop();
                    int second = stk.peek();
                    stk.push(first);
                    stk.push(first + second);
                }
                else if (ops[i].equals("D")) {
                    stk.push(2 * stk.peekFirst());
                }
                else if (ops[i].equals("C")) {
                    stk.removeFirst();
                }
                else {
                    stk.push(Integer.parseInt(ops[i], 10));
                }
            }
            int res = 0;
            for (Integer i : stk) {
                res += i;
            }
            return res;
        }
    }
}
