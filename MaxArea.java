public class MaxArea {
    class Solution {
        public int maxArea(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int result = 0;
            while (left < right) {
                if (height[left] < height[right]) { 
                    result = result > height[left] * (right - left) ? result : height[left] * (right - left);       
                    ++left;
                }
                else {
                    result = result > height[right] * (right - left) ? result : height[right] * (right - left); 
                    --right;
                }
            }
            return result;
        }
    }
}
