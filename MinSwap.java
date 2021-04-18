public class MinSwap {
    class Solution {
        public int minSwap(int[] A, int[] B) {
            int length = A.length;
            if (length == 1)
                return 0;
            int prevChangeCnt = 1;
            int prevUnchangeCnt = 0;
            for (int i = 1; i < length; i++) {
                int thisChangeCnt = Integer.MAX_VALUE, thisUnchangeCnt = Integer.MAX_VALUE;
                if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
                    thisChangeCnt = prevChangeCnt + 1;
                    thisUnchangeCnt = prevUnchangeCnt;
                }
                if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
                    thisChangeCnt = Math.min(thisChangeCnt, prevUnchangeCnt + 1);
                    thisUnchangeCnt = Math.min(prevChangeCnt, thisUnchangeCnt);
                }
                prevChangeCnt = thisChangeCnt;
                prevUnchangeCnt = thisUnchangeCnt;
            }
            return Math.min(prevChangeCnt, prevUnchangeCnt);
        }
    }
}
