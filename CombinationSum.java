import java.util.*;

public class CombinationSum {
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
    
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<Integer> candiateList = new LinkedList<>();
           for (int candidate : candidates) {
               candiateList.add(candidate);
           }
            List<Integer> track = new LinkedList<>();
            backtrack(candiateList, target, track);
            return res;
        }
    
        private void backtrack(List<Integer> candiateList, int target, List<Integer> track) {
            if (target == 0) {
                res.add(new LinkedList(track));
                return;
            }
            if (candiateList.isEmpty() || target < 0) {
                return;
            }
            int head = candiateList.get(0);
            candiateList.remove(0);
            backtrack(candiateList, target, track);
            candiateList.add(0, head);
            if (target - head >= 0) {
                track.add(head);
                backtrack(candiateList, target - head, track);
                track.remove(track.size() - 1);
            }
        }
    }
}
