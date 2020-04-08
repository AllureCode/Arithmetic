package java_dataStructure.Stack.InfixTransfixSuffix;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中缀表达式转为后缀表达式
 * 思路：
 * 1.初始化两个栈 一个数栈 一个符号栈
 * 2.从左到右扫描表达式
 * 3.遇到数字时 将其压入数栈
 * 4.遇到符号时比较其与符号栈顶的运算符的优先级
 * 4.1如果符号栈为空 则直接将其入符号栈
 * 4.2若优先级比符号栈的高 则将其继续压入符号栈
 * 4.3否则将符号栈顶的运算符弹出并压入数栈中再次转到4.1与符号栈中新的栈顶运算符进行比较
 * 5遇到括号时：
 * 如果是（ 则直接压入符号栈
 * 如果时 ）则依次弹出符号栈的运算符 并压入数栈中 直到遇到（ 为止
 * 此时将这一对括号丢弃重复步骤2-5直到表达式最右端
 * 6将剩余符号栈中的符号出栈然后压入数栈中 依次弹出数栈的元素将其逆序则为最终结果
 */
public class DemoCode {
    public static void main(String[] args) {
        String str = "10+((2+3)*4)-5";
        List<String> strings = infixToList(str);
        System.out.println(strings.toString());
        List<String> strings1 = infixToSuffix(strings);
        System.out.println(strings1.toString());
        System.out.println("计算结果："+rpnToCalculate(strings1));
    }

    //逆波兰计算器
    public static  int rpnToCalculate(List<String> list){
        Stack<String> stack = new Stack<String>();
        int res=0;
        for (String rpnList:list){
            if (rpnList.matches("^\\d+$")){
                stack.push(rpnList);
            }else {
                int num1=Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                if (rpnList.equals("+")){
                    res=num1+num2;
                }else if(rpnList.equals("-")){
                    res=num2-num1;
                }else if(rpnList.equals("*")){
                    res=num1*num2;
                }else if(rpnList.equals("/")){
                    res = num2/num1;
                }else {
                    return 0;
                }
                stack.push(res+"");
            }
        }
        return Integer.parseInt(stack.pop());
    }


    //将中缀表达式转为后缀表达式
    public static List<String> infixToSuffix(List<String> list) {
       /*1.初始化两个栈 一个数栈 一个符号栈
        因为在操作过程中 我们的数栈没有弹出操作只是用于保存 为了简化
        将数栈使用List集合替代
       */
        Stack<String> characterStack = new Stack<String>();
        List<String> numSave = new ArrayList<String>();
        //从左到右扫描表达式
        for (String item : list) {
            //如果是数字 则直接添加到集合中
            if (item.matches("^\\d+$")) {
                numSave.add(item);
            }
// * 如果是（ 则直接压入符号栈
            else if (item.equals("(")) {
                characterStack.push(item);
            } else if (item.equals(")")) {
//* 如果是 ）则依次弹出符号栈的运算符 添加到List集合中 直到遇到（ 为止
                while (!characterStack.peek().equals("(")) {
                    numSave.add(characterStack.pop());
                }
                // * 此时将这一对括号丢弃重复步骤2-5直到表达式最右端
                characterStack.pop();
            } else {
               /** 4.遇到符号时比较其与符号栈顶的运算符的优先级
                * 4.1如果符号栈为空 则直接将其入符号栈
                * 4.2若优先级比符号栈的高 则将其继续压入符号栈
                * 4.3否则将符号栈顶的运算符弹出并压入数栈中再次转到4.1与符号栈中新的栈顶运算符进行比较
               * */
                while (!characterStack.isEmpty() && Priority(item) <= Priority(characterStack.peek())) {
                  numSave.add(characterStack.pop());
                }
                characterStack.push(item);
            }

        }
         //6将剩余符号栈中的符号出栈然后压入数栈中 依次弹出数栈的元素将其逆序则为最终结果
        while(!characterStack.isEmpty()){
            numSave.add(characterStack.pop());
        }
        return numSave;
    }

    //比较操作符优先级
    public static int Priority(String operator) {
        int res = 0;
        switch (operator) {
            case "+":
                res = 1;
                break;
            case "-":
                res = 1;
                break;
            case "*":
                res = 2;
                break;
            case "/":
                res = 2;
                break;
            default:
                return -1;

        }
        return res;
    }


    //将中缀表达式转为对应得List
    public static List<String> infixToList(String str) {
        List<String> list = new ArrayList<String>();
        int index = 0;//索引
        char c = ' '; //存储每一个str
        while (index < str.length()) {
            //判断取出的是否为数字
            //是字符
            if ((c = str.charAt(index)) < 48 || (c = str.charAt(index)) > 57) {
                list.add(c + "");
                index++;
            } else {//为一个数字 则考虑是否为多位数
                String tmp = "";
                while (index < str.length() && (c = str.charAt(index)) >= 48 && (c = str.charAt(index)) <= 57) {
                    tmp += c;
                    index++;
                }
                list.add(tmp);
            }
        }
        return list;
    }
}

