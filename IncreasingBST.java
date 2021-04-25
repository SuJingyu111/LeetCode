public class IncreasingBST {
    class Solution {
        public TreeNode increasingBST(TreeNode root) {
            if (root.left == null && root.right == null) {
                return root;
            }
            TreeNode left = null;
            TreeNode right = null;
            if (root.left != null) {  
                left = increasingBST(root.left);
            }
            root.left = null;
            TreeNode cursor = left;
            if (left != null) {
                while (cursor.right != null) {
                    cursor = cursor.right;
                }
                cursor.right = root;
                right = root.right == null ? null : increasingBST(root.right);
                root.right = right;
                return left;
            }
            else {
                right = root.right == null ? null : increasingBST(root.right);
                root.right = right;
                return root;
            }
        }
    }
}
