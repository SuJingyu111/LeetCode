public class PlusOne {
    class Solution {
        public int[] plusOne(int[] digits) {
            int overflow = 1;
            int length = digits.length;
            boolean finished = false;
            for (int i = length - 1; i >= 0; i--) {
                int temp = digits[i] + overflow;
                if (temp >= 10) {
                    digits[i] = temp - 10;
                    overflow = 1;
                }
                else {
                    digits[i] = temp;
                    overflow = 0;
                    finished = true;
                    break;
                }
            }
            if (finished) {
                return digits;
            }
            else {
                int[] res = new int[digits.length + 1];
                for (int i = 1; i < res.length; i++) {
                    res[i] = digits[i - 1];
                }
                res[0] = 1;
                return res;
            }
        }
    }
}
