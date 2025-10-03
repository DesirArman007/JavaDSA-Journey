package LinkedList;

public class DLL {
    private Node head;
    private Node tail;

    private int size;

    public DLL() {
        this.size = 0;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if(head != null){
            head.prev = node;
        }
        head = node;

        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void insertLast(int val){
        Node node = new Node(val);
        Node last = head;


        if(head==null){
            head.prev = null;
            head = node;
            return;
        }
//        if(tail == null){
//            head = node;
//            tail=head;
//        }
//        tail.next = node;
//        node.prev = tail;
//        node.next = null;
//        tail = node;

        // If tail is not provided

        while(last.next != null){
            last = last.next;
        }
        last.next = node;
        node.prev = last;
        node.next = null;

        size++;
    }

    public void insert(int after, int val){
        Node p =find(after);

        if(p==null){
            System.out.println("Does not exist");
            return;
        }

        Node node = new Node(val);
        node.next = p.next;
        p.next=node;
        node.prev = p;

        if(node.next != null){
            node.next.prev = node;
        }else {
            tail = node; // if inserted at the end, update tail
        }


    }

    public Node find(int val){
        Node node = head;

        while (node != null){
            if(node.val == val){
                return node;
            }
            node = node.next;
        }

        return null;
    }

    public void displayList(){
        Node temp =head;

        while (temp!= null){
            System.out.print(temp.val +" --> ");
            temp = temp.next;
        }
        System.out.print("END");
    }

    public void displayListinReverse(){
        Node temp =head;
        Node last = null;


        while (temp!= null){
            System.out.print(temp.val +" --> ");
            last=temp;
            temp = temp.next;
        }
        System.out.print("END");

        System.out.println();

        System.out.println("Print in reverse:");
        while (last != null){
            System.out.print(last.val + " --> ");
            last = last.prev;
        }
        System.out.println("START");


        // if tail is present

//        Node node = tail;
//        while (node != null){
//            System.out.print(node.val +" --> ");
//            node = node.prev;
//        }
//        System.out.print("START");
    }

    private class Node{
        private int val;
        private Node next;
        private Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
