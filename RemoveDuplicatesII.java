public class RemoveDuplicatesII {
    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length <= 2)
                return nums.length;
    
            int dupCount = 1;
            int curPos = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[curPos]) {
                    dupCount += 1;
                }
                else {
                    dupCount = 1;
                }
                if (dupCount > 2) {
                    continue;
                }
                else {
                    nums[curPos + 1] = nums[i];
                    curPos++;
                }
            }
            return curPos + 1;
        }
    }
}
