import java.util.*;

public class DailyTemperatures {
    class Solution {
        public int[] dailyTemperatures(int[] T) {
            int length = T.length;
            int[] res = new int[length];
            Deque<Integer> stk = new LinkedList<Integer>();
            for (int i = 0; i < length; i++) {
                int temperature = T[i];
                while (!stk.isEmpty() && temperature > T[stk.peek()]) {
                    int prevIndex = stk.pop();
                    res[prevIndex] = i - prevIndex;
                }
                stk.push(i);
            }
            return res;
        }
    }
}
