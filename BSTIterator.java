import java.util.*;

public class BSTIterator {
    private Deque<TreeNode>  traverseList = new LinkedList<TreeNode>();

    public BSTIterator(TreeNode root) {
        traverseList.addFirst(root);
    }
    
    public int next() {
        TreeNode cursor = traverseList.getFirst().left;
        traverseList.getFirst().left = null;
        while (cursor != null) {
            traverseList.addFirst(cursor);
            TreeNode temp = cursor.left;
            cursor.left = null;
            cursor = temp;
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
