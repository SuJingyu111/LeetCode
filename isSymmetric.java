import java.util.*;

public class isSymmetric {
    class Solution {
        Deque<TreeNode> leftStack = new LinkedList<TreeNode>();
        Deque<TreeNode> rightStack = new LinkedList<TreeNode>();
    
        public boolean isSymmetric(TreeNode root) {
            if (root.left == null && root.right == null)
                return true;
            if ( (root.left == null && root.right != null) || (root.left != null && root.right == null) )
                return false;
            leftStack.add(root.left);
            rightStack.add(root.right);
            while (!leftStack.isEmpty() && !rightStack.isEmpty()) {
                TreeNode leftNode = leftStack.poll();
                TreeNode rightNode = rightStack.poll();
                if (leftNode == null) {
                    if (rightNode != null)
                        return false;
                    else
                        continue;
                }
                else if (rightNode == null || rightNode.val != leftNode.val)
                    return false;
                else {
                    leftStack.add(leftNode.left);
                    leftStack.add(leftNode.right);
                    rightStack.add(rightNode.right);
                    rightStack.add(rightNode.left);
                }
            }
            return true;
        }
    }
}
