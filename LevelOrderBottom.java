import java.util.*;

public class LevelOrderBottom {
    class Solution {

        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            Queue<TreeNode> traverseQ = new LinkedList<>();
            Deque<List<Integer>> resStk = new LinkedList<>();
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            traverseQ.offer(root);
            while (!traverseQ.isEmpty()) {
                Queue<TreeNode> newTraverseQ = new LinkedList<>();
                List<Integer> thisRes = new ArrayList<>();
                while (!traverseQ.isEmpty()) {
                    TreeNode thisNode = traverseQ.poll();
                    if (thisNode.left != null) {
                        newTraverseQ.offer(thisNode.left);
                    }
                    if (thisNode.right != null) {
                        newTraverseQ.offer(thisNode.right);
                    }
                    thisRes.add(thisNode.val);
                }
                resStk.push(thisRes);
                traverseQ = newTraverseQ;
            }
            while (!resStk.isEmpty()) {
                res.add(resStk.pop());
            }
            return res;
        }
    }
}
