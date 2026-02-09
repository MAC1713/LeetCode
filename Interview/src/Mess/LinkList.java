package Mess;

import Linklist.ListNode;

public class LinkList {
    public static ListNode merge(ListNode A, ListNode B){
        ListNode tmp = new ListNode(0);
        ListNode cur = tmp;
        while (A != null && B != null){
            if (A.val <= B.val){
                cur.next = A;
                A = A.next;
            }else {
                cur.next = B;
                B = B.next;
            }
            cur = cur.next;
        }
        cur.next = (A != null) ? A : B;
        return tmp.next;
    }

    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        A.next = new ListNode(3);
        A.next.next = new ListNode(5);
        ListNode B = new ListNode(1);
        B.next = new ListNode(2);
        B.next.next = new ListNode(6);
        ListNode res = merge(A, B);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
