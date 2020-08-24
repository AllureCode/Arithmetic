package jianNanOffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * @program: Arithmetic
 * @description:
 * @author: wang_sir
 * @create: 2020-08-24 13:45
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 **/
public class JZ21 {
    public static void main(String[] args) {
        int []arr = new int[]{1,2,3,4,5};
        int []arr2 = new int[]{4,3,5,2,1};
        boolean b = IsPopOrder(arr, arr2);
        System.out.println(b);
    }
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (popA.length==0 || pushA.length==0){
            return false;
        }
        int index = 0;
        Stack<Integer>  stack = new Stack<>();
        for (int i = 0; i < pushA.length ; i++) {
            stack.push(pushA[i]);
            while (!stack.empty() && stack.peek()==popA[index]){
                stack.pop();
                index++;
            }
        }
        return stack.empty();
    }
}
