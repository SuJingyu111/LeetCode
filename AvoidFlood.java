public class AvoidFlood {
    class Solution {
        public int[] avoidFlood(int[] rains) {
            Map<Integer, Integer> encountered = new HashMap<>(); //下过雨的池塘号, 池塘下雨日期;
            TreeMap<Integer, Integer> bucketMap = new TreeMap<>(); //某个桶可以抽干的最 早日期, 桶尺寸;
            int length = rains.length;
            int[] ans = new int[length];
            for (int i = 0; i < length; i++) {
                if (rains[i] > 0) {
                    ans[i] = -1;
                    if (!encountered.containsKey(rains[i])) {
                        encountered.put(rains[i], i); //如果此前该池塘没有下雨，则将池塘号和日期存入map
                    }
                    else {
                        //如果下过雨，则获取在两个日期内出现的桶
                        Map<Integer,Integer> buckets = bucketMap.subMap(encountered.get(rains[i]), i);
                        //如果没有满足条件的桶，则不存在满足的解，返回空数组
                        if (buckets.size() == 0) {
                            return new int[0];
                        }
                        //获取一个桶
                        Map.Entry<Integer,Integer> entry = buckets.entrySet().iterator().next();
                        Integer bucketStart = entry.getKey();
                        int bucketLength = buckets.get(bucketStart);
                        //在该天抽干rains[i]号池塘
                        ans[bucketStart] = rains[i];
                        if (bucketLength == 1) {
                            bucketMap.remove(bucketStart);//如果桶尺寸为1，则抽干后桶尺寸归零，移除桶
                        }
                        else {
                            bucketMap.remove(bucketStart);
                            bucketMap.put(bucketStart + 1, bucketLength - 1);//修改桶信息
                        }
                        //由于又遇见一次该池塘，则把这次遇见的日期加入encountered
                        encountered.put(rains[i], i);
                    }
                }
                else {
                    int bucketLength = 0;
                    int bucketStart = i;
                    while (i < length && rains[i] == 0) {
                        ans[i] = 1;
                        i += 1;
                        bucketLength += 1;
                    }
                    i -= 1;
                    bucketMap.put(bucketStart, bucketLength);//将桶加入bucketMap
                }
            }
            return ans;
        }
    }
}
