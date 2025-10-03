package Queue;

public class MainQueue {
    public static void main(String[] args) throws Exception {
        CustomQueue queue = new CustomQueue(5);
        queue.insert(66);
        queue.insert(23);
        queue.insert(34);
        queue.insert(14);
        queue.insert(4324);

        queue.display();
        System.out.println(queue.remove());
        queue.display();
    }
}
