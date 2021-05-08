public class SplitArray {
    class Solution {
        public int splitArray(int[] jobs, int k) {
            int length = jobs.length;
            int left = 1;
            int right = 0;
            for (int jobTime : jobs) {
                if (jobTime > left)
                    left = jobTime;
                right += jobTime;
            }
            int res = right;
            while (left < right) {
                int mid = (left + right) / 2;
                if (isValid(mid, jobs, k)) {
                    res = mid;
                    right = mid;
                }
                else {
                    left = mid + 1;
                }
            }
            return res;
        }
    
        private boolean isValid(int sum, int[] jobs, int k) {
            int cnt = 1;
            int jobSum = 0;
            for (int jobTime : jobs) {
                if (jobTime > sum) {
                    return false;
                }
                jobSum += jobTime;
                if (jobSum > sum) {
                    cnt += 1;
                    jobSum = jobTime;
                }
            }
            //System.out.println(cnt + " " + sum + " " + jobSum);
            if (cnt <= k) {
                return true;
            }
            return false;
        }
    }
}
