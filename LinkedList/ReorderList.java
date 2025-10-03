package LinkedList;

import java.util.List;

public class ReorderList {

    public void reorderList(ListNode head) {
        ListNode middle = getMiddle(head);

        ListNode hs= reverseList(middle);
        middle.next = null;

        ListNode hf= head;

        // rearrange list
        while(hf!=null && hs!=null){
            ListNode temp = hf.next;
            hf.next=hs;
            hf=temp;

            temp= hs.next;
            hs.next=hf;
            hs=temp;
        }

        if(hf != null){
            hf.next=null;
        }

    }

    public ListNode reverseList(ListNode head){
        ListNode prev=null;
        ListNode present=head;
        ListNode next= present.next;

        while (present!=null){
            present.next=prev;
            prev=present;
            present=next;
            if(next!=null){
                next=next.next;
            }
        }

        return prev;
    }

    public ListNode getMiddle(ListNode head){
        ListNode s=head;
        ListNode f= head;

        while(f!=null&& f.next!=null){
            f=f.next.next;
            s=s.next;
        }

        return s;
    }


    public ListNode createList(int[] values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    // Helper method to print the list
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static void main(String[] args) {

        ReorderList reorderList= new ReorderList();
        int[] values = {1, 2, 3, 4};
        ListNode head = reorderList.createList(values);

        System.out.println("Original list:");
        reorderList.printList(head);

        reorderList.reorderList(head);

        System.out.println("Reordered list:");
        reorderList.printList(head);
    }
}
