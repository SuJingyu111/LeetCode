import java.util.*;

public class MinCostPaintHouseIII {
    class Solution {
        int MAX = Integer.MAX_VALUE / 2;
        public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
            int blockCnt = 1;
            for (int i = 1; i < m; i++) {
                if (houses[i] != houses[i - 1] && houses[i] != 0 && houses[i - 1] != 0) {
                    blockCnt += 1;
                }
            }
            if (blockCnt > target) {
                return -1;
            }
            for (int i = 0; i < m; ++i) {
                --houses[i];
            }
    
            int[][][] dp = new int[m][n][target];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    Arrays.fill(dp[i][j], MAX);
                    if (i == 0) {
                        if (houses[i] == -1) {
                            dp[i][j][0] = cost[i][j];
                        }
                        else if (houses[i] == j){
                            dp[i][j][0] = 0;
                        }
                    }
                }
            }
    
            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (houses[i] != -1 && houses[i] != j) {
                        continue;
                    }
                    for (int k = 0; k < target; k++) {
                        int switchCost = MAX;
                        for (int jj = 0; jj < n; jj++) {
                            if (k == 0) {
                                break;
                            }
                            if (jj == j){
                                continue;
                            }
                            else {
                                switchCost = dp[i - 1][jj][k - 1] < switchCost ? dp[i - 1][jj][k - 1] : switchCost;
                            }
                        }
    
                        if (houses[i] == j) {
                            dp[i][j][k] = Math.min(dp[i - 1][j][k], switchCost);
                        }
                        else if (houses[i] == -1) {
                            int keepCost = dp[i - 1][j][k] == MAX ? MAX : dp[i - 1][j][k] + cost[i][j];
                            dp[i][j][k] = Math.min(keepCost, switchCost + cost[i][j]);
                        }
                    }
                }
            }
    
            int res = MAX;
            for (int j = 0; j < n; j++) {
                if (dp[m - 1][j][target - 1] < res) {
                    res = dp[m - 1][j][target - 1];
                }
            }
            if (res == MAX) {
                return -1;
            }
            return res;
        }
    }
}
