import java.util.*;

public class LeafSimilatTrees {
    class Solution {
        List<Integer> listOne = new ArrayList<Integer>();
        List<Integer> listTwo = new ArrayList<Integer>();
    
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            findLeaf(root1, listOne);
            findLeaf(root2, listTwo);
            int size = listOne.size();
            if (size != listTwo.size()) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (listOne.get(i) != listTwo.get(i)) {
                    return false;
                }
            }
            return true;
        }
    
        private void findLeaf(TreeNode root, List<Integer> list) {//keep input non-null
            if (root.left == null && root.right == null) {
                list.add(root.val);
            }
            else {
                if (root.left != null) {
                    findLeaf(root.left, list);
                }
                if (root.right != null) {
                    findLeaf(root.right, list);
                }
            }
        }
    }
}
