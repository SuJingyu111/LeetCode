public class HammingDistance {
    class Solution {
        public int hammingDistance(int x, int y) {
            int t = x ^ y;
            final int HIGH_BIT = 30;
            int ham_dist = 0;
            for (int i = 0; i <= HIGH_BIT; i++) {
                if (((t >> i) & 1) == 1) {
                    ham_dist++;
                }
            }
            return ham_dist;
        }
    }
}
