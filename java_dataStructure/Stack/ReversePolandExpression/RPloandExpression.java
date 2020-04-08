package java_dataStructure.Stack.ReversePolandExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 用逆波兰表达式实现计算器
 */
public class RPloandExpression {
    public static void main(String[] args) {
        //(3+4)*5-6 逆波兰表达式为 3 4 + 5 * 6 -
        String expression = "3 4 + 5 * 6 -";
        System.out.println(getExpressionList(expression));
        System.out.println(calculateResult(getExpressionList(expression)));
    }

    //将逆波兰表达式放入一个list集合
    public static List<String> getExpressionList(String expression) {
        String[] s = expression.split(" ");
        List<String> rpnList = new ArrayList<String>();
        for (String s1 : s) {
            rpnList.add(s1);
        }
        return rpnList;
    }

    /*遍历list集合 然后从中取出每一个list值进行判断
      逆波兰表达式具体思路：
      从左到右的顺序扫描表达式 将前两个数字入栈 遇到符号时从栈中pop出两个数
      然后根据符号进行计算 将计算的值再次入栈
      然后继续扫描表达式 遇到数字就入栈 遇到符号就继续从栈中pop出两个数然后跟符号进行运算
      当把表达式扫描完成后 栈中所剩的就是计算结果
    */
    public static int calculateResult(List<String> rpnList) {
        int result = 0;
        Stack<String> stack = new Stack<String>();
        for (String str : rpnList) {
            //判断是否为数字
            if (str.matches("^\\d+$")) {
                stack.push(str);
            } else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                if (str.equals("+")) {
                    result = num1 + num2;
                } else if (str.equals("-")) {
                    result = num2 - num1;
                } else if (str.equals("*")) {
                    result = num1 * num2;
                } else if (str.equals("/")) {
                    result = num2 / num1;
                } else {
                    throw new RuntimeException("表达式中运算符有误");
                }
                stack.push(result+"");
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
