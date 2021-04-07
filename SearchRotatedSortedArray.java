public class SearchRotatedSortedArray {
    class Solution {
        public int search(int[] nums, int target) {
            if (nums.length == 0)
                return -1;
            if (nums.length == 1) 
                return nums[0] == target ? 0 : -1;
            int l = 0;
            int r = nums.length - 1;
            while (l <= r) {
                int mid = (l + r + 1) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
    
                boolean leftInOrder = true;
                for (int i = l; i < mid; i++) {
                    int leftInt = nums[i];                
                    if (leftInt == target)
                        return i;
                    if (leftInt > nums[i + 1]) {
                        leftInOrder = false;
                        break;
                    }
                }
                if (leftInOrder) {
                    if (mid == 0) 
                        return -1;
                    if (nums[l] <= target && nums[mid - 1] >= target) {
                        r = mid - 1;
                    }
                    else {
                        l = mid + 1;
                    }
                }
                else {
                    if (mid == nums.length - 1)
                        return -1;
                    if (nums[mid + 1] <= target && nums[r] >= target) {
                        l = mid + 1;
                    }
                    else {
                        r = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
}
