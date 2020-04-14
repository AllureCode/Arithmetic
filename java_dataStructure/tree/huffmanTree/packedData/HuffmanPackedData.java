package java_dataStructure.tree.huffmanTree.packedData;

import java.util.*;

/**
 * packedData：create HuffmanTree
 */
class HuffmanTreePackedData {
    public static void main(String[] args) {
        String content="i like like like java do you like a java";
        byte[] bytes = content.getBytes();
        List<Node> array = createArray(bytes);
        Node huffmanTree = createHuffmanTree(array);
        perOrder(huffmanTree);
        Map<Byte, String> huffmanCode = getHuffmanCodeTable(huffmanTree);
        System.out.println(huffmanCode.toString());
    }


    /**
     * To simplify Huffman code table calls
     * @param root
     * @return
     */
    private static  Map<Byte,String> getHuffmanCodeTable(Node root){
        try {
            huffmanCodeTable(root.getLeftNode(), "0", stringBuilder);
            huffmanCodeTable(root.getRightNode(), "1", stringBuilder);
        } catch (Exception e) {
            System.out.println("null huffman tree");
        }
        return huffmanCode;
    }
     /**
     *
     * @param node Pass the Huffman node
     * @param value The path is 0 to the left and 1 to the right
     * @param stringBuilder For splicing paths
     */
    static StringBuilder stringBuilder = new StringBuilder();
    static Map<Byte,String> huffmanCode = new HashMap<Byte, String>();
    public static void huffmanCodeTable(Node node,String value,StringBuilder stringBuilder){
        //create new stringBuilder1 is to clean up and carry splicing paths
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(value);
        if (node!=null){
            //According to [node.getCharacter()]Determines whether the current node is a leaf node
            //If[node.getCharacter（）==null] Is the parent node or the leaf node
            if (node.getCharacter()==null){
                //left recursion
                huffmanCodeTable(node.getLeftNode(), "0", stringBuilder1);
                //right recursion
                huffmanCodeTable(node.getRightNode(), "1", stringBuilder1);
            }else {
                huffmanCode.put(node.getCharacter(), stringBuilder1.toString());
            }
        }
    }
    /**
     * Creates a method to count the number of occurrences per character
     * 1.create ArrayList and save node information
     * 2.    traversal byte[] and to count the number of occurrences per character
     *           use Map[] save information
     * 3.Traverse the map to get the corresponding node information
     * @param bytes
     * @return
     */
    public static List<Node> createArray(byte[] bytes){
        List<Node> nodeList = new ArrayList<Node>();
        Map<Byte,Integer> countMap = new HashMap<Byte, Integer>();
        for (byte b:bytes){
            Integer count = countMap.get(b);
            if (count == null){
                countMap.put(b,1 );
            }else {
                countMap.put(b, count+1);
            }
        }
        for (Map.Entry<Byte,Integer> m:countMap.entrySet()){
            nodeList.add(new Node(m.getKey(), m.getValue()));
        }
        return nodeList;
    }
    /**
     * method:createHuffmanTree
     * 1.While nodes.size>1 traversal List
     * 2.Use Collections.sort method and sort nodes
     * 3.Take two smaller elements from the set and add them together to get the parent node
     * 4.remove Used Node
     * @param nodes:current node
     * @return:huffmanTree root node
     */
    public static Node createHuffmanTree(List<Node> nodes){
        while (nodes.size()>1){
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            //note：No parents node character
            Node parents = new Node(null, leftNode.getWeightValue() + rightNode.getWeightValue());
            parents.setLeftNode(leftNode);
            parents.setRightNode(rightNode);
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parents);
        }
        return nodes.get(0);
    }
    /**
     * preOrder traversal
     * @param root:Huffman Tree root Node
     */
    public static void perOrder(Node root){
        if (root!=null){
            root.preOrder();
        }
    }
}

/*create Node：
  save huffmanTree Node data
 */
class Node implements Comparable<Node>{
    private int weightValue;
    private Byte character;
    private Node leftNode;
    private Node rightNode;

    public Node( Byte character,int weightValue) {
        this.weightValue = weightValue;
        this.character = character;
    }

    public int getWeightValue() {
        return weightValue;
    }

    public void setWeightValue(int weightValue) {
        this.weightValue = weightValue;
    }

    public Byte getCharacter() {
        return character;
    }

    public void setCharacter(Byte character) {
        this.character = character;
    }

    public void setCharacter(byte character) {
        this.character = character;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "character=" + character +
                ", weightValue=" + weightValue +
                '}';
    }

    //preOrder traversal HuffmanTree
    public void preOrder(){
        System.out.println(this);
        if(this.leftNode!=null){
            this.leftNode.preOrder();
        }
        if (this.rightNode!=null){
            this.rightNode.preOrder();
        }
    }

    @Override
    public int compareTo(Node o) {
        return this.getWeightValue()-o.getWeightValue();
    }
}