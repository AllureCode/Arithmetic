package java_dataStructure.Stack.Calculator;
public class Calculater {
    public static void main(String[] args) {
        //创建一个数栈 保存数字
        CalStack numberStack = new CalStack(10);
        //创建一个符号栈 保存符号
        CalStack characterStack = new CalStack(10);
        //创建一个表达式
        String expression = "36+2*6-2";
        int num1 = 0;
        int num2 = 0;
        int sumResult = 0;    //结果值
        int index = 0; //索引
        char ch = ' ';
        int opera = 0;
        String joint = "";
        while (true) {
            //取出表达式中得每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            //判断是否为字符
            if (characterStack.isOperator(ch)) {
                //判断符号栈是否为空
                if (!characterStack.isEmpty()) {
                    /*判断符号的优先级 如果优先级小于或等于当前栈中的操作符，就需要从数栈中pop出两个数
                     * 从符号栈pop出运算符然后计算两个数的结果然后入数栈 再将当前的符号入符号栈
                     * 如果当前的优先级大于栈中的优先级 则直接入符号栈
                     */
                    if (characterStack.priority(ch) <= characterStack.priority(characterStack.peek())) {
                        num1 = numberStack.pop();
                        num2 = numberStack.pop();
                        opera = characterStack.pop();
                        sumResult = numberStack.result(num1, num2, opera);
                        numberStack.push(sumResult);
                        characterStack.push(ch);
                    } else {
                        characterStack.push(ch);
                    }
                } else {
                    //为空直接入栈
                    characterStack.push(ch);
                }

            } else {
                //不是字符直接入数栈
//                numberStack.push(ch - 48);
                //判断是否是多位数字(即判断index的时候再想后面走一位看是否为符号位 如果是则直接入栈 否则拼接字符串)
                joint += ch;
                if (index == expression.length() - 1) {
                    //最后一位 直接入栈
                    numberStack.push(Integer.parseInt(joint));
                } else {
                    if (characterStack.isOperator(expression.substring(index + 1, index + 2).charAt(0))) {
                        numberStack.push(Integer.parseInt(joint));
                        joint = "";
                    }
                }
            }
            index++;
            if (index >= expression.length()) {
                break;
            }
        }
        //当表达式扫描完毕 就顺序的从数栈和符号栈中pop从相应的数字和符号
        while (true) {
            if (characterStack.isEmpty()) {
                break;
            }
            num1 = numberStack.pop();
            num2 = numberStack.pop();
            opera = characterStack.pop();
            sumResult = numberStack.result(num1, num2, opera);
            numberStack.push(sumResult);
        }

        System.out.println("结果" + numberStack.pop());
    }
}

//定义一个栈
class CalStack {
    private int maxSize;  //栈顶内存大小
    private int[] stack;  //存储数据
    private int top = -1;  //栈顶

    public CalStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //判断是否为空
    public boolean isEmpty() {
        return top == -1;
    }

    //判断是否栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            System.out.println("空栈");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //取栈顶
    public int peek() {
        if (isEmpty()) {
            System.out.println("空栈");
        }
        return stack[top];
    }

    //判断优先级
    public int priority(int operator) {
        if (operator == '*' || operator == '/') {
            return 1;
        } else if (operator == '+' || operator == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //判断是否为操作符
    public boolean isOperator(char operator) {
        return operator == '*' || operator == '/' || operator == '+' || operator == '-';
    }

    //进行计算
    public int result(int num1, int num2, int operator) {
        int sum = 0;
        switch (operator) {
            case '*':
                sum = num1 * num2;
                break;
            case '/':
                sum = num2 / num1;
                break;
            case '+':
                sum = num1 + num2;
                break;
            case '-':
                sum = num2 - num1;
                break;
            default:
                break;
        }
        return sum;
    }
}