public class TrapRainDrop {
    class Solution {
        public int trap(int[] height) {
            int length = height.length;
            if (length == 0) {
                return 0;
            }
            int[] bounds = new int[length];
            for (int i = 0; i < length; i++) {
                bounds[i] = height[i];
            }
            int lastBound = height[0];
            for (int i = 0; i < length - 1; i++) {
                if (height[i] > lastBound) {
                    lastBound = height[i];
                }
                bounds[i] = lastBound;
            }
            lastBound = height[length - 1];
            for (int j = length - 1; j > 0; j--){
                if (height[j] > lastBound) {
                    lastBound = height[j];
                }
                bounds[j] = Math.min(bounds[j], lastBound);
            }
            int res = 0;
            for (int i = 0; i < length; i++) {
                res += bounds[i] - height[i];
            }
            return res;
        }
    }
}
