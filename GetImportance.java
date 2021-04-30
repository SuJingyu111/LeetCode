import java.util.*;

public class GetImportance {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    class Solution {
        public int getImportance(List<Employee> employees, int id) {
            int res = 0;
            Map<Integer, Employee> employeesMap = new HashMap<Integer, Employee>();
            for (Employee e : employees) {
                employeesMap.put(e.id, e);
            }
            Deque<Integer> q = new LinkedList<Integer>();
            q.add(id);
            while (!q.isEmpty()) {
                res += employeesMap.get(q.peek()).importance;
                List<Integer> thisSubordinates = employeesMap.get(q.pop()).subordinates;
                for (Integer sub : thisSubordinates) {
                    q.add(sub);
                }
            }
            return res;
        }
    }
}
