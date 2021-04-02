import java.util.*;

public class MergeIntervals {
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length == 1)
                return intervals;
    
            Arrays.sort(intervals, new Comparator<int[]>() {
                public int compare(int[] interval1, int[] interval2) {
                    if (interval1[0] != interval2[0]) {
                        return interval1[0] - interval2[0];
                    }
                    else 
                        return interval1[1] - interval2[1];
                }
            });
            
            List<int[]> list = new ArrayList<int[]>();
            int[] temp = intervals[0];
            for (int i = 0; i < intervals.length; i++) {
                if (intervals[i][0] <= temp[1]) {
                    temp[1] = temp[1] > intervals[i][1] ? temp[1] : intervals[i][1]; 
                }
                else {
                    list.add(temp);
                    temp = intervals[i];
                }
            }
            if (intervals[intervals.length - 1][0] <= temp[1]) {
                    temp[1] = temp[1] > intervals[intervals.length - 1][1] ? temp[1] : intervals[intervals.length - 1][1]; 
            }
            list.add(temp);
            int[][] res = new int[list.size()][2];
            int index = 0;
            for (int[] i : list) {
                res[index++] = i;
            }
            return res;
        }
    }
}
