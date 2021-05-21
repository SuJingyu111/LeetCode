public class LongestPalindrome {
    class Solution {
        public String longestPalindrome(String s) {
            int length = s.length();
            boolean[][] isPalindrome = new boolean[length][length];
            for (int i = 0; i < length; i++) {
                isPalindrome[i][i] = true;
            }
            int slength = 0;
            int start = 0, end = 0;
            for (int i = length - 1; i >= 0; i--) {
                for (int j = i + 1; j < length; j++) {
                    if (s.charAt(i) == s.charAt(j)){
                        if (i + 1 == j) {
                            isPalindrome[i][j] = true;
                        }
                        else {
                            isPalindrome[i][j] = isPalindrome[i + 1][j - 1];
                        }
                    }
                    if (isPalindrome[i][j] == true && j - i > slength) {
                        slength = j - i;
                        start = i; 
                        end = j;
                    }
                }
            }
            return s.substring(start, end + 1);
        }
    }
}
