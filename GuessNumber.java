public class GuessNumber {
    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            Long left = 1l;
            Long right = (long)n;
            while (left < right) {
                Long mid = (left + right) / 2;
                int judge = guess(mid.intValue());
                if (judge == 0) {
                    return mid.intValue();
                }
                else if (judge == 1) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
            return left.intValue();
        }
    }
}
