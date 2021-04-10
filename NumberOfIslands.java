public class NumberOfIslands {
    class Solution {
        public int numIslands(char[][] grid) {
            int res = 0;
            int m = grid.length;
            int n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        res += 1;
                        recurseHelper(i, j, m, n, grid);
                    }
                }
            }
            return res;
        }
    
        private void recurseHelper(int i, int j, int m, int n, char[][] grid) {
            grid[i][j] = '2';
            if (i + 1 < m && grid[i + 1][j] == '1') {
                recurseHelper(i + 1, j, m, n, grid);
            }
            if (j + 1 < n && grid[i][j + 1] == '1') {
                recurseHelper(i, j + 1, m, n, grid);
            }
            if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                recurseHelper(i - 1, j, m, n, grid);
            }
            if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                recurseHelper(i, j - 1, m, n, grid);
            }
        }
    }
}
