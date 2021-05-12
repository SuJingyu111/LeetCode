public class FindMedianSortedArrays {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int length1 = nums1.length;
            int length2 = nums2.length;
            int[] total = new int[length1 + length2];
            int idx = 0;
            for (int num1 : nums1) {
                total[idx++] = num1;
            }
            for (int num2 : nums2) {
                total[idx++] = num2;
            }
            Arrays.sort(total);
            int totalLength = length1 + length2;
            if (totalLength % 2 == 0) {
                //System.out.println("here " + );
                return (double)(total[totalLength / 2 - 1] + total[totalLength / 2]) / 2;
            }
            else {
                return total[totalLength / 2];
            }
        }
    }
}
