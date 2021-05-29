import java.util.*;

public class NQueens {
    class Solution {
        List<List<String>> res = new LinkedList<>();
        int bSize;
        public List<List<String>> solveNQueens(int n) {
            bSize = n;
            List<String> board = new ArrayList<>(Collections.nCopies(n, String.join("", Collections.nCopies(n, "."))));
            backtrack(board, 0);
            return res;
        }
    
        private void backtrack(List<String> board, int row) {
            if (row == board.size()) {
                res.add(new ArrayList<>(board));
                return;
            }
            for (int col = 0; col < bSize; col++) {
                if (isValid(board, row, col)) {
                    String origRow = board.get(row);
                    StringBuilder tempSB = new StringBuilder(origRow);
                    tempSB.replace(col, col + 1, "Q");
                    board.set(row, tempSB.toString());
                    backtrack(board, row + 1);
                    board.set(row, origRow);
                }
            }
        }
    
        private boolean isValid(List<String> board, int row, int col) {
            for (int i = 0; i < row; i++) {
                if (board.get(i).charAt(col) == 'Q') {
                    return false;
                }
            }
            for (int i = row - 1, j = col + 1; i >= 0 && j < bSize; i--, j++) {
                if (board.get(i).charAt(j) == 'Q') {
                    return false;
                }
            }
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (board.get(i).charAt(j) == 'Q') {
                    return false;
                }
            }
            return true;
        }   
    }
}
