package LinkedList;

public class RotateList {


    public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head==null){
            return head;
        }
        int length=1;

        ListNode last = head;
        while(last.next != null) {
            length++;
            last = last.next;
        }
        last.next=head;


        int rotations= k%length;

        ListNode newLast = head;
        // skip the length-k elements
        for(int i=0; i<length-rotations-1; i++){
            newLast=newLast.next;

        }

        // gettign the new head and breaking the loop
        ListNode newHead = newLast.next;
        newLast.next = null;

        return newHead;
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
