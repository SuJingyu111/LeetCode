public class JudgeSquareSum {
    class Solution {
        public boolean judgeSquareSum(int c) {
            int upper = (int)Math.sqrt(c);
            for (int i = upper; i >= 0; i--) {
                if (i * i == c) {
                    return true;
                }
                int test = (int)Math.sqrt(c - i * i);
                if (test * test == c - i * i) {
                    return true;
                }
            }
            return false;
        }
    }
}
