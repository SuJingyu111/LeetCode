public class RemoveElementFromLinkedList {
    /**
    * Definition for singly-linked list.
    * public class ListNode {
    *     int val;
    *     ListNode next;
    *     ListNode() {}
    *     ListNode(int val) { this.val = val; }
    *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    * }
    */
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) {
                return head;
            }
            ListNode cursor = head;
            while (cursor.next != null) {
                if (cursor.val == val) {
                    head = cursor.next;
                    cursor = head;
                }
                else if (cursor.next.val == val){
                    cursor.next = cursor.next.next;
                }
                else {
                    cursor = cursor.next;
                }
            }
            if (head.val == val) {
                return null;
            }
            return head;
        }
    }
}
