package Stack;

public class DynamicStack extends CustomStack{


    public DynamicStack(){
        super();  // it will call CustomStack()
    }

    public DynamicStack(int size){
        super(size); // it will call CustomS
    }

    @Override
    public boolean push(int item) throws Exception {

        // this doubles the stack size when it gets full
        if(this.isFull()) {
            int[] temp = new int[data.length * 2];

            // copy all previous items to new data
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }

            data = temp;
        }
        // at this point array is not full
        // insert item

        return super.push(item);
    }
}
