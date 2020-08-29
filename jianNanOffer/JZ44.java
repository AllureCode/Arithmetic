package jianNanOffer;
/**
 * @program: Arithmetic
 * @description:
 * @author: wang_sir
 * @create: 2020-08-29 15:45
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，
 * 这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 **/
public class JZ44 {
    public static void main(String[] args) {
        String  s = "    ";
        String s1 = ReverseSentence(s);
        System.out.println(s1);
    }
    public static String ReverseSentence(String str) {
        String[] s = str.split(" ");
        //判断传入的字符串是否为空格
           if (s.length==0){
               return str;
           }
        String reverseStr = reverse(s, 0, s.length - 1);
        return reverseStr;
    }

    /***
     * 反转字符串
     * @param str
     * @param n
     * @param m
     * @return
     */
    public static String reverse(String[]str,int n,int m){
        String temp;
        while (n<m){
            temp = str[n];
            str[n] = str[m];
            str[m] = temp;
            n++;
            m--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]+" ");
        }
        //去除字符串最后一位的空格
        return sb.toString().trim();
    }
}
