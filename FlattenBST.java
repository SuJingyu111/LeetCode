public class FlattenBST {
    class Solution {
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            TreeNode tempRight = root.right;
            root.right = root.left;
            root.left = null;
            flatten(root.right);
            while (root.right != null) {
                root = root.right;
            }
            root.right = tempRight;
            flatten(tempRight);
        }
    }
}
