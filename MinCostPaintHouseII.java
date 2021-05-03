public class MinCostPaintHouseII {
    class Solution {
        public int minCostII(int[][] costs) {
            int houseNum = costs.length;
            int paintNum = costs[0].length;
            int[][] dp = new int[houseNum][paintNum];
            for (int i = 0; i < paintNum; i++) {
                dp[0][i] = costs[0][i];
            }
            for (int i = 1; i < houseNum; i++) {
                int prevMinPos = 0;
                int prevSecondMinPos = 0;
                for (int j = 0; j < paintNum; j++) {
                    if (dp[i - 1][j] < dp[i - 1][prevMinPos]) {
                        prevMinPos = j;
                    }
                }
                if (prevMinPos == 0) {
                    prevSecondMinPos = 1;
                }
                for (int j = 0; j < paintNum; j++) {
                    if (dp[i - 1][j] < dp[i - 1][prevSecondMinPos] && j != prevMinPos) {
                        prevSecondMinPos = j;
                    }
                }
                for (int k = 0; k < paintNum; k++) {
                    if (k != prevMinPos) {
                        dp[i][k] = dp[i - 1][prevMinPos] + costs[i][k];
                    }
                    else {
                        dp[i][k] = dp[i - 1][prevSecondMinPos] + costs[i][k];
                    }
                }
            }
            
            int minCost = dp[houseNum - 1][0];
            for (int cost : dp[houseNum - 1]) {
                if (cost < minCost) {
                    minCost = cost;
                }
            }
            return minCost;
        }
    }
}
