package Linklist;

public class Two {
    int val;
    Two next;
    Two() {}
    Two(int val) { this.val = val; }
    Two(int val, Two next) { this.val = val; this.next = next; }
    public static void main(String[] args){
        Two one = new Two(5);
        Two two = new Two(6);
        Two head1 = one;
        Two head2 = two;
        for(int i = 1; i <= 5; i++){
//            one = one.next;
            one.next = new Two(i);
            one = one.next;
        }
        for(int i = 1; i <= 6; i++){
            two.next = new Two(i);
            two = two.next;
        }
//        ListNode.printList(head1);
//        ListNode.printList(head2);
          Two pre = Two.addTwoNumbers(head1, head2);
          Two.printList(pre);
//        System.out.println(ans);
    }

    public static Two addTwoNumbers(Two l1, Two l2) {
        Two pre = new Two(0);
        int carry = 0;
        Two cur = pre;
        while(l1 != null || l2 != null){
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum - 10 : sum;
            cur.next = new Two(sum);
            cur = cur.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if (carry == 1){
            cur.next = new Two(carry);
        }
        return pre.next;
    }

    public static void printList(Two list){
        while(list.next != null){
            System.out.println(list.val);
            list = list.next;
        }
    }
}

