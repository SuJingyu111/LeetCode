public class ReversePrintLinkedList {
    class Solution {
        public int[] reversePrint(ListNode head) {
            int cnt = 0;
            ListNode cursor = head;
            while (cursor != null) {
                cnt += 1;
                cursor = cursor.next;
            } 
            int[] res = new int[cnt];
            int idx = cnt - 1;
            while (head != null) {
                res[idx--] = head.val;
                head = head.next;
            }
            return res;
        }
    }
}
