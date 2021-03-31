public class SearchMatrix {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            boolean res = false;
            int i;
            int rowLen = matrix[0].length;
            for (i = 0; i < matrix.length; i++){
                if (matrix[i][0] <= target && matrix[i][rowLen - 1] >= target) {
                    if (matrix[i][0] == target || matrix[i][rowLen - 1] == target)
                        return true;
                    res = true;
                    break;
                }
            }
            if (!res)
                return false;
            res = false;
            for (int j = 0; j < rowLen; j++) {
                if (matrix[i][j] == target)
                    return true;
            }
            return false;
        }
    }
}
