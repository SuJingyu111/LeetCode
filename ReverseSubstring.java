public class ReverseSubstring {
    class Solution {
        int layer = 0;
    
        public String reverseParentheses(String s) {
            StringBuilder sb = new StringBuilder();
            int len = s.length();
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) == '(') {
                    int cnt = 1;
                    int left = i + 1;
                    while (cnt > 0) {
                        i++;
                        if (s.charAt(i) == '(') {
                            cnt++;
                        }
                        else if (s.charAt(i) == ')') {
                            cnt--;
                        }
                    }
                    layer += 1;
                    String innerString = reverseParentheses(s.substring(left, i));
                    sb.append(innerString);
                }
                else {
                    sb.append(s.charAt(i));
                }
            }
            if (layer == 0) {
                return sb.toString();
            }
            else {
                layer--;
                return sb.reverse().toString();
            }
        }
    }
}
