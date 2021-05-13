public class NumberOfWaysToStop {
    class Solution {
        public int numWays(int steps, int arrLen) {
            final int modVal = (int)(Math.pow(10, 9) + 7);
            int farEnd = Math.min(steps, arrLen);
            int[][] dp = new int[steps + 1][farEnd];
            dp[0][0] = 1;
            for (int i = 1; i <= steps; i++) {
                for (int j = 0; j < farEnd; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j > 0) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % modVal;
                    }
                    if (j < farEnd - 1) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % modVal; 
                    }
                }
            }
            return dp[steps][0] % modVal;
        }
    }
}
