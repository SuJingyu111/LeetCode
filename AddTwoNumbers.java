class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoNumbers {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int overflow = 0;
            ListNode result = l1;
            ListNode resultCursor = result;
            ListNode last = l1;
            while (l1 != null && l2 != null) {
                int tempResult = l1.val + l2.val + overflow;
                resultCursor.val = tempResult % 10;
                overflow = tempResult / 10;
                resultCursor = resultCursor.next;
                last = l1;
                l1 = l1.next;
                l2 = l2.next;
            }
            if (l1 != null) {
                propagate(l1, overflow);
                return result;
            }
            else if (l2 != null) {
                last.next = l2;
                propagate(l2, overflow);
                return result;
            }
            else 
                if (overflow == 0)
                    return result;
                else {
                    last.next = new ListNode(overflow);
                    return result;
                }
        }
    
        private void propagate (ListNode node, int overflow) {
            ListNode last = node;
            while (node != null) {
                int tempResult = node.val + overflow;
                node.val = tempResult % 10;
                overflow = tempResult / 10;
                last = node;
                node = node.next;
            }
            if (overflow == 1) {
                last.next = new ListNode(overflow);
            }
        }
    }
}


