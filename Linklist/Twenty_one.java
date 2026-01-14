//package Linklist;
//
//public class Twenty_one {
//    class Solution {
//        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//            ListNode ans = new ListNode(0);
//            ListNode head = ans;
//            while(list1 != null && list2 != null){
//                if(list1.val <= list2.val){
//                    head.next = list1;
//                    head = head.next;
//                    list1 = list1.next;
//                }else {
//                    head.next = list2;
//                    head = head.next;
//                    list2 = list2.next;
//                }
//            }
//            if(list1 == null && list2 != null){
//                head.next = list2;
//            }else if(list2 == null && list1 != null){
//                head.next = list1;
//            }
//            return ans.next;
//        }
//    }
//}
