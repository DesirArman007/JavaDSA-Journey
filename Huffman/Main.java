package Huffman;

public class Main {
    public static void main(String[] args) throws Exception{
        String str = "Abhishek";
        HuffmanCoder hc = new HuffmanCoder(str);

        String encoded = hc.encode(str);
        System.out.println("Encoded: " + encoded);

        String decoded = hc.decode(encoded);
        System.out.println("Decoded: " + decoded);
    }
}
