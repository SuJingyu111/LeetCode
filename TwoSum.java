public class TwoSum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Set<Integer> set = new HashSet<Integer>();
            int[] res = new int[2];
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    continue;
                }
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        //System.out.println(i + " " + j);
                        res[0] = i;
                        res[1] = j;
                        return res;
                    }
                }
                set.add(nums[i]);
            }
            return res;
        }
    }
}
