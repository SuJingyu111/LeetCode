public class SearchRotatedSortedArrayII {
    class Solution {
        public boolean search(int[] nums, int target) {
            if (nums.length == 0)
                return true;
            if (nums.length == 1) 
                return nums[0] == target ? true : false;
            int l = 0;
            int r = nums.length - 1;
            while (l <= r) {
                int mid = (l + r + 1) / 2;
                if (nums[mid] == target) {
                    return true;
                }
        
                boolean leftInOrder = true;
                for (int i = l; i < mid; i++) {
                    int leftInt = nums[i];                
                    if (leftInt == target)
                        return true;
                    if (leftInt > nums[i + 1]) {
                        leftInOrder = false;
                        break;
                    }
                }
                if (leftInOrder) {
                    if (mid == 0) 
                        return false;
                    if (nums[l] <= target && nums[mid - 1] >= target) {
                        r = mid - 1;
                        while (r - 1 >= 0 && nums[r - 1] == nums[r])
                            r -= 1;
                    }
                    else {
                        l = mid + 1;
                        while (l + 1 < nums.length && nums[l + 1] == nums[l])
                            l += 1;
                    }
                }
                else {
                    if (mid == nums.length - 1)
                        return false;
                    if (nums[mid + 1] <= target && nums[r] >= target) {
                        l = mid + 1;
                        while (l + 1 < nums.length && nums[l + 1] == nums[l])
                            l += 1;
                    }
                    else {
                        r = mid - 1;
                        while (r - 1 >= 0 && nums[r - 1] == nums[r])
                            r -= 1;
                    }
                }
            }
            return false;
        }
    }
}
