public class BuildTreeInPost {
    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            int nodeNum = inorder.length;
            if (nodeNum == 0) {
                return null;
            }
            int rootVal = postorder[nodeNum - 1];
            TreeNode root = new TreeNode(rootVal);
            if (nodeNum == 1) {
                return root;
            }
            int rootPos = 0;
            while (inorder[rootPos] != rootVal) {
                rootPos++;
            }
            TreeNode leftTree = construct(inorder, 0, rootPos, postorder, 0, rootPos);
            TreeNode rightTree = construct(inorder, rootPos + 1, nodeNum, postorder, rootPos, nodeNum - 1);
            root.left = leftTree;
            root.right = rightTree;
            return root;
        }
    
        private TreeNode construct(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {
            int nodeNum = iEnd - iStart;
            if (nodeNum == 0) {
                return null;
            }
            int rootVal = postorder[pEnd - 1];
            TreeNode root = new TreeNode(rootVal);
            if (nodeNum == 1) {
                return root;
            }
            int rootPos = iStart;
            while (rootPos < iEnd && inorder[rootPos] != rootVal) {
                rootPos++;
            }
            TreeNode leftTree = construct(inorder, iStart, rootPos, postorder, pStart, pStart + rootPos - iStart);
            TreeNode rightTree = construct(inorder, rootPos + 1, iEnd, postorder, pStart + rootPos - iStart, pEnd - 1);
            root.left = leftTree;
            root.right = rightTree;
            return root;
        }
    }
}
