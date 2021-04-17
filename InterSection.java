import java.util.*;

public class InterSection {
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> smallSet = new HashSet<>();;
            int[] s, l;
            if (nums1.length <= nums2.length) {           
                s = nums1;
                l = nums2;
            }
            else {
                s = nums2;
                l = nums1;
            }
            for (int i : s) {
                smallSet.add(i);
            }
            Set<Integer> resSet = new HashSet<>();
            for (int i : l) {
                if (smallSet.contains(i)) {
                    resSet.add(i);
                }
            }
            int[] res = new int[resSet.size()];
            int idx = 0;
            for (int i : resSet) {
                res[idx++] = i;
            }
            return res;
        }
    }
}
