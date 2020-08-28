package jianNanOffer;

/**
 * @program: Arithmetic
 * @description:
 * @author: wang_sir
 * @create: 2020-08-28 15:21
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
 * 即“XYZdefabc”。是不是很简单？OK，搞定它！
 **/
public class JZ43 {
    public static void main(String[] args) {
        String string = LeftRotateString2("abcXYZdef", 3);
        System.out.println(string);
    }

    /**
     * 反转字符串实现
     * S="abcXYZdef"
     * 第一次反转--->cbaXYZdef     反转前n-1个字符
     * 第二次反转---->cbafedZYX    反转n-str.length-1个字符
     * 第三次反转---->XYZdefabc    反转0-str.length-1个字符
     *
     * @param str
     * @param n
     * @return
     */
    public static String LeftRotateString2(String str, int n) {
        String reverse1 = reverse(str, 0, n - 1);
        System.out.println(reverse1);
        String reverse2 = reverse(reverse1, n, str.length() - 1);
        System.out.println(reverse2);
        String reverse = reverse(reverse2, 0, str.length() - 1);
        return reverse;
    }

    /**
     * 反转函数
     *
     * @param str 反转字符串
     * @param n   开始位置
     * @param m   结束位置
     * @return
     */
    public static String reverse(String str, int n, int m) {
        char[] chars = str.toCharArray();
        char temp;
        while (n < m) {
            temp = chars[n];
            chars[n] = chars[m];
            chars[m] = temp;
            n++;
            m--;
        }
        return String.valueOf(chars);
    }

    /**
     * 利用数组实现
     *
     * @param str
     * @param n
     * @return
     */
    public static String LeftRotateString(String str, int n) {
        char[] chars = str.toCharArray();
        char[] temp = new char[chars.length];
        int j = 0;
        int m = 0;
        for (int i = n; i < chars.length; i++) {
            temp[j] = chars[i];
            j++;
        }
        for (int k = j; k < temp.length; k++) {
            temp[k] = chars[m];
            m++;
        }
        return String.valueOf(temp);
    }
}
