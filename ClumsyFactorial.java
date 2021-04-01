public class ClumsyFactorial {
    class Solution {
        boolean added = true;
        int num;
    
        public int clumsy(int N) {
            num = N;
            int res = calculate();
            while (num >= 1) {
                if (added)
                    res -= calculate();
                else
                    res += add();
            }
            return res;
        }
    
        private int calculate() {
            if (num == 1) {
                num -= 1;
                return 1;
            }
            int res = num--;
            if (num >= 1)
                res *= num--;
            if (num >= 1)
                res /= num--;
            added = false;
            return res;
        }
    
        private int add() {
            added = true;
            int res = num;
            num -= 1;
            return res;
        }
    }
}
