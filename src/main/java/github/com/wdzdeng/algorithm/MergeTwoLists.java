package github.com.wdzdeng.algorithm;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode nodePoint = node;
        while (l1 != null || l2 != null){
            if (l1 == null ){
                nodePoint.next = l2;
                break;
            }
            if (l2 == null){
                nodePoint.next = l1;
                break;
            }
            if (l1.val < l2.val){
                nodePoint.next = l1;
                nodePoint = l1;
                l1 = l1.next;

            }else {
                nodePoint.next = l2;
                nodePoint = l2;
                l2 = l2.next;
            }
        }
        return node.next;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
