public class Rob {
    class Solution {
        public int rob(int[] nums) {
            int length = nums.length;
            int[] dp1 = new int[length + 1];
            dp1[length] = 0;
            dp1[length - 1] = nums[length - 1];
            for (int i = length - 2; i >= 0; i--) {
                dp1[i] = Math.max(nums[i] + dp1[i + 2], dp1[i + 1]);
            }
            return dp1[0];
        }
    }
}
