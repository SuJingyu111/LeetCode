import java.util.*;

public class BasicCalculator {
    class Solution {
        Deque<Integer> stk = new LinkedList<Integer>();
        String str;
        int i;
    
        public int calculate(String s) {
            s = s.replaceAll(" ", "");
            str = s;
            int length = s.length();
            for (i = 0; i < length; i++) {
                char c = s.charAt(i);
                if (c == '+') {
                    i += 1;
                    int temp = parseInt();
                    stk.push(temp);
                }
                else if (c == '-') {
                    i += 1;
                    int temp = parseInt();
                    stk.push(-temp);
                }
                else if (c == '*') {
                    i += 1;
                    int right = parseInt();
                    int left = stk.pop();
                    stk.push(left * right);
                }
                else if (c == '/') {
                    i += 1;
                    int right = parseInt();
                    int left = stk.pop();
                    stk.push(left / right);
                }
                else {
                    int temp = parseInt();
                    stk.push(temp);
                }
            }
            int res = 0;
            for (int j : stk) {
                res += j;
            }
            return res;
        }
    
        private int parseInt() {
            char c = str.charAt(i);
            int length = str.length();
            int temp = ((int)c - 48);
            int indent = 1;
            while ( i + indent < length && str.charAt(i + indent) != '+' && str.charAt(i + indent) != '-' 
                    && str.charAt(i + indent) != '*' && str.charAt(i + indent) != '/') {
                    temp *= 10;
                    temp += (int)str.charAt(i + indent) - 48;
                    indent++;
            }
            i += indent - 1;
            return temp;
        }
    }
}
