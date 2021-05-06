public class XOROperation {
    class Solution {
        public int xorOperation(int n, int start) {
            if (n == 1)
                return start;
            int res = start;
            for (int i = 1; i < n; i++) {
                int next = start + 2 * i;
                res = next ^ res;
            }
            return res;
        }
    }
}
