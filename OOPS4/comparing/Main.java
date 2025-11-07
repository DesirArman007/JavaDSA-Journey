package OOPS4.comparing;

public class Main {
    public static void main(String[] args) {

        Student rahul = new Student("Rahul",98.75f);
        Student kunal = new Student("Kunal",78.75f);



        if(kunal.compareTo(rahul) < 0){
            // if compare to gives negative which means the other obj "Rahul" is bigger
            // else the obj u are using to compare is bigger
            
            System.out.println("Rahul marks: "+rahul.marks +" "+"Kunal marks"+kunal.marks);
            System.out.println("Rahul has more marks");
        }
    }
}
