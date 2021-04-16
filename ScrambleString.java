import java.util.*;

public class ScrambleString {
    class Solution {
        int[][][] memo;
        String s1, s2;
    
        public boolean isScramble(String s1, String s2) {
            int length = s1.length();
            this.memo = new int[length][length][length + 1];
            this.s1 = s1;
            this.s2 = s2;
            return dfs(0, 0, length);
        }
    
        public boolean dfs(int i1, int i2, int length) {
            if (memo[i1][i2][length] != 0) {
                return memo[i1][i2][length] == 1;
            }
    
            if (s1.substring(i1, i1 + length).equals(s2.substring(i2, i2 + length))) {
                memo[i1][i2][length] = 1;
                return true;
            }
    
            if (!checkIfSimilar(i1, i2, length)) {
                memo[i1][i2][length] = -1;
                return false;
            }
            
            for (int i = 1; i < length; ++i) {
                if (dfs(i1, i2, i) && dfs(i1 + i, i2 + i, length - i)) {
                    memo[i1][i2][length] = 1;
                    return true;
                }
                if (dfs(i1, i2 + length - i, i) && dfs(i1 + i, i2, length - i)) {
                    memo[i1][i2][length] = 1;
                    return true;
                }
            }
    
            memo[i1][i2][length] = -1;
            return false;
        }
    
        public boolean checkIfSimilar(int i1, int i2, int length) {
            Map<Character, Integer> freq = new HashMap<Character, Integer>();
            for (int i = i1; i < i1 + length; ++i) {
                char c = s1.charAt(i);
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
            for (int i = i2; i < i2 + length; ++i) {
                char c = s2.charAt(i);
                freq.put(c, freq.getOrDefault(c, 0) - 1);
            }
            for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
                int value = entry.getValue();
                if (value != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
