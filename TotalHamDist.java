public class TotalHamDist {
    class Solution {
        public int totalHammingDistance(int[] nums) {
            int len = nums.length;
            final int HIGH_BIT = 30;
            int res = 0;
            for (int i = HIGH_BIT; i >= 0; i--) {
                int zeroNum = 0;
                for (int num : nums) {
                    int bit = (num >> i) & 1;
                    if (bit == 0) {
                        zeroNum++;
                    }
                }
                res += zeroNum * (len - zeroNum);
            }
            return res;
        }
    }
}
