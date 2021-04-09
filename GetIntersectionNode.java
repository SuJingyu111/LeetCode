public class GetIntersectionNode {
    public class Solution {

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null)
                return null;
            if (headA == headB) 
                return headA;
            ListNode cursorA = headA;
            ListNode cursorB = headB;
            while (cursorA != cursorB) {
                cursorA = cursorA == null ? headB : cursorA.next;
                cursorB = cursorB == null ? headA : cursorB.next;
            }       
            return cursorA;
        }
    } 
}
