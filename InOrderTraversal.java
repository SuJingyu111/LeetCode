import java.util.*;

public class InOrderTraversal {
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<Integer>();
            if (root == null) {
                return result;
            }
            else if (root.left == null && root.right == null) {
                result.add(root.val);
                return result;
            }
            result.addAll(inorderTraversal(root.left));
            result.add(root.val);
            result.addAll(inorderTraversal(root.right));
            return result;
        }

        public List<Integer> inorderTraversalIterative(TreeNode root) {
            List<Integer> result = new ArrayList<Integer>();
            Deque<TreeNode> nodeStack = new LinkedList<TreeNode>();
            while (root != null || !nodeStack.isEmpty()) {
                while (root != null) {
                    nodeStack.push(root);
                    root = root.left;
                }
                root = nodeStack.pop();
                result.add(root.val);
                root = root.right;
            }
            return result;
        }
    }
}
