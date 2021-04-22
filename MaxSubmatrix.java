public class MaxSubmatrix {
    class Solution {
        public int maxSumSubmatrix(int[][] matrix, int k) {
            int m = matrix.length, n = matrix[0].length;
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; ++i) {
                for (int j = 1; j <=n; ++j) {
                    dp[i][j] = matrix[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
                    if (dp[i][j] == k) return k;
                } 
            }                 
            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    for (int x = 0; x < i; ++x) {
                        for (int y = 0; y < j; ++y) {
                            int area = dp[i][j] - dp[x][j] - dp[i][y] + dp[x][y];
                            if (area < k) {
                                max = Math.max(max, area);
                            } else if (area == k) {
                                return k;
                            }
    
                        }
                    }
                }
            }
            return max;
        }
    }
}
