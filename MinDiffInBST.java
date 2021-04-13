public class MinDiffInBST {
    class Solution {
        public int minDiffInBST(TreeNode root) {
            if (root.left != null) {
                int leftMin = minDiffInBST(root.left);
                int subLeft = root.val - TreeMax(root.left);
                if (root.right != null) {
                    int rightMin = minDiffInBST(root.right);
                    return Math.min(Math.min(rightMin, leftMin), Math.min(subLeft, TreeMin(root.right) - root.val));
                }
                else {
                    return Math.min(leftMin, subLeft);
                }
            }
            else {
                if (root.right != null) {
                    int rightMin = minDiffInBST(root.right);
                    return Math.min(rightMin, TreeMin(root.right) - root.val);
                }
                else
                    return Integer.MAX_VALUE;
            }
        }
    
        private int TreeMax(TreeNode root) {
            while (root.right != null) {
                root = root.right;
            }
            return root.val;
        }
    
        private int TreeMin(TreeNode root) {
            while (root.left != null) {
                root = root.left;
            }
            return root.val;
        }
    }

    class InOrderTraverseSolution {
        TreeNode prevNode = null;
        int res = Integer.MAX_VALUE;
    
        public int minDiffInBST(TreeNode root) {
            inOrderTraverse(root);
            return res;
        }
    
        private void inOrderTraverse(TreeNode root) {
            if (root == null) {
                return;
            }
            inOrderTraverse(root.left);
            if (prevNode != null) {
                res = Math.min(root.val - prevNode.val, res);
            }
            prevNode = root;
            inOrderTraverse(root.right);
        }
    }
}
