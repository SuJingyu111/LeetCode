public class SearchInsert {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                System.out.print(left + " " + right);
                int p = (left + right)  / 2;
                if (nums[p] == target)
                    return p;
                else if (nums[p] > target) {
                    if (left + 1 == right)
                        left += 1;
                    else
                        right = p;
                }    
                else {
                    System.out.println("here");
                    if (left + 1 == right)
                        left += 1;
                    else
                        left= p;
                }
            }
            return left;
        }
    }
    class BinarySearchSolution {
        private int[][] matrix;
    
        public boolean searchMatrix(int[][] matrix, int target) {
            this.matrix = matrix;
            int down = binarySearchColumn(target);
            return binarySearchRow(target, down);
        }
    
        private int binarySearchColumn(int target) {
            int up = 0;
            int down = matrix.length - 1;
            while (down > up) {
                int mid = (down + up + 1) / 2;
                if (matrix[mid][0] <= target)
                    up = mid;
                else
                    down = mid - 1;
            }
            return down;
        }
    
        private boolean binarySearchRow(int target, int down) {
            int[] array = matrix[down];
            int length = array.length;
            int left = 0;
            int right = length - 1;
            boolean ifFound = false;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (array[mid] == target) {
                    return true;
                }
                if (array[mid] < target) {
                    left = mid + 1;
                }
                else
                    right = mid - 1;
            }
            return ifFound;
        }
    }
}
