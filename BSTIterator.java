import java.util.*;

public class BSTIterator {
    private Deque<TreeNode>  traverseList = new LinkedList<TreeNode>();
    private Set<TreeNode> traversedSet = new HashSet<TreeNode>();

    public BSTIterator(TreeNode root) {
        traverseList.addFirst(root);
    }
    
    public int next() {
        TreeNode cursor = traverseList.getFirst().left;
        while (cursor != null && !traversedSet.contains(cursor)) {
            traverseList.addFirst(cursor);
            traversedSet.add(cursor);
            cursor = cursor.left;
        }
        cursor = traverseList.removeFirst();
        int val = cursor.val;
        if (cursor.right != null)
            traverseList.addFirst(cursor.right);
        return val;
    }
    
    public boolean hasNext() {
        return !traverseList.isEmpty();
    }
}
