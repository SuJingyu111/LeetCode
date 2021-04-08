import java.util.*;

public class FindMinInRotatedSortedArray {
    class Solution {
        public int findMin(int[] nums) {
            int length = nums.length;
            if (length == 1)
                return nums[0];
            int l = 0;
            int r = length - 1;
            while (l < r) {
                int mid = (l + r + 1) / 2;            
                System.out.println(l + " " + mid + " " + r);
                if (mid - 1 >= 0 && nums[mid - 1] > nums[mid])
                    return nums[mid];
                if (nums[mid] > nums[length - 1])
                    l = mid + 1;
                else 
                    r = mid - 1;
            }
            return nums[l];
        }
    }

    class NaiveButBetterSolution {
        public int findMin(int[] nums) {
            int min = 5001;
            for (int i : nums) {
                if (i < min)
                    min = i;
            }
            return min;
        }
    }

    class UseUtilSolution {
        public int findMin(int[] nums) {
            Arrays.sort(nums);
            return nums[0];
        }
    }
}
