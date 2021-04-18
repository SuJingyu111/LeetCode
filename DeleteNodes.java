import java.util.*;

public class DeleteNodes {
    class Solution {
        List<TreeNode> res;
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            res = new ArrayList<TreeNode>();
            if (root == null)
                return res;
            res.add(root);
            Set<Integer> deleteSet = new HashSet<>();
            for (int i : to_delete) {
                deleteSet.add(i);
            }
            helper(root, new TreeNode(), deleteSet, true);
            return res;
        }
    
        private void helper(TreeNode root, TreeNode parent, Set<Integer> to_delete, boolean isLeft) {
            if (root == null)
                return;
            Integer rootVal = root.val;
            if (to_delete.contains(rootVal)) {
                res.remove(root);
                to_delete.remove(rootVal);
                TreeNode leftNode = root.left;
                TreeNode rightNode = root.right;
                root.left = null;
                root.right = null;
                if (isLeft) {
                    parent.left = null;
                }
                else {
                    parent.right = null;
                }
                if (leftNode != null)
                    res.add(leftNode);
                if (rightNode != null)
                    res.add(rightNode);
                helper(leftNode, new TreeNode(), to_delete, true);
                helper(rightNode, new TreeNode(), to_delete, false);
            }
            else {
                helper(root.left, root, to_delete, true);
                helper(root.right, root, to_delete, false);
            }
        }
    }
}
