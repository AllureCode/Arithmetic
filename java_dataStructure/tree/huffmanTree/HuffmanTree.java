package java_dataStructure.tree.huffmanTree;

import java.util.*;

/**
 * HuffmanTree
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[]arr={13,7,8,3,29,6,1};
        Node huffman = createHuffman(arr);
        preOrder(huffman);
    }
    //前序遍历
    public static  void preOrder(Node root){
        if (root!=null){
            root.preOrder();
        }else {
            System.out.println("空树");
        }
    }

    public static Node createHuffman(int[]arr){
        //First, load the array elements into the list collection for comparison
        List<Node> hlist = new ArrayList<Node>();
        for (int node:arr){
            hlist.add(new Node(node));
        }
        while (hlist.size()>1) {
            //从小到大排序
            Collections.sort(hlist);
            //取出权值最小的两个进行组合
            Node leftNode = hlist.get(0);
            Node rightNode = hlist.get(1);
            Node parents = new Node(leftNode.getValue() + rightNode.getValue());
            parents.setLeftNode(leftNode);
            parents.setRightNode(rightNode);
            hlist.remove(leftNode);
            hlist.remove(rightNode);
            hlist.add(parents);
        }
        return hlist.get(0);
    }

}
class Node implements Comparable<Node>{
    private int value;
    private Node leftNode;
    private Node rightNode;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value-o.value;
    }
    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.leftNode!=null){
            this.leftNode.preOrder();
        }
        if (this.rightNode!=null){
            this.rightNode.preOrder();
        }
    }
}