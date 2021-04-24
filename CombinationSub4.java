import java.util.*;

public class CombinationSub4 {
    class Solution {
        int res = 1;
        public int combinationSum4(int[] nums, int target) {
            int[] dp = new int[target + 1];
            Arrays.fill(dp, 0);
            dp[0] = 1;
            for (int i = 0; i <= target; i++) {
                for (int num : nums) {
                    if (i + num <= target) {
                        dp[i + num] += dp[i];
                    }
                }
            }
            return dp[target];
        }
    }
}
