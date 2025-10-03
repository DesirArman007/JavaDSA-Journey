package LinkedList;

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        ListNode current = head;
        ListNode prev = null;



        while (true) {
            if (length < k) {
                break;
            }
            ListNode last=prev;
            ListNode newEnd = current;
            ListNode next = current.next;
            for(int i=0; current!=null && i<k ;  i++){
                current.next=prev;
                prev=current;
                current=next;
                if(next!=null){
                    next=next.next;
                }
                length--;
            }

            if(last!=null){
                last.next=prev;
            }else{
                head=prev;
            }
            newEnd.next=current;

            if(current==null){
                break;
            }

            prev=newEnd;
        }
        return head;


    }


    // reverse alternate k group
    public ListNode reverseAlternateKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        ListNode current = head;
        ListNode prev = null;



        while (current !=null) {
            if (length < k) {
                break;
            }
            ListNode last=prev;
            ListNode newEnd = current;
            ListNode next = current.next;
            for(int i=0; current!=null && i<k ;  i++){
                current.next=prev;
                prev=current;
                current=next;
                if(next!=null){
                    next=next.next;
                }
                length--;
            }

            if(last!=null){
                last.next=prev;
            }else{
                head=prev;
            }
            newEnd.next=current;

            // skip the k Nodes
            for(int i=0; current != null && i<k;i++){
                prev=current;
                current=current.next;
            }
        }
        return head;


    }

    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

    public static void main(String[] args) {

    }
}
