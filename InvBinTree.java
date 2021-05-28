public class InvBinTree {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return root;
            }
            else {
                TreeNode tempLeft = root.left;
                root.left = root.right;
                root.right = tempLeft;
                invertTree(root.left);
                invertTree(root.right);
            }
            return root;
        }
    }
}
