import java.util.*;

public class Subsets {
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> list = new ArrayList<List<Integer>>();
            if (nums.length == 0) {
                list.add(new ArrayList<Integer>());
                return list;
            }
            List<List<Integer>> tempList = subsets(Arrays.copyOfRange(nums, 0, nums.length - 1));
            for (List<Integer> l : tempList) {
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(nums[nums.length - 1]);
                temp.addAll(l);
                list.add(temp);
            }
            list.addAll(tempList);
            return list;
        }
    }
}
