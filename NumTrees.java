public class NumTrees {
    class Solution {
        public int numTrees(int n) {
            if (n <= 1) {
                return 1;
            }
            int num = 0;
            for (int i = 1; i <= n; i++) {
                int leftNum = numTrees(i - 1);
                int rightNum = numTrees(n - i);
                num += leftNum * rightNum;
            }
            return num;
        }
    }
}
