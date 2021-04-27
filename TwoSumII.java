public class TwoSumII {
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int length = numbers.length;
            int[] res = new int[2];
            for (int i = 0; i < length; i++) {
                int find = target - numbers[i];
                int left;
                int right;
                if (find >= numbers[i]) {
                    left = i + 1;
                    right = length - 1;
                }
                else {
                    break;
                }
                int findIdx = binarySearch(numbers, find, left, right); 
                if (findIdx != -1) {
                    res[0] = i + 1;
                    res[1] = findIdx + 1;
                    break;
                }
            }
            return res;
        }
    
        private int binarySearch(int[] numbers, int find, int left, int right) {
            int res = -1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (numbers[mid] == find) {
                    return mid;
                }
                if (numbers[mid] > find) {
                    right = mid - 1;
                }
                else if (numbers[mid] < find) {
                    left = mid + 1;
                }
            }
            if (left < numbers.length && numbers[left] == find) {
                return left;
            }
            return res;
        }
    }
}
