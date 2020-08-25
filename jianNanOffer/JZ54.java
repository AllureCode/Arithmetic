package jianNanOffer;


/**
 * @program: Arithmetic
 * @description:
 * @author: wang_sir
 * @create: 2020-08-24 17:11
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 **/
public class JZ54 {

    static String s="";
    static int[]chars = new int[256];
    public static void main(String[] args) {
        Insert('a');
        Insert('a');
        Insert('a');
        Insert('a');
        Insert('b');
        char c = FirstAppearingOnce();
        System.out.println(c);
    }

    public static void Insert(char ch)
    {
        s+=ch;
        chars[ch]++;
    }
    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce()
    {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length ; i++) {
            if (chars[ch[i]]==1){
                return ch[i];
            }
        }
        return '#';
    }
}
