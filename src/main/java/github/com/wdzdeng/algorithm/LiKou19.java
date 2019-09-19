package github.com.wdzdeng.algorithm;

public class LiKou19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode slowPre = head;
        ListNode fast = head;
        if (n == 1 && fast.next == null) return  null;
        for (int i = 1; i <= n-1; ++i){
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            if (fast != null){
                slowPre = slow;
                slow = slow.next;
            }
        }
        if (slowPre == slow) return slowPre.next;
        slowPre.next = slow.next;
        return head;

    }

}
