import java.util.*;

public class LargestNumber {
    class Solution {
        public String largestNumber(int[] nums) {
            if (nums.length == 0)
                return "";
            StringBuilder sb = new StringBuilder();
            Integer[] integers = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                integers[i] = nums[i];
            }
            Arrays.sort(integers, new Comparator<Integer>() {
                        public int compare(Integer i1, Integer i2) {
                            String s1 = i1.toString();
                            String s2 = i2.toString();
                            return (s2 + s1).compareTo(s1 + s2);
                        }
                        });
            for (int i : integers) {
                sb.append(i);
            }
            String res = sb.toString();
            if (res.charAt(0) == '0')
                res = "0";
            return res;
        }
    }
}
