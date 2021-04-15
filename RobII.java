public class RobII {
    class Solution {
        public int rob(int[] nums) {
            int length = nums.length;
            int[] dp1 = new int[length + 1], dp2 = new int[length + 1];
            dp1[length] = 0;
            dp1[length - 1] = nums[length - 1];
            dp2[length] = 0;
            dp2[length - 1] = 0;
            for (int i = length - 2; i >= 0; i--) {
                if (i == 0) {
                    dp1[i] = dp1[i + 1];
                    dp2[i] = Math.max(nums[i] + dp2[i + 2], dp2[i + 1]);
                    break;
                }
                dp1[i] = Math.max(nums[i] + dp1[i + 2], dp1[i + 1]);
                dp2[i] = Math.max(nums[i] + dp2[i + 2], dp2[i + 1]);
            }
            return Math.max(dp1[0], dp2[0]);
        }
    }
}
