import java.util.*;

public class ContainsNearbyDuplicate {
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Set<Integer> set = new HashSet<Integer>();
            int lastIdx = 0;
            for (int i : nums){
                if (set.size() == k + 1) {
                    set.remove(nums[lastIdx++]);
                }
                if (!set.add(i))
                    return true;
            }
            return false;
        }
    }
}
