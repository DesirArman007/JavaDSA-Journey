package College;

import java.util.HashMap;

public class CountFrequency {
    public static void main(String[] args) {

        int[] arr ={2,3,4,5,2,3,4,5,5,5};

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i< arr.length; i++){
            int k=arr[i];
            if(map.containsKey(k)){
                map.put(k,map.get(k)+1);
            }else{
                map.put(k,1);
            }
        }

        System.out.println(map);
    }
}
