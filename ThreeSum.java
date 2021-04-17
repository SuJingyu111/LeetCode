import java.util.*;

public class ThreeSum {
    class Solution {
    
        public List<List<Integer>> threeSum(int[] nums) {
            int length = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            if (length == 0 || length < 3 || nums[0] > 0 || nums[length - 1] < 0) {
                return res;
            }
            int k = length - 1;
            for (int i = 0; i < k;) {
                for (int j = i + 1; j < k;) {
                    int target = -(nums[i] + nums[j]);
                    List<Integer> thisRes = new ArrayList<>();
                    while (k > j && nums[k] >= target) {
                        int temp = nums[k];
                        if (nums[k] == target) {
                            thisRes.add(nums[i]);
                            thisRes.add(nums[j]);
                            thisRes.add(nums[k]);
                            res.add(thisRes);
                        }
                        while (k >= 0 && nums[k] == temp) {
                            k--;
                        }
                    }
                    int jTemp = nums[j];
                    while (j < length && nums[j] == jTemp) {
                        j++;
                    }
                }
                k = length - 1;
                int iTemp = nums[i];
                while (i < length && nums[i] == iTemp) {
                    i++;
                }
            }
            return res;
        }
    }
}
