package Linklist;

import static Linklist.Print.print;
import static Linklist.ListNode.*;
public class Twenty_four{
    class Solution {
        public static ListNode swapPairs(ListNode head) {
            ListNode len = head;
            if(head == null || len.next == null){
                return head;
            }else if(len.next.next == null){
                ListNode two = head.next;
                two.next = head;
                head.next = null;
                return two;
            }else{
                ListNode pre = head;
                ListNode tmp = pre.next;
                pre.next = tmp.next;
                tmp.next = pre;
                ListNode before = pre.next;
                ListNode after = before.next;
                while(after != null){
                    pre.next = before.next;
                    before.next = after.next;
                    after.next = before;
                    pre = pre.next.next;
                    before = before.next;
                    for(int i = 0; i < 3; i++){
                        if(after != null){
                            after = after.next;
                        }else{
                            return tmp;
                        }
                    }
                }
                return tmp;
            }
        }
    }
    public static void main(String[] args) {

        ListNode head=new ListNode(0);
        ListNode start = head;
        for (int i = 1; i < 9; i++) {
            head.next = new ListNode(i);
            head = head.next;
        }
        print(start);
        System.out.println("\n|");
        System.out.println("V");
        print(Solution.swapPairs(start));
    }
}

