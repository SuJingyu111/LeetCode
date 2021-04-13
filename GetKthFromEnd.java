public class GetKthFromEnd {
    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode kthPrev = head;
            int cnt = 0;
            while (head != null) {
                if (cnt < k) {
                    cnt++;
                }
                else {
                    kthPrev = kthPrev.next;
                }
                head = head.next;
            }
            return kthPrev;
        }
    }
}
