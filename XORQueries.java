public class XORQueries {
    class Solution {
        public int[] xorQueries(int[] arr, int[][] queries) {
            int resLength = queries.length;
            int[] res = new int[resLength];
            int length = arr.length;
            int[] store = new int[length];
            store[0] = arr[0];
            for (int i = 1; i <length; i++) {
                store[i] = arr[i] ^ store[i - 1];
            }
            int idx = 0;
            for (int[] query : queries) {
                int start = query[0];
                int end = query[1];
                res[idx++] = store[end] ^ store[start] ^ arr[start];
            }
            return res;
        }
    }
}
