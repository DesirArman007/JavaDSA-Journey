package OOPS4.Generics;

import java.util.Arrays;

public class CustomArraylist {

    private int[] data ;
    private static int DEFAULT_SIZE=10;
    private int size=0; // also working as index value


    public CustomArraylist(){
        this.data = new int[DEFAULT_SIZE];
    }


    public void add(int num){
        if (isFull()) {

            resize();
        }

        data[size++] = num;
    }

    private void resize() {
        int[] temp = new int[data.length*2];

        for(int i=0; i< data.length; i++){
            temp[i] =data[i];
        }
        data=temp;
    }

    private boolean isFull() {
        return size==data.length;
    }


    public int remove(){
        int removed = data[--size];
        return removed;
    }


    public int get(int index){
        return data[index];
    }

    public int size(){
        return size;
    }

    public void set(int index, int value){
        data[index] = value;
    }

    @Override
    public String toString() {
        return " CustomArrayList{" +
                "data="+Arrays.toString(data)+",size = "+size+"}";
    }

    public static void main(String[] args) {
        CustomArraylist list = new CustomArraylist();
//        list.add(5);
//        list.add(25);
//        list.add(50);

        for(int i=0; i<15; i++){
            list.add(2*i);
        }
        System.out.println(list);

    }

}
