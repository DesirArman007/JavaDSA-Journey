package HashMaps;

import javax.swing.text.html.parser.Entity;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PrimitiveIterator;


class MapUsingHash{

    private Entity[] entities;

    public MapUsingHash(){
        entities = new Entity[100];
    }

    public void put(String key, String value){
        int hash = Math.abs(key.hashCode() % entities.length);
        entities[hash] = new Entity(key,value); // overriding
    }

    public String get(String key){
        int hash = Math.abs(key.hashCode() % entities.length);
        if(entities[hash] !=null && entities[hash].key.equals(key)){
            return entities[hash].value;
        }
        return null;
    }

    public void remove(String key){
        int hash = Math.abs(key.hashCode() % entities.length);
        if(entities[hash] !=null && entities[hash].key.equals(key)){
            entities[hash] =null;
        }
    }

    private class Entity{
        String key;
        String value;

        public Entity(String key, String value){
            this.key=key;
            this.value=value;
        }
    }
}





public class MapExample {

    public static void main(String[] args) {

        MapUsingHash MAP = new MapUsingHash();
        MAP.put("kk","Crush");
        System.out.println(MAP.get("kk"));




        HashMap<String, Integer> map = new HashMap<>();

        map.put("kunal", 888);
        map.put("komal", 8);
        map.put("kavi", 7);

        System.out.println(map);
        System.out.println(map.get("komal"));
        System.out.println(map.getOrDefault("kunal", 95));
        System.out.println(map.containsKey("komal"));
        System.out.println(map.containsValue(8));


        HashSet<Integer> set = new HashSet<>();
        set.add(5);
        set.add(88);
        set.add(007);
        set.add(56);
        set.add(007);

        System.out.println(set);
    }
}
