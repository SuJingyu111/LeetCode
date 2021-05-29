public class IsPowerOfTwo {
    class Solution {
        public boolean isPowerOfTwo(int n) {
            int oneCnt = 0;
            final int HIGH_BIT = 31;
            for (int i = HIGH_BIT; i >= 0; i--) {
                int bit = (n >> i) & 1;
                if (bit == 1) {
                    if (i == HIGH_BIT) {
                        return false;
                    }
                    else {
                        oneCnt++;
                    }
                }
                if (oneCnt >= 2) {
                    break;
                }
            }
            if (oneCnt != 1) {
                return false;
            }
            return true;
        }
    }
}
