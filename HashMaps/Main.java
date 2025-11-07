package HashMaps;

public class Main {
    public static void main(String[] args) {
        HashMapFinal<String, String> map = new HashMapFinal<>();

        map.put("abhi","free");
        map.put("kunal","dsaCourse");
        System.out.println(map.containsKey("abhi"));

        map.remove("abhi");
        System.out.println(map.toString());
        System.out.println(map.containsKey("abhi"));


        KarpRabin algo = new KarpRabin();
        algo.search("komalkavichaya","chaya");

    }
}
