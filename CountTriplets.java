public class CountTriplets {
    class Solution {
        public int countTriplets(int[] arr) {
            int length = arr.length;
            int[] XORVal = new int[length + 1];
            XORVal[0] = 0;
            for (int i = 1; i < length + 1; i++) {
                XORVal[i] = arr[i - 1] ^ XORVal[i - 1];
            }
            int cnt = 0;
            for (int i = 1; i < length; i++) {
                for (int j = i + 1; j < length + 1; j++) {
                    for (int k = j; k < length + 1; k++) {
                        if ((XORVal[j - 1] ^ XORVal[i - 1]) == (XORVal[k] ^ XORVal[j - 1])) {
                            //System.out.println(i + " " + j + " " + k);
                            cnt += 1;
                        }
                    }
                }
            }
            return cnt;
        }
    }
}
