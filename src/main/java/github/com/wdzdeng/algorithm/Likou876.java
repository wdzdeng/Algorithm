package github.com.wdzdeng.algorithm;

public class Likou876 {
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head.next;
        if (fast == null) return slow;
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
            if (fast == null) return slow;
            fast = fast.next;
        }
        return slow;
    }

}
