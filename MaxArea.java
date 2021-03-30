public class MaxArea {
    class Solution {
        public int maxArea(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int result = Math.min(height[left], height[right]) * (right - left);
            while (left < right) {
                //System.out.println("----------------------");
                if (height[left] < height[right]) {           
                    result = Math.max(result, Math.min(height[left+1], height[right]) * (right - left - 1));
                    left += 1;
                }
                else if (height[right] <= height[left]) {
                    result = Math.max(result, Math.min(height[right - 1], height[left]) * (right - left - 1));
                    right -= 1;
                }
            }
            return result;
        }
    }
}
