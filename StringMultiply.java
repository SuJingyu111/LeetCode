public class StringMultiply {
    class Solution {

        public String multiply(String num1, String num2) {
            String res = new String();
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }
            int length1 = num1.length(), length2 = num2.length(); 
            for (int i = length1 - 1; i >= 0; i--) {
                for (int j = length2 - 1; j >= 0; j--) {
                    Integer temp = (num1.charAt(i) - 48) * (num2.charAt(j) - 48);
                    StringBuilder sb = new StringBuilder(temp.toString());
                    int zeroNum = length1 + length2 - 2 - (i + j);
                    for (int k = 0; k < zeroNum; k++) {
                        sb.append('0');
                    }
                    res = stringAdd(res, sb.toString());
                }
            }
            return res;
        }
    
        private String stringAdd(String n1, String n2) {
            if (n1.length() == 0 || n2.length() == 0) {
                return n1.length() == 0 ? n2 : n1;
            }
            int overflow = 0;
            String s, l;
            int sLength, lLength;
            if (n1.length() >= n2.length()) {
                s = n2;
                l = n1;
                sLength = n2.length();
                lLength = n1.length();
            }
            else {
                s = n1;
                l = n2;
                sLength = n1.length();
                lLength = n2.length();
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= sLength - 1; i++) {
                int posRes = s.charAt(sLength - 1 - i) + l.charAt(lLength - 1 - i) - 96 + overflow;
                if (posRes >= 10) {
                    overflow = 1;
                    sb.insert(0, posRes%10);
                }
                else {
                    overflow = 0;
                    sb.insert(0, posRes);
                }
            }
            int j = lLength - 1 - (sLength - 1);
            while (j - 1 >= 0) {
                int posRes = l.charAt(j - 1) + overflow - 48;
                if (posRes >= 10) {
                    overflow = 1;
                    sb.insert(0, posRes%10);
                }
                else {
                    overflow = 0;
                    sb.insert(0, posRes);
                }
                j--;
            }
            if (overflow == 1) {
                sb.insert(0, '1');
            }
            return sb.toString();
        }
    }
}
