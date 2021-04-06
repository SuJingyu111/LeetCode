public class DeleteDuplicates {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode cursor = head.next;
            ListNode thisNode = head;
            while (cursor != null) {
                if (cursor.val == thisNode.val) {
                    thisNode.next = cursor.next;
                }
                else {
                    thisNode = cursor;
                }
                cursor = cursor.next;
            }
            return head;
        }
    }
}
