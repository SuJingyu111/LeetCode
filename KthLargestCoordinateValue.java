import java.util.*;

public class KthLargestCoordinateValue {
    class Solution {
        public int kthLargestValue(int[][] matrix, int k) {
            int row = matrix.length;
            int column = matrix[0].length;
            int[][] xorVal = new int[row][column];
            xorVal[0][0] = matrix[0][0];
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
            pq.offer(xorVal[0][0]);
            for (int i = 1; i < column; i++) {
                xorVal[0][i] = matrix[0][i] ^ xorVal[0][i - 1];
                if (pq.size() != k) {
                    pq.offer(xorVal[0][i]);
                }
                else if (xorVal[0][i] > pq.peek()) {
                    pq.poll();
                    pq.offer(xorVal[0][i]);
                }
            }
            for (int j = 1; j < row; j++) {
                xorVal[j][0] = matrix[j][0] ^ xorVal[j - 1][0];
                if (pq.size() != k) {
                    pq.offer(xorVal[j][0]);
                }
                else if (xorVal[j][0] > pq.peek()) {
                    pq.poll();
                    pq.offer(xorVal[j][0]);
                }
            }
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < column; j++) {
                    xorVal[i][j] = xorVal[i - 1][j] ^ xorVal[i][j - 1] ^ xorVal[i - 1][j - 1] ^ matrix[i][j];
                    if (pq.size() != k) {
                        pq.offer(xorVal[i][j]);
                    }
                    else if (xorVal[i][j] > pq.peek()) {
                        pq.poll();
                        pq.offer(xorVal[i][j]);
                    }
                }
            }
            return pq.peek();
        }
    }
}
