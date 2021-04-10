import java.util.*;

public class IsIsomorphicString {
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (s.length() != t.length())
                return false;
            Map<Character, Character> map = new HashMap<>();
            int length = s.length();
            for (int i = 0; i < length; i++) {
                char sChar = s.charAt(i);
                char tChar = t.charAt(i);
                if (!map.containsKey(sChar)) {
                    if (map.containsValue(tChar))
                        return false;
                    map.put(sChar, tChar);
                }
                else {
                    if (map.get(sChar) != tChar)
                        return false;
                }
            }
            return true;
        }
    }
}
