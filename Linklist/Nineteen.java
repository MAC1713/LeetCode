//package Linklist;
//
//public class Nineteen {
//    static class Solution<ListNode> {
//        public static class ListNode {
//            int val;
//            ListNode next;
//
//            ListNode() {
//            }
//
//            ListNode(int val) {
//                this.val = val;
//            }
//
//            ListNode(int val, ListNode next) {
//                this.val = val;
//                this.next = next;
//            }
//        }
//
//        public ListNode removeNthFromEnd(ListNode head, int n) {
//            if(head.next == null && n != 0){
//                return null;
//            }
//            int length = 1;
//            ListNode temp = head;
//            while(temp.next != null){
//                length += 1;
//                temp = temp.next;
//            }
//            ListNode tmp = head;
//            if(length == n){
//                ListNode mp = head.next;
//                return mp;
//            }
//
//            for(int i = 1; i < length - n; i++){
//                tmp = tmp.next;
//            }
//            tmp.next = tmp.next.next;
//
//            return head;
//        }
//    }
//
//    public static void main(String[] args) {
//        Solution.ListNode linkedList = new Solution.ListNode(); //双向链表
//        for (int i = 0; i < 5; i++) {
//            linkedList.val = i;
//            linkedList = linkedList.next;
//        }
//
//    }
//}
