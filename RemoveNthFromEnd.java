import java.util.*;
import javafx.util.Pair;

public class RemoveNthFromEnd {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            List<Pair<ListNode, ListNode>> pcList = new ArrayList<Pair<ListNode, ListNode>>();//parent current
            ListNode dummy = new ListNode();
            dummy.next = head;
            pcList.add(new Pair<ListNode, ListNode>(dummy, head));
            while (head.next != null) {
                pcList.add(new Pair<ListNode, ListNode>(head, head.next));
                head = head.next;
            }
            int idx = pcList.size() - n;
            Pair<ListNode, ListNode> thisPair = pcList.get(idx);
            thisPair.getKey().next = thisPair.getValue().next;
            return dummy.next;
        }
    }
}
