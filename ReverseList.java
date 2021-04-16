public class ReverseList {
    class Solution {
        ListNode res;
        public ListNode reverseList(ListNode head) {
            if (head == null)
                return null;
            ListNode last = helper(head);
            last.next = null;
            return res;
        }
    
        private ListNode helper(ListNode head) {
            if (head.next == null) {
                res = head;
                return head;
            }
            ListNode prev = helper(head.next);
            prev.next = head;
            return head;
        }
    }
}
