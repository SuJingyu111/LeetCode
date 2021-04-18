public class PrintMatrixClockWise {
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            int row = matrix.length;
            if (row == 0) {
                return new int[0];
            }
            int column = matrix[0].length;
            if (column == 0) {
                return new int[0];
            }
            int eleNum = row * column;
            int[] res = new int[eleNum];
            int layer = 0;
            int cnt = 0;
            while (cnt < eleNum) {
                for (int i = layer; i < column - layer; i++) {
                    res[cnt++] = matrix[layer][i];
                }
                //System.out.println(Arrays.toString(res));
                if (cnt == eleNum) 
                    break;
                for (int j = layer + 1; j < row - layer; j++) {
                    res[cnt++] = matrix[j][column - layer - 1];
                }
                //System.out.println(Arrays.toString(res));
                if (cnt == eleNum) 
                    break;
                for (int i = column - layer - 2; i >= layer; i--) {
                    res[cnt++] = matrix[row - layer - 1][i];
                }
                //System.out.println(Arrays.toString(res));
                if (cnt == eleNum) 
                    break;
                for (int j = row - layer - 2; j > layer; j--) {
                    res[cnt++] = matrix[j][layer];
                }
                layer += 1;
                //System.out.println(Arrays.toString(res));
            }
            return res;
        }
    }
}
