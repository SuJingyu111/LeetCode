public class RotateFigure {
    class Solution {
        public void rotate(int[][] matrix) {
            int thickness = matrix.length;
            int layer = 0;
            while (thickness - 2 >= 0) {
                for (int i = 0; i < thickness - 1; i++) {
                    System.out.println(i);
                    int temp = matrix[layer + i][layer + thickness - 1];
                    matrix[layer + i][layer + thickness - 1] = matrix[layer][layer + i];
                    int temp2 = matrix[layer + thickness - 1][layer + thickness - 1 - i];
                    matrix[layer + thickness - 1][layer + thickness - 1 - i] = temp;
                    temp = matrix[layer + thickness - 1 - i][layer];
                    matrix[layer + thickness - 1 - i][layer] = temp2;
                    matrix[layer][layer + i] = temp;     
                }
                layer += 1;
                thickness -= 2;     
            }
        }
    }
}
