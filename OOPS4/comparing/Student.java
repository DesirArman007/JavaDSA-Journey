package OOPS4.comparing;

public class Student implements Comparable<Student>{
    String name;
    Float marks;

    public Student(String name, Float marks){
        this.name=name;
        this.marks=marks;
    }

    @Override
    public int compareTo(Student o) {
        int diff = (int)(this.marks - o.marks);

        // if diff==0, means both are equal
        // if diff<0, means o is bigger else o is smaller
        return diff;
    }
}
