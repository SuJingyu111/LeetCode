import java.util.*;

public class ReverseLinkedListII {
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (left == right)
                return head;
            int idx = 0;
            ListNode resPrev = new ListNode();
            resPrev.next = head;
            ListNode cursor = resPrev;
            ListNode prev = resPrev;
            ListNode next = null;
            Deque<ListNode> stk = new LinkedList<>();
            while (idx <= right) {
                if (idx + 1 == left)
                    prev = cursor;
                if (idx >= left) {
                    stk.push(cursor);
                }
                if (idx == right)
                    next = cursor.next;
                idx += 1;
                cursor = cursor.next;
            }
            while (!stk.isEmpty()) {
                ListNode temp = stk.pop();
                //System.out.println(temp.val);
                prev.next = temp;
                prev = prev.next;
            }
            prev.next = next;
            return resPrev.next;
        }
    }
}

