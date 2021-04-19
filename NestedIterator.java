import java.util.*;

public class NestedIterator {
    public class NestedIterator implements Iterator<Integer> {
        private Iterator<NestedInteger> nestedIterator;
        int pos;
        Deque<Integer> pool;
    
        public NestedIterator(List<NestedInteger> nestedList) {
            this.nestedIterator = nestedList.iterator();
            pos = 0;
            pool = new LinkedList<Integer>();
        }
    
        @Override
        public Integer next() {
            return pool.poll();
        }
    
        private void dfs(NestedInteger nt) {
            if (nt.isInteger()) {
                Integer i = nt.getInteger();
                pool.add(i);
            }
            else {
                List<NestedInteger> list = nt.getList();
                for (NestedInteger newNt : list) {
                    dfs(newNt);
                }
            }
        }
    
         @Override
        public boolean hasNext() {
            while (nestedIterator.hasNext()) {
                dfs(nestedIterator.next());
            }
            return !pool.isEmpty();
        }
    }
    
}
