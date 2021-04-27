public class DistributeCandy {
    class Solution {
        public int candy(int[] ratings) {
            int length = ratings.length;
            int leftRes = length, rightRes = length;
            int[] leftCandyNum = new int[length];
            int[] rightCandyNum = new int[length];        
            Arrays.fill(leftCandyNum, 1);
            Arrays.fill(rightCandyNum, 1);
            for (int i = 1; i < length; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    leftCandyNum[i] = leftCandyNum[i - 1] + 1;
                }
            }
            for (int j = length - 2; j >= 0; j--) {
                if (ratings[j] > ratings[j + 1]) {
                    rightCandyNum[j] = rightCandyNum[j + 1] + 1;
                }
            }
            int res = 0;
            for (int k = 0; k < length; k++) {
                res += Math.max(leftCandyNum[k], rightCandyNum[k]);
            }
            return res;
        }
    }
}
