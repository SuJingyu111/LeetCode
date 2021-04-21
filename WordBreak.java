import java.util.*;

public class WordBreak {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> wordSet = new HashSet<>(wordDict);
            int length = s.length();
            if (length == 1) {
                return wordSet.contains(s);
            }
            boolean[] res = new boolean[length + 1];
            res[0] = true;
            for (int j = 1; j <= length; j++) {
                for (int i = 0; i < length; i++) {
                    if (res[i] && wordSet.contains(s.substring(i, j))) {
                        res[j] = true;
                        break;
                    }
                }
            }
            //System.out.println(Arrays.toString(res));
            return res[length];
        }
    }
}
