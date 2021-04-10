import java.util.*;

public class IsHappyNumber {
    class Solution {
        public boolean isHappy(int n) {
            Set<Integer> set = new HashSet<Integer>();
            while (n != 1) {
                int temp = 0;
                while (n > 0) {
                    temp += (n % 10) * (n % 10);
                    n /= 10;
                }
                n = temp;
                if (!set.add(n)) {
                    return false;
                }
            }
            return true;
        }
    }
}
