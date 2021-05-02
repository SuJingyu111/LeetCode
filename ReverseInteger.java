public class ReverseInteger {
    class Solution {
        public int reverse(int x) {
            String intString = Integer.toString(x);
            int length = intString.length();
            if (length == 1) {
                return x;
            }
            int res = 0;
            boolean negative = intString.charAt(0) == '-';
            for (int i = length - 1; i >= 0; i--) {
                char c = intString.charAt(i);
                if (c == '-') {
                    res *= -1;
                    break;
                }
                else if (!negative && res >= (Integer.MAX_VALUE / 10 + 1)) {
                    return 0;
                }
                else if (negative && i > 0 && res >= (Integer.MAX_VALUE / 10 + 1)) {
                    return 0;
                }
                res *= 10;
                res += c - 48;
            }
            
            return res;
        }
    }
}
