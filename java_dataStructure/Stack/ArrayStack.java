package java_dataStructure.Stack;

import java.util.Stack;

//数据实现栈
public class ArrayStack {
    public static void main(String[] args) {
        defineStack<Integer> defineStack = new defineStack<>(5);
      defineStack.push(1);
      defineStack.push(2);
      defineStack.push(3);
        System.out.println("原始栈");
        defineStack.show();
        System.out.println("出栈");
        defineStack.pop();
        defineStack.show();
        System.out.println("栈顶");
        System.out.println(defineStack.peek());
        System.out.println("出栈");
        defineStack.pop();
        defineStack.show();
        System.out.println("栈顶");
        System.out.println(defineStack.peek());

    }
}

//定义一个栈
class defineStack<T>{
    private int maxSize; //栈的最大容量
    private int stack[]; //定义一个数组存储值
    private int top=-1; //定义栈顶

    public defineStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];//初始化数组
    }

    //判断是否栈满
    public  boolean isFull(){
        return top == maxSize-1;
    }
    //判断是否栈空
    public boolean isEmpty(){
        return top == -1;
    }
    //入栈
    public void push(int val){
        if (isFull()){
            System.out.println("栈满 无法加入");
            return;
        }
        top++;
        stack[top] = val;
    }
    //栈顶
    public int peek(){
        if (isEmpty()){
            System.out.println("栈空");
        }
        return stack[top];
    }
    //出栈
    public  int  pop(){
        if (isEmpty()){
            System.out.println("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }
    //显示栈
    public void show(){
        if (isEmpty()){
            System.out.println("栈空");
        }
        for (int i = top; i >=0 ; i--) {
            System.out.println(stack[i]);
        }
    }
}
