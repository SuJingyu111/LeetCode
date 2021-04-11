import java.util.*;

public class nthUglyNumber {
    class Solution {
        Set<Long> set = new TreeSet<Long>();
        public int nthUglyNumber(int n) {
            set.add(1L);
            Long thisUglyNumber = 1L;
            for (int i = 0; i < n - 1; i++) {          
                set.add(2 * thisUglyNumber);
                set.add(3 * thisUglyNumber);
                set.add(5 * thisUglyNumber);            
                set.remove(thisUglyNumber);
                thisUglyNumber = set.iterator().next();
            }
            int res = thisUglyNumber.intValue();
            return res;
        }
    }
}
