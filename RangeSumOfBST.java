public class RangeSumOfBST {
    class Solution {
        public int rangeSumBST(TreeNode root, int low, int high) {
            if (root == null)
                return 0;
            int res = 0;
            if (root.val >= low && root.val <= high) {
                res += root.val;
                int leftRes = rangeSumBST(root.left, low, high);
                int rightRes = rangeSumBST(root.right, low, high);
                res += leftRes + rightRes;
            }
            else if (root.val < low) {
                res += rangeSumBST(root.right, low, high);
            }
            else {
                res += rangeSumBST(root.left, low, high);
            }
            return res;
        }
    }
}
