import java.util.*;

public class FlipMatchVoyage {

    class Solution {
        List<Integer> result = new ArrayList<Integer>();
        int index = 0;
    
        public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
            if (root.val != voyage[0]) {
                result.add(-1);
                return result;
            }
            dfs(root, voyage);
            if (result.size() != 0 && result.get(0) == -1) {
                result.clear();
                result.add(-1);
            }
            return result;
        }
    
        private void dfs(TreeNode root, int[] voyage) {
            if (root == null) 
                return;
            if (root.val != voyage[index]) {
                result.clear();
                result.add(-1);
                return;
            }
            if (root.left != null && voyage[index + 1] != root.left.val) {
                index += 1;
                result.add(root.val);
                dfs(root.right, voyage);
                dfs(root.left, voyage);
            }
            else if (root.left == null) {
                index += 1;
                dfs(root.right, voyage);
            }  
            else {
                index += 1;
                dfs(root.left, voyage);
                dfs(root.right, voyage);
            }
        }
    }
}
