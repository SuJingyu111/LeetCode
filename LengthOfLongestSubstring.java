import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<Character>();
        int result = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0)
                charSet.remove(s.charAt(i - 1));
            while (j < s.length() && !charSet.contains(s.charAt(j))) {
                charSet.add(s.charAt(j));
                j += 1;
            }
            result = Math.max(result, j - i);
        }
        return result;
    }
}