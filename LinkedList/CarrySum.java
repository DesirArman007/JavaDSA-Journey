package LinkedList;

public class CarrySum {
    private Node head;
    private Node tail;
    int size = 0;

    public CarrySum() {
        this.size = 0;
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }

        size += 1;
    }

    public void displayList() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.val + " --> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void reverse() {
        if (size < 2) {
            return;
        }

        Node prev = null;
        Node present = head;
        Node next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        head = prev;
    }

    public Node carryForward(Node head, int carry) {
        if (head == null) {
            if (carry == 0)
                return null;
            else
                return new Node(carry);
        }

        Node temp = head;
        Node prev = null;

        while (temp != null && carry > 0) {
            int newVal = temp.val + carry;
            temp.val = newVal % 10;
            carry = newVal / 10;
            prev = temp;
            temp = temp.next;
        }

        // If carry is still left after reaching the end, add new nodes
        while (carry > 0) {
            prev.next = new Node(carry % 10);
            carry = carry / 10;
            prev = prev.next;
        }

        return head;
    }

    private class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        CarrySum p = new CarrySum();

        p.insertFirst(9);
        p.insertFirst(9);
        p.insertFirst(9);

        System.out.println("List before carryForward:");
        p.displayList();
        p.carryForward(p.head, 15);
        p.reverse();
        System.out.println("List after carryForward with carry = 15:");
        p.displayList();
    }
}
