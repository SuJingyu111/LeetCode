public class MinCostClimbingStairs {
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int length = cost.length;
            int[] dp = new int[length];
            dp[length - 1] = cost[length - 1];
            dp[length - 2] = cost[length - 2];
            for (int i = length - 3; i >= 0; i--) {
                dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
            }
            return Math.min(dp[0], dp[1]);
        }
    }
}
