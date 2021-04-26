public class ShipWithinDays {
    class Solution {
        public int shipWithinDays(int[] weights, int D) {
            int length = weights.length;
            if (length == 1) {
                return weights[0];
            }
            int sum = 0;
            int max = Integer.MIN_VALUE;
            for (int i : weights) {
                sum += i;
                max = i > max ? i : max;
            }
            int i = max, j = sum;
            //System.out.println(i + " " + j);
            while (i < j) {
                int days = 1;
                int carrying = 0;
                int mid = (i + j) / 2;
                for (int w : weights) {
                    carrying += w;
                    if (carrying > mid) {
                        carrying = w;
                        days += 1;
                    }
                }
                if (days <= D) {
                    j = mid;
                }
                if (days > D) {
                    i = mid + 1;
                }
            }
            return i;
        }
    }
    
}
