public class MoveZeroes {
    class Solution {
        public void moveZeroes(int[] nums) {
            int length = nums.length;
            int idx = 0;
            int cnt = 0;
            for (int i = 0; i < length; i++) {
                if (nums[i] != 0) {
                    nums[idx++] = nums[i];
                }
                else {
                    cnt++;
                }
            }
            int tail = length - 1;
            while (cnt-- > 0) {
                nums[tail--] = 0;
            }
        }
    }
}
