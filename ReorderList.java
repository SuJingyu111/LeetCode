import java.util.*;

public class ReorderList {
    class Solution {
        public void reorderList(ListNode head) {
            Deque<ListNode> stk = new LinkedList<ListNode>();
            ListNode cursor = head.next;
            head.next = null;
            while (cursor != null) {
                ListNode temp = cursor.next;
                cursor.next = null;
                stk.push(cursor);
                cursor = temp;
            }
            boolean signal = true;
            while (!stk.isEmpty()) {
                ListNode thisNode = signal ? stk.pop() : stk.removeLast();
                signal = signal ? false : true;
                head.next = thisNode;
                head = thisNode;
            }
        }
    }
}
