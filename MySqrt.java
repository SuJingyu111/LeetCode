public class MySqrt {
    class Solution {
        public int mySqrt(int x) {
            if (x == 0 || x == 1) {
                return x;
            }
            int left = 0;
            int right = x;
            while (left <= right) {
                int res = (left + right) / 2;
                //System.out.println(res);
                if ( (long)res * res > x)
                    right = res - 1;
                else if ( (long)res * res < x) {
                    left = res + 1;
                }
                else {
                    return res;
                }
            }
            return right;
        }
    }
}
