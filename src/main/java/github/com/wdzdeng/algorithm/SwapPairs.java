package github.com.wdzdeng.algorithm;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode fastNode = head.next;
        ListNode slowNode = head;
        slowNode.next = fastNode.next;
        fastNode.next = slowNode;
        ListNode h = fastNode;
        ListNode pre = slowNode;
        if (slowNode.next == null) return h;
        else slowNode = slowNode.next;
        fastNode = slowNode.next == null ? slowNode : slowNode.next;
        while (true){
            if (fastNode == slowNode) return h;
            else {
                slowNode.next = fastNode.next;
                fastNode.next = slowNode;
                pre.next = fastNode;
                pre = slowNode;
                if (slowNode.next == null) return  h;
                slowNode = slowNode.next;
                fastNode = slowNode.next == null ? slowNode : slowNode.next;
            }
        }
    }

    public static void main(String[] args) {

    }
}
