public class DecodeXORedPermutation {
    class Solution {
        public int[] decode(int[] encoded) {
            int length = encoded.length;
            int number = length + 1;
            int[] res = new int[number];
            int totalXOR = 0;
            for (int i = 1; i <= number; i++) {
                totalXOR ^= i;
            }
            int codeXOR = 0;
            for (int i = 1; i < length; i+=2) {
                codeXOR ^= encoded[i];
            }
            int first = totalXOR ^ codeXOR;
            res[0] = first;
            for (int i = 1; i < number; i++) {
                res[i] = encoded[i - 1] ^ res[i - 1];
            }
            return res;
        }
    }
}
