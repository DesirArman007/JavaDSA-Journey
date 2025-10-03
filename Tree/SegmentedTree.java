package Tree;

public class SegmentedTree {

    private static class  Node{
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval,int endInterval){
            this.startInterval=startInterval;
            this.endInterval=endInterval;
        }
    }

    Node root;

    public SegmentedTree(int[] arr){
        // create a tree using this array
        this.root = constructTree(arr, 0, arr.length-1);
    }

    private Node constructTree(int[] arr, int start, int end){
        if(start==end){
            // leaf node
            Node leaf = new Node(start,end);
            leaf.data = arr[start];
            return leaf;
        }
        // create new node with index you are at
        Node node = new Node(start,end);
        int mid = (start+end)/2;
        node.left = constructTree(arr, start,mid);
        node.right = constructTree(arr,mid+1, end);
        node.data= node.left.data + node.right.data;
        return node;
    }

    public void display(){
        display(this.root);
    }

    private void display(Node node){

        String str = " ";

// Left child
        if (node.left != null) {
            str = str + "Interval=[" + node.left.startInterval + "-" + node.left.endInterval +
                    "] and data=" + node.left.data + " => ";
        } else {
            str = str + "No left child => ";
        }

// Current node
        str = str + "Interval=[" + node.startInterval + "-" + node.endInterval +
                "] and data=" + node.data + " <= ";

// Right child
        if (node.right != null) {
            str = str + "Interval=[" + node.right.startInterval + "-" + node.right.endInterval +
                    "] and data=" + node.right.data;
        } else {
            str = str + "No right child";
        }


        System.out.println(str );

        // call recursion
        if(node.left!=null){
            display(node.left);
        }

        if(node.right!=null){
            display(node.right);
        }
    }


    //query
    public int query(int qsi, int qei){
        return this.query(this.root, qsi,qei);
    }

    private int query(Node node, int start, int end){
        if(node.startInterval >= start && node.endInterval <= end){
            // node is complelety lying inside query
            return node.data;
        } else if(node.startInterval > end || node.endInterval < start){
            return 0;
        } else{
            return this.query(node.left, start,end)+ this.query(node.right,start,end);
        }
    }

    // update
    public void update(int index, int value){
         this.root.data = update(this.root, index, value);
    }

    private int update(Node node, int index, int value) {
        if (index >= node.startInterval && index <= node.endInterval) {
            if (index == node.startInterval && index == node.endInterval) {
                node.data = value;
                return node.data;
            } else {
                int leftAns = update(node.left, index, value);
                int rightAns = update(node.right, index, value);
                node.data = leftAns + rightAns;
                return node.data;
            }
        }
        return node.data;
    }
}
