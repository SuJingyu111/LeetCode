import java.util.*;

public class BSTRightSideView {
    class Solution {
        List<Integer> resList = new ArrayList<Integer>();
        int layerLength = 0;
    
        public List<Integer> rightSideView(TreeNode root) {
            if (root != null)
                dfs(root, 1);
            return resList;
        }   
    
        private void dfs(TreeNode root, int layer) {
            if (layer > layerLength) {
                resList.add(root.val);
                layerLength++;
            }
            if (root.right != null) {
                dfs(root.right, layer + 1);
            }
            if (root.left != null) {
                dfs(root.left, layer + 1);
            }
        }
    }
}
