package LinkedList;

public class MiddleNode {
    public static void main(String[] args) {
        MiddleNode obj = new MiddleNode();

        // build list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = obj.new ListNode(1);
        head.next = obj.new ListNode(2);
        head.next.next = obj.new ListNode(3);
        head.next.next.next = obj.new ListNode(4);
        head.next.next.next.next = obj.new ListNode(5);

        // find middle
        ListNode mid = obj.middleNode(head);
        System.out.println("Middle node value: " + mid.val); //
    }

    public ListNode middleNode(ListNode head) {
        ListNode fast=head;
        ListNode slow = head;
        while(fast!=null && fast.next !=null){
            fast=fast.next.next;
            slow=slow.next;

        }
        return slow;
    }

       public class ListNode {
          int val;
           ListNode next;
           ListNode() {}
           ListNode(int val) { this.val = val; }
           ListNode(int val, ListNode next) { this.val = val; this.next = next; }
       }

}
