import java.util.*;

public class MaximizeXOR {
    class Solution {
        Trie root = new Trie();
        static final int HIGH_BIT = 30;
    
        public int[] maximizeXor(int[] nums, int[][] queries) {
            int numsLen = nums.length, queriesLen = queries.length;
            Arrays.sort(nums);
            Map<int[], Integer> idxMap = new HashMap<>();
            for (int i = 0; i < queriesLen; i++) {
                idxMap.put(queries[i], i);
            }
            Arrays.sort(queries, new Comparator<int[]>(){
                @Override
                public int compare(int[] a1, int[] a2) {
                    return a1[1] - a2[1];
                }
            });
    
            int[] res = new int[queriesLen];
            int idx = 0;
            for (int i = 0; i < queriesLen; i++) {
                int[] query = queries[i];
                while (idx < numsLen && nums[idx] <= query[1]) {
                    add(nums[idx]);
                    idx++;
                }
                int thisRes = get(query[0]);
                res[idxMap.get(query)] = thisRes;
            }
            return res;
        }
    
        private void add(int x) {
            Trie currNode = root;
            for (int k = HIGH_BIT - 1; k >= 0; k--) {
                int bit = (x >> k) & 1;
                if (bit == 0) {
                    if (currNode.left == null) {
                        currNode.left = new Trie();
                    }
                    currNode = currNode.left;
                }
                else {
                    if (currNode.right == null) {
                        currNode.right = new Trie();
                    }
                    currNode = currNode.right;
                }
            }
        }
    
        private int get(int x) {
            if (root.left == null && root.right == null) {
                return -1;
            }
            int res = 0;
            Trie currNode = root;
            for (int k = HIGH_BIT - 1; k >=0; k--) {
                int bit = (x >> k) & 1;
                if (bit == 0) {
                    if (currNode.right != null) {
                        res = res * 2 + 1;
                        currNode = currNode.right;
                    }
                    else {
                        res = res * 2;
                        currNode = currNode.left;
                    }
                }
                else {
                    if (currNode.left != null) {
                        res = res * 2 + 1;
                        currNode = currNode.left;
                    }
                    else {
                        res = res * 2;
                        currNode = currNode.right;
                    }
                }
            }
            return res;
        }
    
        class Trie {
            Trie left = null;
            Trie right = null;
        }
    }
}
