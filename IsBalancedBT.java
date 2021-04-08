public class IsBalancedBT {
    class Solution {
        boolean res = true;
    
        public boolean isBalanced(TreeNode root) {
            if (root == null)
                return true;
            if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
                return false;
            }
            return res;
        }
    
        private int getHeight(TreeNode root) {
            if (root == null)
                return 0;
            int left = getHeight(root.left);
            int right = getHeight(root.right);
            if (Math.abs(left - right) > 1) {
                res = false;
            }
            return 1 + Math.max(left, right);
        }
    }
}
