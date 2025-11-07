package OOPS4;

public class staticExample {
    public static void main(String[] args) {

        staticExample s = new staticExample();
        s.greeting();
        fun();
    }

    static void fun(){
        System.out.println("I am having fun");

    }

    void greeting(){
        System.out.println("Hello how are you doing");
    }
}
