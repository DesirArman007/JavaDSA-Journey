package OOPS4;

public class Human {
    int age;
    String name;
    boolean marriage;
    static long population;

    static void print(){
        // cannot use this because it needs an object
//        System.out.println("Age is "+ this.age);
    }

    public Human(int age, String name, boolean marriage) {
        this.age = age;
        this.name = name;
        this.marriage = marriage;
        Human.population +=1;
    }
}
