import java.util.*;

public class TopKFrequentWords {
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> cntMap = new HashMap<>();
            Map<Integer, Set<String>> strMap = new TreeMap<>(Collections.reverseOrder());
            for (String word : words) {
                if (!cntMap.containsKey(word)) {
                    cntMap.put(word, 1);
                    Set<String> thisSet = strMap.getOrDefault(1, new TreeSet<String>());
                    thisSet.add(word);
                    strMap.put(1, thisSet);
                }
                else {
                    Integer num = cntMap.get(word);
                    Set<String> thisSet = strMap.get(num);
                    thisSet.remove(word);
                    cntMap.put(word, num + 1);
                    thisSet = strMap.getOrDefault(num + 1, new TreeSet<String>());
                    thisSet.add(word); 
                    strMap.put(num + 1, thisSet);
                }
            }
            List<String> res = new ArrayList<>();
            List<Set<String>> valSets = new ArrayList<Set<String>>(strMap.values());
            for (Set<String> valSet : valSets) {
                for (String s : valSet) {
                    if (res.size() == k) {
                        break;
                    }
                    res.add(s);
                }
                if (res.size() == k) {
                    break;
                }
            }
            return res;
        }
    }
}
