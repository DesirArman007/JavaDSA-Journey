package OOPS4;

public class SingletonClassEx {

    private SingletonClassEx(){

    }

    private static SingletonClassEx instance;

    public static SingletonClassEx getInstance(){
        // check whether one obj only created or not
        if(instance==null){
            instance = new SingletonClassEx();
        }
        return instance;
    }
}
