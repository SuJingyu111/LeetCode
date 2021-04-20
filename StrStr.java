public class StrStr {
    class Solution {
        public int strStr(String haystack, String needle) {
            if (needle.length() == 0) {
                return 0;
            }
            int hLength = haystack.length();
            int nLength = needle.length();
            int[] pmt = getPMT(needle);
            int i = 0;
            int j = 0;
            while (i < hLength && j < nLength) {
                if (j != -1 && haystack.charAt(i) != needle.charAt(j)) {
                    j = pmt[j];
                }
                else {
                    i++;
                    j++;
                }
            }
            if (j == nLength) {
                return i - j;
            }
            return -1;
        }
    
        private int[] getPMT(String needle) {
            int length = needle.length();
            int[] pmt = new int[length];
            pmt[0] = -1;
            int i = 0;
            int j = -1;
            while (i < length - 1) {
                if (j == -1 || needle.charAt(i) == needle.charAt(j)) {
                    j++;
                    i++;
                    //System.out.println(i + " " + j);
                    pmt[i] = j;
                }
                else {
                    j = pmt[j];
                }
            }
            return pmt;
        }
    }
}
