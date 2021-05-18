import java.util.*;

public class ZigZagLevelOrder {
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            if (root == null) {
                return res;
            }
            Deque<TreeNode> dQue = new LinkedList<TreeNode>();
            dQue.offer(root);
            boolean fromLeft = true;
            int layerNodeNum = 1;
            while (!dQue.isEmpty()) {
                List<Integer> thisRes = new ArrayList<>();
                int cnt = 0;
                for (int i = 0; i < layerNodeNum; i++) {
                    TreeNode node = fromLeft ? dQue.pop() : dQue.pollLast();
                    thisRes.add(node.val);
                    if (fromLeft) {
                        if (node.left != null) {
                            dQue.offer(node.left);
                            cnt++;
                        }
                        if (node.right != null) {
                            dQue.offer(node.right);
                            cnt++;
                        }
                    }
                    else {
                        if (node.right != null) {
                            dQue.push(node.right);
                            cnt++;
                        }
                        if (node.left != null) {
                            dQue.push(node.left);
                            cnt++;
                        }
                    }
                }
                res.add(thisRes);
                layerNodeNum = cnt;
                fromLeft = fromLeft ? false : true;
            }
            return res;
        }
    }
}
