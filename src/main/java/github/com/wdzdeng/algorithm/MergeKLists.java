package github.com.wdzdeng.algorithm;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length<1) return null;
        if (lists.length == 1) return lists[0];
        ListNode p = mergeTwoLists(lists[0],lists[1]);
        if (lists.length == 2) return p;
        for (int i = 2; i< lists.length; ++i){
            p = mergeTwoLists(p,lists[i]);
        }
        return p;
    }

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
