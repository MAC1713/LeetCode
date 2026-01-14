package Linklist;

import static Linklist.Print.print;
import static Linklist.ListNode.*;

public class Twenty_five {
    class Solution {
        public static ListNode reverseKGroup(ListNode head, int k) {
            if(k == 0 || k == 1){
                return head;
            }
            ListNode testLength = head;
            for (int i = 0; i < k; i++) {
                if(testLength != null){
                    testLength = testLength.next;
                }else {
                    return head;
                }
            }
            ListNode start = head;
            ListNode vis = new ListNode(0);
            vis.next = start;
            ListNode newHead = vis;
            ListNode temp = vis;

            while (vis != null) {
                vis = reverseUntil(vis, k);
                temp = vis;
                temp = temp.next;
                for (int i = 0; i < k; i++) {
                    if (temp != null) {
                        temp = temp.next;
                    } else {
                        return newHead.next;
                    }
                }
            }
            return newHead.next;
        }

        public static ListNode reverseUntil(ListNode start, int k) {
            ListNode head = start;
            ListNode pre = head.next;
            ListNode pre_end = pre;
            ListNode cur = pre.next;
            for (int i = 0; i < k - 1; i++) {
                pre_end.next = cur.next;
                start.next = cur;
                cur.next = pre;
                pre = cur;
                cur = pre_end.next;
            }
            return pre_end;
        }
    }

    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        ListNode start = head;
        int k = 4;
        ListNode head = new ListNode(1);
        ListNode start = head;
        for (int i = 2; i < 20; i++) {
            head.next = new ListNode(i);
            head = head.next;
        }
        print(Solution.reverseKGroup(start, k));



//        print(start);



    }

}
