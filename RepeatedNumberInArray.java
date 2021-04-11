public class RepeatedNumberInArray {
    class Solution {
    
        public int findRepeatNumber(int[] nums) {
            int length = nums.length;
            for (int i = 0; i < length; i++) {
                while (nums[i] != i) {
                    if (nums[nums[i]] == nums[i]) {
                        return nums[i];
                    }
                    else {
                        int temp = nums[nums[i]];
                        nums[nums[i]] = nums[i];
                        nums[i] = temp;
                    }
                }              
            }
            return -1;
        }
    }
}
