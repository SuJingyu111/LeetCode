public class DecodeXORedArray {
    class Solution {
        public int[] decode(int[] encoded, int first) {
            int length = encoded.length;
            int[] res = new int[length + 1];
            res[0] = first;
            for (int i = 0; i < length; i++) {
                res[i + 1] = encoded[i] ^ res[i];
            }
            return res;
        }
    }
}
