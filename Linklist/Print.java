package Linklist;

public class Print {
    public static void print(ListNode a){
        System.out.println("\n|");
        System.out.println("V");
        if(a != null){
            System.out.print(a.val);
        }
        a = a.next;
        while (a!=null){
            System.out.print(" -> " + a.val);
            a=a.next;
        }
    }
}
