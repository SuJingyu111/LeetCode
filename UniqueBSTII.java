import java.util.*;

public class UniqueBSTII {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<Integer> availableVals = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            availableVals.add(i);
        }
        return construct(availableVals, 0, n);
    }

    private List<TreeNode> construct(List<Integer> availableVals, int start, int end) {
        //int size = availableVals.size();
        List<TreeNode> res = new ArrayList<>();
        if (start >= end) {
            res.add(null);
            return res;
        }
        for (int i = start; i < end; i++) {
            List<TreeNode> leftRes = construct(availableVals, start, i);
            List<TreeNode> rightRes = construct(availableVals, i + 1, end);
            int leftSize = leftRes.size();
            int rightSize = rightRes.size();
            for (int j = 0; j < leftSize; j++) {
                for (int k = 0; k < rightSize; k++) {
                    TreeNode root = new TreeNode(availableVals.get(i), leftRes.get(j), rightRes.get(k));
                    res.add(root);
                }
            }
        }
        return res;
    }   
}
}
