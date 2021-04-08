public class IsValidBST {
    class Solution {
        public boolean isValidBST(TreeNode root) {
            return recurse(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }
    
        private boolean recurse(TreeNode root, long lower, long upper) {
            if (root == null)
                return true;
            return root.val > lower && root.val < upper && recurse(root.left, lower, root.val) && recurse(root.right, root.val, upper);
        }
    }
}
