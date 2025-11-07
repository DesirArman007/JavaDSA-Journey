package OOPS4;

public class StaticIntalizeDemo {
    static int a=4;
    static int b;

    static{
        System.out.println("I am static block");
        b = a*5;
    }

    public static void main(String[] args) {
        StaticIntalizeDemo obj = new StaticIntalizeDemo();
        System.out.println(StaticIntalizeDemo.a +" "+StaticIntalizeDemo.b);
    }
}
