public class MinTimeRequired {
    class Solution {
        public int minimumTimeRequired(int[] jobs, int k) {
            Arrays.sort(jobs);
            int length = jobs.length;
            int left = jobs[length - 1];
            int right = 0;
            for (int jobTime : jobs) {
                right += jobTime;
            }
            if(jobs.length == k) return left;
            if(k == 1) return right;
            int res = 0;
            while (left < right) {
                //System.out.println("----------------------");
                //System.out.println(left + " " + right);
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
            int[] workLoad = new int[k];
            workLoad[0] = jobs[jobs.length - 1];
            return backTrack(sum, jobs, jobs.length - 2, workLoad);
        }
    
        private boolean backTrack(int sum, int[] jobs, int jobIdx, int[] workLoad) {
            if (jobIdx < 0) {
                return true;
            }
            int nextJobTime = jobs[jobIdx];
            for (int i = 0; i < workLoad.length; i++) {
                if (workLoad[i] + nextJobTime <= sum) {
                    int tempWL = workLoad[i];
                    workLoad[i] += nextJobTime;
                    if (backTrack(sum, jobs, jobIdx - 1, workLoad)) {
                        return true;
                    }
                    workLoad[i] = tempWL;
                }
                if (workLoad[i] == 0 || workLoad[i] + nextJobTime == sum) {
                    break;
                }
            }
            return false;
        }
    }
}
