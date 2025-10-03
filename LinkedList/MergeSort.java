package LinkedList;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();

        // Build linked list: 4 -> 2 -> 1 -> 3
        ListNode head = ms.new ListNode(4);
        head.next = ms.new ListNode(2);
        head.next.next = ms.new ListNode(1);
        head.next.next.next = ms.new ListNode(3);

        System.out.print("Original: ");
        ms.printList(head);

        ListNode sorted = ms.sortList(head);

        System.out.print("Sorted:   ");
        ms.printList(sorted);
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode mid = middleNode(head); // found the middle node

        ListNode rightHead = mid.next;  // start of right half
        mid.next = null;
        ListNode left = sortList(head); // now call sortList on the left part

        ListNode right = sortList(rightHead); // call sortList on the right part

        return merge(left,right);
    }

    public ListNode merge(ListNode list1, ListNode list2){
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;

        while (list1 != null && list2 != null){
            if(list1.val < list2.val){
                tail.next = list1;
                list1 = list1.next;
                tail=tail.next;
            } else{
                tail.next = list2;
                list2=list2.next;
                tail=tail.next;
            }
        }
        tail.next =(list1 !=null)? list1:list2;
        return dummyHead.next;
    }

    public ListNode middleNode(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast!=null && fast.next !=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
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
}
