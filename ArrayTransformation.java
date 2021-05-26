import java.util.*;
public class ArrayTransformation {
    class Solution {
        public List<Integer> transformArray(int[] arr) {
            int len = arr.length;
            while (transform(arr, len));
            List<Integer> res = new ArrayList<>();
            for (int num : arr) {
                res.add(num);
            }
            return res;
        }
    
        private boolean transform(int[] arr, int len) {
            boolean changed = false;
            int prev = arr[0];
            for (int i = 1; i < len - 1; i++) {
                if (arr[i] < prev && arr[i] < arr[i + 1]) {
                    prev = arr[i];
                    arr[i]++;
                    changed = true;
                }
                else if (arr[i] > prev && arr[i] > arr[i + 1]) {
                    prev = arr[i];
                    arr[i]--;
                    changed = true;
                }
                else {
                    prev = arr[i];
                }
            }
            return changed;
        }
    }
}
