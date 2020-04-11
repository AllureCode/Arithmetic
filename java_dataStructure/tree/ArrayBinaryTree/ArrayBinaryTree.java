package java_dataStructure.tree.ArrayBinaryTree;

/**
 * 利用数组顺序存储二叉树
 */
public class ArrayBinaryTree {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7};
        ArrBinaryTree binaryTree = new ArrBinaryTree(arr);
        binaryTree.preOrder();
        System.out.println();
        binaryTree.midOrder(0);
    }
}

class ArrBinaryTree{
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }
    //重载
    public void preOrder(){
        this.preOrder(0);
    }
    public void preOrder(int index){
        if (arr==null ||arr.length==0) {
            System.out.println("数组为空");
        }
        System.out.print(arr[index]);
        //向左递归
        if((2*index+1)<arr.length){
            preOrder(2*index+1);
        }
        //向右递归
        if ((2*index+2) <arr.length){
            preOrder(2*index +2);
        }
    }
    public void midOrder(int index){
        if(arr==null ||arr.length==0){
            System.out.println("数组为空");
        }
        if (2*index+1 <arr.length){
            midOrder(2*index +1);
        }
        System.out.print(arr[index]);
        if(2*index+2 <arr.length){
            midOrder(2*index+2);
        }
    }
}
