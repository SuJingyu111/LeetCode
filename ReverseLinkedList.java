public class ReverseLinkedList {
    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            ListNode temp = head;
            ListNode dummy = new ListNode();
            ListNode prev = dummy;
            while (head != null) {
                ListNode nex = head.next;
                head.next = prev;
                prev = head;
                head = nex;
            }
            temp.next = null;
            return tail;
        }
    }
}
