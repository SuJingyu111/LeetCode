public class LongestCommonSubsequence {
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int[][] dp = new int[text1.length() + 1][text2.length() + 1];
            dp[0][text2.length() - 1] = 0;
            dp[text1.length() - 1][0] = 0;
            dp[0][0] = 0;
    
            for (int i = 1; i <= text1.length(); i++) {
                char c = text1.charAt(i - 1);
                for (int j = 1; j <= text2.length(); j++) {
                    if (text2.charAt(j - 1) == c) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    }
                    else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }
            return dp[text1.length()][text2.length()];
        }
    }
}
