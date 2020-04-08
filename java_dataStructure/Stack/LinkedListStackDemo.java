package java_dataStructure.Stack;

//链表实现栈
public class LinkedListStackDemo {
    public static void main(String[] args) {
        LinkedListStack linkedListStack =new LinkedListStack();
        linkedListStack.push(1);
        linkedListStack.push(2);
        linkedListStack.push(3);   linkedListStack.show();
        System.out.println("出栈元素"+linkedListStack.pop());
        linkedListStack.show();
    }
}




//定义链表实现栈
class LinkedListStack{
    private StackNode top=new StackNode();//定义栈顶
    private int size; //栈中的元素

    //判断是否栈空
    public boolean isEmpty(){
        return size == 0;
    }

    //入栈
    public void push(int val){
        StackNode node = new StackNode(val);
        if (isEmpty()){
            top = node;
        }else {
            node.setNext(top);
            top = node;
        }
        size++;
    }
    //出栈：删除并返回最后一个链表
    public int pop(){
        if (isEmpty()){
            System.out.println("栈空");
        }
        int data = top.getValue();
        top = top.getNext();
        size--;
        return data;
    }
    //显示栈
    public void show(){
        if (isEmpty()){
            System.out.println("栈空");
        }
        StackNode temp = top;
        for (int i = 0; i <size ; i++) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }
}


//定义节点
class StackNode{
    private int value;
    private StackNode next; //指向下一个节点

    public StackNode(int value) {
        this.value = value;
    }
    public StackNode(){}

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public StackNode getNext() {
        return next;
    }

    public void setNext(StackNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "StackNode{" +
                "value=" + value +
                '}';
    }
}