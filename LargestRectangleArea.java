import java.util.*;

public class LargestRectangleArea {
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int max = 0;
            int length = heights.length;
            Deque<Integer> leftStk = new LinkedList<Integer>();
            int[] leftIdx = new int[length];
            Deque<Integer> rightStk = new LinkedList<Integer>();
            int[] rightIdx = new int[length];
            for (int i = 0; i < length; i++) {
                leftIdx[i] = -1;
                rightIdx[i] = length;//is it?
            }
            for (int i = 0; i < length; i++) {
                while (!leftStk.isEmpty() && heights[leftStk.peek()] >= heights[i]) {
                    leftStk.pop();
                }
                if (!leftStk.isEmpty()) {
                    leftIdx[i] = leftStk.peek();
                }
                leftStk.push(i);
            }   
            for (int j = length - 1; j >= 0; j--) {
                while (!rightStk.isEmpty() && heights[rightStk.peek()] >= heights[j]) {
                    rightStk.pop();
                }
                if (!rightStk.isEmpty()) {
                    rightIdx[j] = rightStk.peek();
                }
                rightStk.push(j);
            }
            //System.out.println(Arrays.toString(leftIdx));
            //System.out.println(Arrays.toString(rightIdx));
            for (int k = 0; k < length; k++) {
                int area = heights[k] * (rightIdx[k] - leftIdx[k] - 1);
                max = area > max ? area : max;
            }
            return max;
        }
    }
}
