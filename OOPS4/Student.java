package OOPS4;

import java.util.Arrays;

public class Student {
    String name;
    int rollno;
    float marks;

//
//    Student(){
//        kunal.ro=12;
//        kunal.name="kunal";
//        kunal.marks=55.5;
//    }

    public static void main(String[] args) {
        Student student1 = new Student();
        Student[] s = new Student[5];
        System.out.println(student1.toString());
        System.out.println(Arrays.toString(s));
    }
}


