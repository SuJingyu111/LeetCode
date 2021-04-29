public class HasPathSum {
    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            int sum = 0;
            if (root == null) {
                return false;
            }
            return dfs(root, targetSum, sum);
        }
    
        private boolean dfs(TreeNode root, int targetSum, int sum) {
            boolean res = false;
            if ((root.left == null && root.right == null) && root.val + sum == targetSum) {
                return true;
            }
            else {
                if (root.left != null) {
                    res = res || dfs(root.left, targetSum, sum + root.val);
                }
                if (root.right != null) {
                    res = res || dfs(root.right, targetSum, sum + root.val);
                }
            }
            return res;
        }
    }
}
