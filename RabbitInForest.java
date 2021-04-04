import java.util.*;

public class RabbitInForest {
    class Solution {
        public int numRabbits(int[] answers) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (Integer ans : answers) {
                if (!map.containsKey(ans)) {
                    map.put(ans, 1);
                }
                else {
                    map.put(ans, map.get(ans) + 1);
                }
            }
            int res = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getKey() >= entry.getValue())
                    res += entry.getKey() + 1;
                else {
                    int num = entry.getValue();
                    int ans = entry.getKey();
                    while (num > 0) {
                        res += ans + 1;
                        num -= ans + 1;
                    }
                }
            }
            return res;
        }
    }
}
