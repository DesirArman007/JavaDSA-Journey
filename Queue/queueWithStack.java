package Queue;

import java.util.Stack;

public class queueWithStack {
    public static void main(String[] args) {

    }
}

class QueueUsingStack{
    private Stack<Integer> first;
    private Stack<Integer> second;


    public QueueUsingStack(){
        first=new Stack<>();
        second = new Stack<>();
    }
    public void add(int item){
        first.push(item);
    }

    public int remove() throws Exception{
        while(!first.isEmpty()){
            second.push(first.pop());
        }

        int removed = second.pop();
        while (!second.isEmpty()){
            first.push(second.pop());
        }
        return removed;
    }

    public int peek() throws Exception{
        while(!first.isEmpty()){
            second.push(first.pop());
        }

        int peeked = second.pop();
        second.push(peeked);
        while (!second.isEmpty()){
            first.push(second.pop());
        }
        return peeked;
    }

    // peek(in remove efficient)
//    public void add(int item) throws Exception{
//        while (!first.isEmpty()){
//            second.push(first.pop());
//        }
//
//        first.push(item);
//        while (!second.isEmpty()){
//            first.push(second.pop());
//        }
//    }

    // remove efficient
//    public int remove() throws Exception{
//        return first.pop();
//    }

    // peek(in remove efficient)
//    public int peek() throws Exception{
//        return first.peek();
//    }

    public boolean isEmpty(){
        return first.isEmpty();
    }
}
