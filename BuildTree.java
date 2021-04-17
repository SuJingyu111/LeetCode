import java.util.*;

public class BuildTree {
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0) 
                return null;
            if (preorder.length == 1)
                return new TreeNode(preorder[0]);
            TreeNode root = new TreeNode(preorder[0]);
            int pos = 0;
            while (inorder[pos] != root.val) {
                pos++;
            }
            TreeNode left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + pos), Arrays.copyOfRange(inorder, 0, pos));
            TreeNode right = buildTree(Arrays.copyOfRange(preorder, 1 + pos, preorder.length), Arrays.copyOfRange(inorder, pos + 1, inorder.length));
            root.left = left;
            root.right = right;
            return root;
        }
    }
}
