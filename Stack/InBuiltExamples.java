package Stack;

import java.util.*;

public class InBuiltExamples {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(23);
        stack.push(43);
        stack.push(53);
        stack.push(263);
        stack.push(20);

//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());


        Queue<Integer> queue = new LinkedList<>();
        queue.add(55);
        queue.add(45);
        queue.add(445);
        queue.add(90);

//        System.out.println(queue.remove());

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(44);
        deque.addFirst(222);
        deque.addLast(9999);
        System.out.println(deque.remove());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());


    }
}
