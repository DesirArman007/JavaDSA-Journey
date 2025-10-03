package LinkedList;

public class CycleQuestion {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

    }
    public static void main(String[] args) {
        CycleQuestion cq = new CycleQuestion();

        ListNode head = cq.new ListNode(1);
        head.next = cq.new ListNode(2);
        head.next.next = cq.new ListNode(3);
        head.next.next.next = cq.new ListNode(4);
        head.next.next.next.next = cq.new ListNode(5);
        // create cycle
        head.next.next.next.next.next = head.next.next; // 5 -> 3

        System.out.println("Cycle present? " + cq.hasCycle(head));  // true
        System.out.println("Cycle length: " + cq.cycleLength(head)); // 3

        // no cycle case
        ListNode head2 = cq.new ListNode(10);
        head2.next = cq.new ListNode(20);
        head2.next.next = cq.new ListNode(30);

        System.out.println("Cycle present? " + cq.hasCycle(head2));  // false
        System.out.println("Cycle length: " + cq.cycleLength(head2)); // 0
    }

    // check if cycle is present
    public boolean hasCycle(ListNode head) {
        ListNode fast= head;
        ListNode slow = head;

        while(fast != null && fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                return true;
            }
        }

        return false;
    }


    // Find legth of the cycle
    public int cycleLength(ListNode head) {
        ListNode fast= head;
        ListNode slow = head;
        while(fast != null && fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
               //calculate the length
                ListNode temp =slow;
                int length=0;
                do{
                    temp=temp.next;
                    length++;
                }while (temp!=slow);
                return length;
            }
        }

        return 0;
    }

    // detecting the cycle
    public ListNode detectCycle(ListNode head) {
        int length =0;
            ListNode fast= head;
            ListNode slow = head;

            while(fast != null && fast.next!= null){
                fast = fast.next.next;
                slow = slow.next;
                if(fast==slow){
                   length = cycleLength(slow);
                   break;
                }
            }

            if(length==0) {
                return null;
            }
            // find the start node
            ListNode f = head;
            ListNode s = head;
            while (length>0){
                s=s.next;
                length--;
            }

            // keep moving both forward and they will meet at cycle start
            while (f!=s){
                f=f.next;
                s=s.next;
            }
            return s;
    }

    // happy number
//    public boolean isHappy(int n) {
//
//    }
}



