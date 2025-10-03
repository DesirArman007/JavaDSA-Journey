package LinkedList;

public class Main {
    public static void main(String[] args) {
        LL list = new LL();

        list.insertFirst(5);
        list.insertFirst(15);
        list.insertFirst(56);
        list.insertFirst(50);
        list.insertFirst(4);
        list.insert(44,2);
        list.insertLast(100);
//        System.out.println(list.deleteFirst());
//        System.out.println(list.deleteFirst());
//        System.out.println(list.deleteLast());
        list.displayList();
        list.insertRec(88,2);
        System.out.println();
        list.displayList();
//        System.out.println();
//        System.out.println(list.delete(2));
//        list.displayList();
//        System.out.println();
//        System.out.println(list.find(56));

//        DLL list = new DLL();
//        list.insertFirst(11);
//        list.insertFirst(31);
//        list.insertFirst(141);
//        list.insertFirst(5);
////        list.displayList();
//        list.insertLast(99);
//        list.displayListinReverse();
//        list.insert(141,69);
//        list.displayListinReverse();


//        CLL list = new CLL();
//
//        list.insert(5);
//        list.insert(2);
//        list.insert(45);
//        list.insert(99);
//        list.display();
//        list.delete(45);
//        list.display();


    }



}
