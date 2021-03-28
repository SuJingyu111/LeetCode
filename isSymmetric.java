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

    class RecursiveSolution {
        List<Integer> leftList = new ArrayList<Integer>();
        List<Integer> rightList = new ArrayList<Integer>();
        public boolean isSymmetric(TreeNode root) {
            if (root.left == null && root.right == null)
                return true;
            if ( (root.left == null && root.right != null) || (root.left != null && root.right == null) )
                return false;
            leftDfs(root.left);
            rightDfs(root.right);
            if (rightList.size() != leftList.size())
                return false;
            for (int i = 0; i < leftList.size(); i++) {
                if (leftList.get(i) != rightList.get(i))
                    return false;
            }
            return true;
        }

        private void leftDfs(TreeNode root) {
            leftList.add(root.val);
            if (root.left != null) {
                leftDfs(root.left);
            }
            else if (root.right != null) 
                leftList.add(null);
            if (root.right != null) {
                leftDfs(root.right);
            }
            else if (root.left != null)
                leftList.add(null);
        }

        private void rightDfs(TreeNode root) {
            rightList.add(root.val);
            if (root.right != null) {
                rightDfs(root.right);
            }
            else if (root.left != null)
                rightList.add(null);
            if (root.left != null) {
                rightDfs(root.left);
            }
            else if (root.right != null) 
                rightList.add(null);
        }
    }
}
