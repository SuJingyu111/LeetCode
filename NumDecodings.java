public class NumDecodings {
    class Solution {
        public int numDecodings(String s) {
            if (s.charAt(0) == '0')
                return 0;
            int length = s.length();
            int[] dp = new int[length + 1];
            dp[length] = 1;
            //dp[length - 1] = 1;
            for (int i = length - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (c == '0')
                    continue;
                if (i < length - 1 && (c == '1' || (c == '2' && s.charAt(i + 1) <= '6'))) {
                    dp[i] = dp[i + 1] + dp[i + 2];
                }
                else {
                    dp[i] = dp[i + 1];
                }
                //System.
            }
            return dp[0]; 
        }
    }
}
