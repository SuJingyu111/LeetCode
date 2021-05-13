public class FindKthLargest {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                min = Math.min(num, min);
                max = Math.max(num, max);
            }
            int[] bucket = new int[max - min + 1];
            for (int num : nums) {
                bucket[num - min] += 1;
            }
            int cnt = 0;
            //System.out.println(bucket.length + " " + (max - min));
            for (int i = max - min; i >= 0; i--) {
                cnt += bucket[i];
                if (cnt >= k) {
                    return min + i;
                }
            }
            return 0;
        }
    }
}
