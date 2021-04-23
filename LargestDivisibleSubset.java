public class LargestDivisibleSubset {
    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            Arrays.sort(nums);
            int length = nums.length;
            int[] dp = new int[length];
            Arrays.fill(dp, 1);
            //System.out.println(Arrays.toString(dp));
            for (int i = 0; i < length; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] % nums[j] == 0) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        //System.out.println(i + " " + j + " " + Arrays.toString(dp));
                    }
                    //System.out.println(i + " " + j + " " + Arrays.toString(dp));
                }
            }
            //System.out.println(Arrays.toString(dp));
            int maxPos = 0;
            for (int i = 0; i < length; i++) {
                if (dp[i] >= dp[maxPos]) {
                    maxPos = i;
                }
            }
            List<Integer> res = new ArrayList<Integer>();
            int maxNum = dp[maxPos];
            int base = nums[maxPos];
            for (int i = maxPos; i >= 0; i--) {
                if (dp[i] == maxNum && base % nums[i] == 0) {
                    maxNum--;
                    base = nums[i];
                    res.add(0, nums[i]);
                }
            }
            return res;
        }
    }
}
