import java.util.*;

public class TopKFrequent {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            int length = nums.length;
            List<List<Integer>> numIndexList = new ArrayList<List<Integer>>();
            for (int i = 0; i <= length; i++) {
                numIndexList.add(new ArrayList<Integer>());
            }
            Arrays.sort(nums);
            int idx = 0;
            int cnt = 0;
            int record = 0;
            while (idx < length) {
                while (idx < length && nums[idx] == nums[record]) {
                    idx += 1;
                    cnt += 1;
                }
                numIndexList.get(cnt).add(record);
                cnt = 0;
                record = idx;
            }
            int[] res = new int[k];
            int resIdx = 0;
            for (int i = length; i >= 0; i--) {
                List<Integer> list = numIndexList.get(i);
                for (int index : list) {
                    res[resIdx++] = nums[index];
                }
                if (resIdx >= k)
                    break;
            }
            return res;
        }
    }
}
