import java.util.*;

public class Trap {
    class Solution {

        public int trap(int[] height) {
            if (height.length == 0)
                return 0;
            int maxPos = 0;
            int res = 0;;
            for (int i = 0; i < height.length; i++) {
                if (height[i] > height[maxPos])
                    maxPos = i;
            }
            Deque<Integer> queue = new LinkedList<Integer>();
            queue.push(0);
            int currMaxPos = 0;
            for (int j = 0; j < maxPos; j++){
                if (height[j] > height[currMaxPos]) {
                    queue.push(j);
                    currMaxPos = j;
                }
            }
            int rightBar = maxPos;
            while (!queue.isEmpty()) {
                int leftBar = queue.pop();
                int remove = 0;
                for (int i = leftBar; i < rightBar; i++) {
                    remove += height[i];
                }
                res += height[leftBar] * (rightBar - leftBar) - remove;
                rightBar = leftBar;
            }
    
            currMaxPos = height.length - 1;
            queue.clear();
            queue.push(currMaxPos);
            for (int j = height.length - 1; j > maxPos; j--){
                if (height[j] > height[currMaxPos]) {
                    queue.push(j);
                    currMaxPos = j;
                }
            }
            int leftBar = maxPos;
            while (!queue.isEmpty()) {
                rightBar = queue.pop();
                int remove = 0;
                for (int i = leftBar + 1; i <= rightBar; i++) {
                    remove += height[i];
                }
                res += height[rightBar] * (rightBar - leftBar) - remove;
                leftBar = rightBar;
            }
            return res;
        }
    }
}
