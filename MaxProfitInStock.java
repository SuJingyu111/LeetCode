public class MaxProfitInStock {
    class Solution {
        public int maxProfit(int[] prices) {
            int length = prices.length;
            int res = 0;
            for (int i = 1; i < length; i++) {
                if (prices[i] > prices[i - 1])
                    res += prices[i] - prices[i - 1];
            }
            return res;
        }
    }

    
class DpSolution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[] dp = new int[length];
        dp[length - 1] = 0;
        int max = prices[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            dp[i] = Math.max(Math.max(prices[i + 1] - prices[i] + dp[i + 1], dp[i + 1]), max - prices[i]);
            if (prices[i] > max)
                max = prices[i];
        }
        return dp[0];
    }
}
}
