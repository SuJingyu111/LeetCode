public class AddBinary {
    class Solution {
        public String addBinary(String a, String b) {
            StringBuilder sb = new StringBuilder();
            int i = a.length() - 1;
            int j = b.length() - 1;
            boolean overflow = false;
            while (i >= 0 && j >= 0) {
                if (!overflow) {
                    if (a.charAt(i) == '0' && b.charAt(j) == '0') {
                        sb.insert(0, "0");
                    }
                    else if (a.charAt(i) == '1' && b.charAt(j) == '0' 
                                || a.charAt(i) == '0' && b.charAt(j) == '1') {
                        sb.insert(0, "1");
                    }
                    else {
                        sb.insert(0, "0");
                        overflow = true;
                    }
                }
                else {
                    if (a.charAt(i) == '0' && b.charAt(j) == '0') {
                        sb.insert(0, "1");
                        overflow = false;
                    }
                    else if (a.charAt(i) == '1' && b.charAt(j) == '0' 
                                || a.charAt(i) == '0' && b.charAt(j) == '1') {
                        sb.insert(0, "0");
                    }
                    else {
                        sb.insert(0, "1");
                    }
                }
                i--;
                j--;
            }
    
            if (i >= 0) {
                for (int k = i; k >= 0; k--) {
                    if (a.charAt(k) == '0') {
                        if (overflow) {
                            sb.insert(0, '1');
                            overflow = false;
                        }
                        else {
                            sb.insert(0, '0');
                        }
                    }
                    else {
                        if (overflow) {
                            sb.insert(0, '0');
                        }
                        else {
                            sb.insert(0, '1');
                        }
                    }
                }
            }
            else if (j >= 0) {
                for (int k = j; k >= 0; k--) {
                    if (b.charAt(k) == '0') {
                        if (overflow) {
                            sb.insert(0, '1');
                            overflow = false;
                        }
                        else {
                            sb.insert(0, '0');
                        }
                    }
                    else {
                        if (overflow) {
                            sb.insert(0, '0');
                        }
                        else {
                            sb.insert(0, '1');
                        }
                    }
                }
            }
            if (overflow) {
                sb.insert(0, 1);
            }
            return sb.toString();
        }
    }
}
