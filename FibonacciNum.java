public class FibonacciNum {
    class Solution {
        public int fib(int n) {
            if (n < 2)
                return n;
            int p = 0;
            int q = 1;
            for (int i = 2; i <= n; i++) {
                int temp = q;
                q = p + q;
                p = temp;
            }
            return q;
        }
    }
}
