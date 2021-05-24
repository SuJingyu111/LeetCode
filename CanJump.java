import java.util.*;

public class CanJump {
    class Solution {
        public boolean canJump(int[] nums) {
            int len = nums.length;
            if (len == 1) {
                return true;
            }
            Queue<Integer> q = new LinkedList<>();
            q.offer(0);
            int maxTruePos = 0;
            while (!q.isEmpty()) {
                int pos = q.poll();
                int steps = nums[pos];
                if (pos + steps <= maxTruePos) {
                    continue;
                }
                for (int i = maxTruePos + 1; i <= pos + steps; i++) {
                    if (i >= len - 1) {
                        return true;
                    }
                    q.offer(i);
                }
                maxTruePos = pos + steps;
            }
            return false;
        }
    }
}
