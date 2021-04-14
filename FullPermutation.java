import java.util.*;

public class FullPermutation {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> resList = new ArrayList<List<Integer>>();
            if (nums.length == 0) {
                return resList;
            }
            if (nums.length == 1) {
                List<Integer> newList = new ArrayList<>();
                newList.add(nums[0]);
                resList.add(newList);
                return resList;
            }
            List<List<Integer>> subList = permute(Arrays.copyOfRange(nums, 1, nums.length));
            int listSize = subList.get(0).size();
            for (List<Integer> list : subList) {
                for (int i = 0; i <= listSize; i++) {
                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(i, nums[0]);
                    resList.add(newList);
                }
            }
            return resList;
        }
    }
}
