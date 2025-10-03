package Stack;

public class StackMain {
    public static void main(String[] args) throws Exception {
//        CustomStack stack = new CustomStack(5);
        DynamicStack stack = new DynamicStack();
        stack.push(23);
        stack.push(43);
        stack.push(53);
        stack.push(263);
        stack.push(2570);
        stack.push(2000);
        stack.push(200);
        stack.push(278780);
        System.out.println(stack.peek());



    }
}
