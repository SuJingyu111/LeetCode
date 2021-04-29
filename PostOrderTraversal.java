import java.util.*;

public class PostOrderTraversal {
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            if (root == null) {
                return new ArrayList<Integer>();
            }
            List<Integer> res = postorderTraversal(root.left);
            res.addAll(postorderTraversal(root.right));
            res.add(root.val);
            return res;
        }
    }
}
