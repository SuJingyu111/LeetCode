import java.util.*;

public class IsCousins {
    class Solution {
        public boolean isCousins(TreeNode root, int x, int y) {
            Queue<TreeNode> children = new LinkedList<TreeNode>();
            Map<Integer, Integer[]> map = new HashMap<Integer, Integer[]>();//val, parent, depth
            Integer[] init = {root.val, 1};
            if (root.left != null) {
                children.add(root.left);
                map.put(root.left.val, init);
            }
            if (root.right != null) {
                children.add(root.right);
                map.put(root.right.val, init);
            }
            while (!children.isEmpty()) {
                TreeNode t = children.poll();
                if (t != null) {
                    if (t.left != null) {
                        children.add(t.left);
                        Integer[] arr = new Integer[2];
                        arr[0] = t.val;
                        arr[1] = map.get(t.val)[1] + 1;
                        map.put(t.left.val, arr);
                    }
                    if (t.right != null) {
                        children.add(t.right);
                        Integer[] arr = new Integer[2];
                        arr[0] = t.val;
                        arr[1] = map.get(t.val)[1] + 1;
                        map.put(t.right.val, arr);
                    }
                }
            }
            Integer[] X = map.get(x);
            Integer[] Y = map.get(y);
            if (X != null && Y != null) {
                return (X[0] != Y[0]) && (X[1] == Y[1]);
            }
            return false;
        }
    }
}
