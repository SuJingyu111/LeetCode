public class MinDays {
    class Solution {
        public int minDays(int[] bloomDay, int m, int k) {
            int flowerNum = bloomDay.length;
            if (flowerNum < m * k) {
                return -1;
            }
            int min = Integer.MAX_VALUE, max = 0;
            for (int i = 0; i < flowerNum; i++) {
                min = Math.min(min, bloomDay[i]);
                max = Math.max(max, bloomDay[i]);
            }
            while (min < max) {
                int mid = (min + max) / 2;
                if (isValid(mid, bloomDay, m, k)) {
                    max = mid;
                }
                else {
                    min = mid + 1;
                }
            }
            return min;
        }
    
        private boolean isValid(int day, int[] bloomDay, int m, int k) {
            int bunchCnt = 0;
            int flowerCnt = 0;
            int idx = 0;
            while (idx < bloomDay.length) {
                if (bloomDay[idx] > day) {
                    flowerCnt = 0;
                }
                else if (flowerCnt + 1 == k) {
                    bunchCnt += 1;
                    flowerCnt = 0;
                }
                else {
                    flowerCnt += 1;
                }
                idx++;
            }
            return bunchCnt >= m;
        }
    }
}
