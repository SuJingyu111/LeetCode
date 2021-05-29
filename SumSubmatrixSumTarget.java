public class SumSubmatrixSumTarget {
    class Solution {
        public int numSubmatrixSumTarget(int[][] matrix, int target) {
            int rowNum = matrix.length;
            int colNum = matrix[0].length;
            int[][] prefixSum = new int[rowNum + 1][colNum + 1];
            int cnt = 0;
            for (int i = 1; i <= rowNum; i++) {
                for (int j = 1; j <= colNum; j++) {
                    prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
    
            for (int i = 1; i <= rowNum; i++) {
                for (int j = 1; j <= colNum; j++) {
                    for (int k = i; k <= rowNum; k++) {
                        for (int ll = j; ll <= colNum; ll++) {
                            int thisSum = prefixSum[k][ll] - prefixSum[i - 1][ll] - prefixSum[k][j - 1] + prefixSum[i - 1][j - 1];
                            if (thisSum == target) {
                                cnt++;
                            }
                        }
                    }
                }
            }
            return cnt;
        }
    }
}
