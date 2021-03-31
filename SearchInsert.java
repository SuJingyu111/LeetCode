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
}
