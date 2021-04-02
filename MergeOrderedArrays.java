public class MergeOrderedArrays {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            if (m == 0) {
                for (int i = 0; i < n; i++) {
                    nums1[i] = nums2[i];
                }
                return;
            }
            if (n == 0)
                return;
    
            int oneMax = nums1[m - 1];
            int i = n - 1;
            while (i >= 0 && nums2[i] >= oneMax) {
                nums1[m + i] = nums2[i--];
            }
            if (i < 0)
                return;
            else {
                int index = m + i;
                int j = m - 1;
                while (i >= 0 && index >= 0) {
                    if (j >= 0 && nums1[j] > nums2[i]) {
                        nums1[index--] = nums1[j];
                        nums1[j] = 0;
                        j--;
                    }
                    else {
                        nums1[index--] = nums2[i--];
                    }
                }
            }
        }
    }
}
