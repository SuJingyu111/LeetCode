public class LRUCache {
    int capacity = 0;
    Map<Integer, Integer> valueMap;//KEY. VAL
    TreeMap<Integer, Integer> TTLMap;//TTL, KEY
    int currentTime = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        valueMap = new HashMap<Integer, Integer>();
        TTLMap = new TreeMap<Integer, Integer>();
    }
    
    public int get(int key) {
        Integer val = valueMap.get(key);
        Integer res = -1;
        if (val != null) {
            res = val;
            int deleteTTL = -1;
            for (Map.Entry<Integer, Integer> e : TTLMap.entrySet()) {
                if (e.getValue() == key) {
                    deleteTTL = e.getKey();
                    break;
                }
            }
            TTLMap.remove(deleteTTL);
            TTLMap.put(currentTime, key);
        }
        currentTime += 1;
        return res;
    }
    
    public void put(int key, int value) {
        valueMap.put(key, value);
        int deleteTTL = -1;
        for (Map.Entry<Integer, Integer> e : TTLMap.entrySet()) {
            if (e.getValue() == key) {
                deleteTTL = e.getKey();
                 break;
            }
        }
        if (deleteTTL != -1) {
            TTLMap.remove(deleteTTL);
        }
        TTLMap.put(currentTime, key);      
        currentTime += 1;
        int size = valueMap.size();
        if (size > this.capacity) {
            int leastKey = TTLMap.get(TTLMap.firstKey());
            valueMap.remove(leastKey);
            TTLMap.remove(TTLMap.firstKey());
        }
    }
}
