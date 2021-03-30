public class RemoveDuplicates {
    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0 || nums.length == 1)
                return nums.length;
            int index = 0;
            int cnt = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[index]) 
                    continue;
                else {
                    nums[++index] = nums[i];
                    cnt++;
                }
            }
            return cnt;
        }
    }
}
