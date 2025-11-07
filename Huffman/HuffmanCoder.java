package Huffman;

import Heaps.Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HuffmanCoder {

    HashMap<Character,String> Encoder;
    HashMap<String,Character> Decoder;

    private class Node implements Comparable<Node>{
        Character data;
        int cost; // frequency
        Node left;
        Node right;


        public Node(Character data, int cost){
            this.data=data;
            this.cost=cost;
            this.left=null;
            this.right=null;
        }

        @Override
        public int compareTo(Node other){
            return this.cost-other.cost;
        }
    }

    public HuffmanCoder(String feeder) throws Exception{
        HashMap<Character, Integer> fmap = new HashMap<>();

        for(int i=0; i<feeder.length(); i++){
            char cc = feeder.charAt(i);

            if(fmap.containsKey(cc)){
                int ov = fmap.get(cc);
                ov++;
                fmap.put(cc,ov);
            }else{
                fmap.put(cc,1);
            }
        }

        Heap<Node> minHeap = new Heap<>();
        Set< Map.Entry<Character,Integer> > entrySet = fmap.entrySet();

        for(Map.Entry<Character,Integer> entry : entrySet){
            Node node = new Node(entry.getKey(),entry.getValue());
            minHeap.insert(node);
        }

        while (minHeap.size() !=1){
            Node first = minHeap.remove();
            Node second = minHeap.remove();

            Node newNode = new Node('\0', first.cost+second.cost);
            newNode.left = first;
            newNode.right=second;
            minHeap.insert(newNode);
        }

        Node ft = minHeap.remove();

        this.Encoder = new HashMap<>();
        this.Decoder = new HashMap<>();

        this.initEncoderDecoder(ft,"");
    }

    private void initEncoderDecoder(Node node, String osf){
        if(node == null){
            return;
        }

        if(node.left==null && node.right==null){
            this.Encoder.put(node.data, osf);
            this.Decoder.put(osf, node.data);
        }

        initEncoderDecoder(node.left, osf+"0");
        initEncoderDecoder(node.right, osf+"1");
    }

    public String encode(String source){
        String ans="";
        for(int i=0; i<source.length(); i++){
            ans = ans + Encoder.get(source.charAt(i));
        }
        return ans;
    }

    public String decode(String codedString){
        String key ="";
        String ans ="";
        for(int i=0; i<codedString.length(); i++){
            key = key+codedString.charAt(i);
            if(Decoder.containsKey(key)){
                ans = ans+Decoder.get(key);
                key="";
            }
        }
        return ans;

    }

}
