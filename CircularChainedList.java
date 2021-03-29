public class CircularChainedList {

    //rabbit & turtle
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode turtle = head;
        ListNode rabbit = head.next;
        while (rabbit != null && rabbit.next != null) {
            if (rabbit == turtle || rabbit.next == turtle)
                return true;
            rabbit = rabbit.next.next;
            turtle = turtle.next;
        }
        return false;
    }
}
