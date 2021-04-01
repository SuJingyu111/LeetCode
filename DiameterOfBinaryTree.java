public class DiameterOfBinaryTree {
    class Solution {
        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null)
                return 0;
            if (root.left == null)
                return Math.max(diameterOfBinaryTree(root.right), 1 + height(root.right));
            if (root.right == null) {
                return Math.max(diameterOfBinaryTree(root.left), 1 + height(root.left));
            }
            return Math.max(Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)),
                                1 + height(root.left) + 1 +  height(root.right) );
            
        }
    
        private int height(TreeNode root) {
            if (root == null)
                return -1;
            if (root.left == null) {
                return 1 + height(root.right);
            }
            if (root.right == null)
                return 1 + height(root.left);
            return Math.max(1 + height(root.left),  1 + height(root.right));
        }
    }

    class goodSolution {
        int ans;
        public int diameterOfBinaryTree(TreeNode root) {
            ans = 1;
            depth(root);
            return ans - 1;
        }
        public int depth(TreeNode node) {
            if (node == null) {
                return 0; // 访问到空节点了，返回0
            }
            int L = depth(node.left); // 左儿子为根的子树的深度
            int R = depth(node.right); // 右儿子为根的子树的深度
            ans = Math.max(ans, L+R+1); // 计算d_node即L+R+1 并更新ans
            return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
        }
    }
}
