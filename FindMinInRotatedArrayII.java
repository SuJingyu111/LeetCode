public class FindMinInRotatedArrayII {
    class Solution {
        public int findMin(int[] nums) {
            int length = nums.length;
            if (length == 1)
                return nums[0];
            int l = 0;
            int r = length - 1;
            while (l < r) {
                int mid = (l + r + 1) / 2;         
                if (mid - 1 >= 0 && nums[mid - 1] > nums[mid]) 
                    return nums[mid];
                if (nums[mid] > nums[r])
                    l = mid + 1;
                else if (nums[mid] < nums[r])
                    r = mid - 1;
                else 
                    r--;
            }
            return nums[l];
        }
    }
}
