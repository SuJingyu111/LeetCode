import java.util.*;

public class SingleNumberII {
    class Solution {
        public int singleNumber(int[] nums) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();//element, duplicate Number;
            for (int num : nums) {
                Integer value = map.get(num);
                if (value == null) {
                    map.put(num, 1);
                }
                else if (value == 2) {
                    map.remove(num);
                }
                else {
                    map.put(num, value + 1);
                }
            }
            int val = map.keySet().iterator().next();
            return val;
        }
    }
}
