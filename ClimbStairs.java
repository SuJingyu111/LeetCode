public class ClimbStairs {
        public int climbStairs(int n) {
            if (n <= 2) 
                return n;
            int cnt = 2;
            int i = 1;
            for (int k = 3; k <= n; k++) {
                int temp = cnt;
                cnt += i;
                i = temp;
            }
            return cnt;
        }
}
