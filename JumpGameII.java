public class JumpGameII {
    class Solution {
        public int jump(int[] nums) {
            int currentPos = 0, stepCnt = 0, len = nums.length;
            if (len == 1) {
                return 0;
            }
            while (currentPos < len) {
                int nextPos = currentPos;
                int nextRate = currentPos + nums[currentPos];
                for (int i = currentPos + 1; i <= currentPos + nums[currentPos]; i++) {
                    if (i >= len - 1) {
                        return stepCnt + 1;
                    }
                    nextPos = nextRate > i + nums[i] ? nextPos : i;
                    nextRate = nextPos + nums[nextPos];
                }
                stepCnt += 1;
                currentPos = nextPos;
            }
            return stepCnt;
        }
    }
}
