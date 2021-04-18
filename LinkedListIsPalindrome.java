import java.util.*;

public class LinkedListIsPalindrome {
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }
            Deque<Integer> queue = new LinkedList<Integer>();
            while (head != null) {
                queue.add(head.val);
                head = head.next;
            }
            boolean isPalindrome = true;
            while (queue.size() > 1) {
                if (queue.remove() != queue.removeLast())
                    isPalindrome = false;
            }
            return isPalindrome;
        }
    }
}
