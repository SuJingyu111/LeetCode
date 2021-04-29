public class CanCross {
    class Solution {
        public boolean canCross(int[] stones) {
            int length = stones.length;
            if (stones[1] != 1)
                return false;
            boolean[][] dp = new boolean[length][length];
            dp[1][1] = true;
            for (int i = 1; i < length; i++) {
                for (int j = i + 1; j < length; j++) {
                    int distance = stones[j] - stones[i];
                    if (distance > i + 1) {
                        break;
                    }
                    dp[j][distance] = dp[i][distance] || dp[i][distance - 1];
                    if (distance + 1 < length) {
                        dp[j][distance] = dp[j][distance] || dp[i][distance + 1];
                    }
                }
            }
    
            for (int i = length - 1; i >= 0; i--) {
                if (dp[length - 1][i] == true) {
                    return true;
                }
            }
            return false;
        }
    }
}
