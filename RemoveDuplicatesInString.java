public class RemoveDuplicatesInString {
    class Solution {
        public String removeDuplicates(String S) {
            int length = S.length();
            if (length < 2)
                return S;
            boolean hasDup = false;
            int i = 0;
            int left = 0;
            while (i < length - 1) {
                if (S.charAt(i) == S.charAt(i+1) && !hasDup) {
                    hasDup = true;
                    left = i;
                    break;
                }
                i += 1;
            }
            if (hasDup) {
                S = S.substring(0, left) + S.substring(left + 2, length);
            }
            //System.out.println(S);
            if (hasDup) {
                return removeDuplicates(S);
            }
            else {
                return S;
            }
        }
    }
}
