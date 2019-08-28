package github.com.wdzdeng.algorithm;

import java.util.Stack;

public class ReverseKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode newHead = null;
        ListNode pre = null;
        int count = 0;
        while (head != null){
            stack.push(head);
            ++count;
            head = head.next;
            if (count == k){
                if (pre != null){
                    while (!stack.isEmpty()){
                        pre.next = stack.pop();
                        pre.next.next = null;
                        pre = pre.next;
                    }

                }else {
                    newHead = stack.pop();
                    pre = newHead;
                    while (!stack.isEmpty()){
                        pre.next = stack.pop();
                        pre.next.next = null;
                        pre = pre.next;
                    }
                }
                count = 0;
            }
        }
        if (pre == null){
            Stack<ListNode> s  = new Stack<>();
            while (!stack.isEmpty()){
                s.push(stack.pop());
            }
            while (!s.isEmpty()){
                if (newHead == null){
                    ListNode node = s.pop();
                    newHead = node;
                    pre = node;
                    pre.next = null;
                }else {
                    pre.next = s.pop();
                    pre.next.next = null;
                    pre = pre.next;
                }

            }
        }

        if (!stack.isEmpty()){
            Stack<ListNode> s  = new Stack<>();
            while (!stack.isEmpty()){
                s.push(stack.pop());
            }
            while (!s.isEmpty()){
                pre.next = s.pop();
                pre.next.next = null;
                pre = pre.next;
            }

        }
        return newHead;


    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode pre = head;


        ListNode newHead = reverseKGroup(head,2);
        while (newHead != null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
