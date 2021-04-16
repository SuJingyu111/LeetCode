public class MergeTwoLists {
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null || l2 == null)
                return l1 == null ? l2 : l1;
            ListNode cursor1 = l1;
            ListNode cursor2 = l2;
            ListNode res = new ListNode(Integer.MIN_VALUE);
            ListNode resCursor = res;
            while (cursor1 != null && cursor2 != null) {
                if (cursor1.val <= cursor2.val) {
                    resCursor.next = new ListNode(cursor1.val);
                    cursor1 = cursor1.next;
                    resCursor = resCursor.next;
                }
                else {
                    resCursor.next = new ListNode(cursor2.val);
                    cursor2 = cursor2.next;
                    resCursor = resCursor.next;
                }
            }
            resCursor.next = cursor1 == null ? cursor2 : cursor1;
            return res.next;
        }
    }
}
