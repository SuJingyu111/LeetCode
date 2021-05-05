public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        int[] sum = new int[maxVal + 1];
        for (int val : nums) {
            sum[val] += val;
        }
        int length = sum.length;
        int[] dp = new int[length];
        dp[0] = sum[0]; dp[1] = Math.max(sum[0], sum[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + sum[i], dp[i - 1]);
        }
        int max = Integer.MIN_VALUE;
        for (int points : dp) {
            max = points > max ? points : max;
        }
        return max;
    }
}
