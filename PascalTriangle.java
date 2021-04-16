public class PascalTriangle {
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            List<Integer> list = new ArrayList<Integer>();
            list.add(1);
            res.add(list);
            List<Integer> lastList = res.get(0);
            List<Integer> newList;
            for (int i = 2; i <= numRows; i++) {
                int size = lastList.size();
                newList = new ArrayList<Integer>();
                newList.add(1);
                for (int j = 1; j <= size - 1; j++) {
                    newList.add(lastList.get(j) + lastList.get(j - 1));
                }
                newList.add(1);
                res.add(newList);
                lastList = newList;
            }
            return res;
        }
    }
}
