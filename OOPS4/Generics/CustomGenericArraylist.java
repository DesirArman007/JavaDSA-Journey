package OOPS4.Generics;

import java.util.Arrays;
import java.util.Objects;

public class CustomGenericArraylist<T> {

    private Object[] data ;
    private static int DEFAULT_SIZE=10;
    private int size=0; // also working as index value


//    public CustomGenericArraylist(){
//        this.data = new T[DEFAULT_SIZE];
//    }
    public CustomGenericArraylist(){
        this.data = new Object[DEFAULT_SIZE];
    }




    public void add(T num){
        if (isFull()) {

            resize();
        }

        data[size++] = num;
    }

    private void resize() {
        Object[] temp = new Object[data.length*2];

        for(int i=0; i< data.length; i++){
            temp[i] =(T) data[i];
        }
        data=temp;
    }

    private boolean isFull() {
        return size==data.length;
    }


    public T remove(){
        T removed = (T) data[--size];
        return removed;
    }


    public T get(int index){
        return (T) data[index];
    }

    public int size(){
        return size;
    }

    public void set(int index, T value){
        data[index] = value;
    }

    @Override
    public String toString() {
        return " CustomArrayList{" +
                "data="+Arrays.toString(data)+",size = "+size+"}";
    }

    public static void main(String[] args) {
        CustomGenericArraylist<Integer> list = new CustomGenericArraylist();
//        list.add(5);
//        list.add(25);
        list.add(50);
        for(int i=0; i<15; i++){
            list.add(2*i);
        }
        System.out.println(list);

    }

}
