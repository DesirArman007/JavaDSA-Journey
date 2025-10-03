package LinkedList;

import java.util.List;

public class LL {
    private Node head;
    private Node tail;
    private int size;


    public LL() {
        this.size=0;
    }


    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        // because head always points to 1st node
        head=node;

        if(tail==null){
            tail=head;
        }

        size+=1;
    }

    public void insertLast(int val){
        if(tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail=node;

        size++;
    }

    public void insert(int val, int index){
        if(index ==0){
            insertFirst(val);
            return;
        }

        if(index==size){
            insertLast(val);
            return;
        }

        Node temp = head;
        for(int i=1; i<index; i++){
            temp = temp.next;
        }
        // temp.next links the node to the next element (We found it because of the loop)
        Node node = new Node(val, temp.next);
        temp.next=node;
        size++;
    }

    // Insert using recursion
    public void insertRec(int val, int index){
        // head is the last element that gets returned
        head = insertRec(val,index,head);
    }

    private Node insertRec(int val, int index, Node node){

        // we reached position to insert element
        if(index==0){
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        // if base conditon not matched move forward
        // if a node is inserted while returning the nodes this call below will link "preNode.next -> created node"
        node.next = insertRec(val, index-1,node.next);
        // return the node you get
        return node;
    }

    public int deleteFirst(){
        int val = head.val;
        head = head.next;
        if(head==null){
            tail=head;
        }
        size--;
        return val;

    }

    public int deleteLast(){
        if(size <=1){
           return deleteFirst();
        }

        Node secondLast = get(size-2);
        int val = tail.val;
        tail = secondLast;
        tail.next=null;

        size--;
        return val;
    }

    public int delete(int index){
        if(size <=1){
            return deleteFirst();
        }

        if(index ==size-1){
            return deleteLast();
        }


       Node prev = get(index);
        int value = prev.next.val;
        prev.next = prev.next.next;
        size--;

        return value;
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

   public Node get(int index){
        Node node = head;
    //ChatGPT said:
       //
       //Correct. You already start with head in node. That means you are already positioned at index 1 (in your 1-based version).
       // The loop only needs to move the remaining steps, not the full index steps.
        for(int i=1; i<index; i++){
            node = node.next;
        }

        return node;
   }



    public void displayList(){
        Node temp =head;

        while (temp!= null){
            System.out.print(temp.val +" --> ");
            temp = temp.next;
        }
        System.out.print("END");
    }




    private class Node{
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


    // reoder list
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;

        ListNode middle = middleNode(head);

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

// bubble sort using recursion
    public void bubbleSort(){
        bubbleSort(size-1,0);
    }

    private void bubbleSort(int row, int col){
        if(row==0){
            return;
        }

        if(row>col){
            Node first = get(col);
            Node second = get(col+1);

            if(first.val > second.val){
                // swap
                if(first==head){
                    head=second;
                    first.next=second.next;
                    second.next=first;
                } else if (second==tail) {
                    Node prev = get(col-1);
                    prev.next =  second;
                    tail=first;
                    first.next=null;
                    second.next=tail;
                }else {
                    Node prev = get(col-1);
                    prev.next=second;
                    first.next=second.next;
                    second.next=first;
                }
            }
            bubbleSort(row,col+1);
        }else {
            bubbleSort(row-1,0);
        }
    }

    // Recursion reverse
    private void reverse(Node node){
        if(node == tail){
            head=tail;
            return;
        }

        reverse(node.next);
        tail.next=node;
        tail=node;
        tail.next=null;
    }

    // in place reversal of linked list
    public void reverse(){
        if(size<2){
            return;
        }

        Node prev=null;
        Node present = head;
        Node next = present.next;

        while(present!=null){
            present.next=prev;
            prev=present;
            present=next;
            if(next!=null){
                next=next.next;
            }
        }
        head=prev;
    }

    // linked list reverse II
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right){
            return head;
        }

        // skip the first left-1 nodes
        ListNode current =head;
        ListNode prev=null;
        for(int i=0; current!=null && i<left-1; i++){
            prev=current;
            current=current.next;
        }


        ListNode last=prev;
        ListNode newEnd = current;

        // reverse between left and right
        // number of elements between left and right: right-left+1
        ListNode next = current.next;
        for(int i=0; current!=null && i<right-left+1; i++){
            current.next=prev;
            prev=current;
            current=next;
            if(next!=null){
                next=next.next;
            }
        }

        if(last!=null){
            last.next=prev;
        }else{
            head=prev;
        }
        newEnd.next=current;
        return head;
    }






    public static void main(String[] args) {
        LL list1 = new LL();
        LL list2 = new LL();

        list1.insertLast(1);
        list1.insertLast(2);
        list1.insertLast(5);

        list2.insertLast(1);
        list2.insertLast(3);
        list2.insertLast(4);
        list2.insertLast(7);
        list2.insertLast(12);

        merge(list1,list2);
        LL list = new LL();

        list.insertLast(5);
        list.insertLast(1);
        list.insertLast(4);
        list.insertLast(2);
        list.insertLast(8);
        System.out.println();
        list.displayList();
        System.out.println();// before sorting
        list.bubbleSort();
        list.displayList();     // after sorting

    }


    // merge two sorted linked list

    public static void merge(LL list1, LL list2){
        Node f  = list1.head;
        Node s = list2.head;

        LL ans = new LL();

        while (f != null && s!= null ){
            if(f.val < s.val){
                ans.insertLast(f.val);
                f=f.next;
            }
            else{
                ans.insertLast(s.val);
                s=s.next;
            }
        }

        while (f!=null){
            ans.insertLast(f.val);
            f=f.next;
        }
        while (s!=null){
            ans.insertLast(s.val);
            s=s.next;
        }
        ans.displayList();
    }
}
