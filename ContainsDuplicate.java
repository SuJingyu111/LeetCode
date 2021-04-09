import java.util.*;

public class ContainsDuplicate {

    class Solution {
        public boolean containsDuplicate(int[] nums) {
            if (nums.length == 0 || nums.length == 1)
                return false;
            Arrays.sort(nums);
            int prev = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == prev)
                    return true;
                prev = nums[i];
            }
            return false;
        }
    }

    class SetSolution {
        public boolean containsDuplicate(int[] nums) {
            if (nums.length == 0 || nums.length == 1)
                return false;
            Set<Integer> set = new HashSet<Integer>();
            for (int i : nums) {
                if (!set.add(i))
                    return true;
            }
            return false;
        }
    }
}
