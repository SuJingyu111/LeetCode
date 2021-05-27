import java.util.*;

public class SortArray {
    class Solution {
        public int[] sortArray(int[] nums) {
            int len = nums.length;
            quickSort(nums, 0, len);
            return nums;
        }
    
        private void quickSort(int[] nums, int start, int end) {
            if (start >= end - 1) {
                return;
            }
            int pPos = partition(nums, start, end);
            quickSort(nums, start, pPos);
            quickSort(nums, pPos + 1, end);
        }
    
        private int partition(int[] nums, int start, int end) {
            Random rand = new Random();
            int pPos = rand.nextInt(end - start) + start;
            int part = nums[pPos];
            swap(nums, start, pPos);
            int pos = end;
            for (int i = end - 1; i > start; i--) {
                if (nums[i] > part) {
                    pos--;
                    swap(nums, pos, i);
                }
            }
            swap(nums, start, pos - 1);
            return pos - 1;
        }
    
        private void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }
}
