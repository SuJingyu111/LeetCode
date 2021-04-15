public class AddString {
    class Solution {
        public String addStrings(String num1, String num2) {
            String longStr, shortStr;
            if (num1.length() >= num2.length()) {
                longStr = num1;
                shortStr = num2;
            }
            else {
                longStr = num2;
                shortStr = num1;
            }
            int i = longStr.length() - 1;
            int j = shortStr.length() - 1;
            int overflow = 0;
            StringBuilder sb = new StringBuilder();
            while (i >= 0) {
                while (j >= 0) {
                    int idx = (int)(longStr.charAt(i--) + shortStr.charAt(j--) - 96) + overflow;
                    if (idx < 10) {
                        overflow = 0;
                        sb.insert(0, idx);
                    }
                    else {
                        overflow = 1;
                        sb.insert(0, idx % 10);
                    }
                }
                if (i < 0)
                    break;
                int idx = (int)(longStr.charAt(i--)- 48) + overflow;
                if (idx < 10) {
                    overflow = 0;
                    sb.insert(0, idx);
                }
                else {
                    overflow = 1;
                    sb.insert(0, idx % 10);
                }
            }
            if (overflow == 1) {
                sb.insert(0, 1);
            }
            return sb.toString();
        }
    }
}
