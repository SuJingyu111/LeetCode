public class DeleteDuplicatesII {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode lastNode = null;
            ListNode newHead = null;
            while (head != null) {
                if (head.next == null || head.next.val != head.val) {
                    if (newHead == null) {
                        newHead = head;
                        lastNode = newHead;
                    }
                    else {
                        lastNode.next = head;
                        lastNode = lastNode.next;
                    }
                    head = head.next;
                }
                else {
                    int dupVal = head.val;
                    head = head.next;
                    while (head != null && head.val == dupVal) {
                        head = head.next;
                    }
                }
            }
            if (lastNode != null) {
                lastNode.next = null;
            }
            return newHead;
        }
    }
}
