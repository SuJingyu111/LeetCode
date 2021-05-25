public class DecodeString {
    class Solution {
        public String decodeString(String s) {
            int len = s.length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                if (Character.isDigit(s.charAt(i))) {
                    int times = (int)(s.charAt(i) - 48);
                    i += 1;
                    while (Character.isDigit(s.charAt(i))) {
                        times = times * 10 + (int)(s.charAt(i) - 48);
                        i++;
                    }
                    StringBuilder lsb = new StringBuilder();
                    while (s.charAt(i) != '[') {
                        lsb.append(s.charAt(i));
                        i++;
                    }
                    i += 1;
                    int left = i;
                    int cnt = 1;
                    while (i < len && cnt > 0) {
                        if (s.charAt(i) == '[') {
                            cnt += 1;
                        }
                        else if (s.charAt(i) == ']') {
                            cnt -= 1;
                        }
                        i++;
                    }
                    String inner = decodeString(s.substring(left, i - 1));
                    lsb.append(inner);
                    String lstring = lsb.toString();
                    for (int j = 0; j < times; j++) {
                        sb.append(lstring);
                    }
                    i--;
                }
                else {
                    sb.append(s.charAt(i));
                }
            }
            return sb.toString();
        }
    }
}
