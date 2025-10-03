package LinkedList;

public class Palindrome {
    public static void main(String[] args) {
        Palindrome p = new Palindrome();

        // Example: 1 -> 2 -> 2 -> 1
        ListNode head = p.new ListNode(1,
                p.new ListNode(2,
                        p.new ListNode(2,
                                p.new ListNode(1))));

        System.out.println(p.isPalindrome(head)); // true
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // find middle
        ListNode midNode = getMiddleNode(head);
        // reverse second half
        ListNode rightHead = reverseList(midNode);
        // re-reverse head
        ListNode reverseHead=rightHead;

        // compare halves
        while (head!=null && rightHead != null) {
            if (head.val != rightHead.val){
                break;
            }
            head = head.next;
            rightHead = rightHead.next;
        }
        reverseList(reverseHead);

        // both return conditon are working the same
//        if(head==null || rightHead==null){
//            return true;
//        }
//        return false;
        return head == null || rightHead == null;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;
        while (present != null) {
            present.next = prev;
            prev = present;
            present =next;
            if(next!=null){
                next=next.next;
            }
        }
        return prev;
    }

    public ListNode getMiddleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
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
