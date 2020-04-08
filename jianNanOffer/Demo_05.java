package jianNanOffer;

import sun.security.util.AuthResources_it;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Demo_05 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);  //1 2
    }

    public int pop() {
        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());  // 2  1
            }
        }
        return stack2.pop();
    }
}

class test {
    public static void main(String[] args) {
        Demo_05 demo_05 = new Demo_05();
        demo_05.push(1);
        demo_05.push(2);
        demo_05.push(3);
        demo_05.push(4);
        System.out.println(demo_05.pop());
        System.out.println(demo_05.pop());
        System.out.println(demo_05.pop());
        System.out.println(demo_05.pop());
    }
}

