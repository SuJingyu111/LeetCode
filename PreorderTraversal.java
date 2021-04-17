import java.util.*;

public class PreorderTraversal{
    class Solution {    
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<Integer>();
            if (root == null)
                return list;
            list.add(root.val);
            list.addAll(preorderTraversal(root.left));
            list.addAll(preorderTraversal(root.right));
            return list;
        }
    }
}