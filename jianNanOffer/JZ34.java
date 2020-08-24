package jianNanOffer;

/**
 * @program: Arithmetic
 * @description:
 * @author: wang_sir
 * @create: 2020-08-24 15:32
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)
 * 中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 **/
public class JZ34 {
    public static void main(String[] args) {
        String s = "abcabcg";
        int i = FirstNotRepeatingChar_1(s);
        int j = FirstNotRepeatingChar_2(s);
        System.out.println(i);
        System.out.println(j);
    }

    /**
     * 方法二
     * 如果一个字符出现一次
     * 则它的初始下标==它的最后下标
     * @param str
     * @return
     */
    public static int FirstNotRepeatingChar_2(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length ; i++) {
            if (str.indexOf(chars[i]) == str.lastIndexOf(chars[i])){
                return i;
            }
        }
        return -1;
    }
    /**
     * 方法一 将字符串转为字符数组
     * 然后创建一个ch数组用于统计每个字符出现的次数
     * 遍历统计数组 将字符数组中为1的返回
     * @param str
     * @return
     */
    public static int FirstNotRepeatingChar_1(String str) {
        char[] chars = str.toCharArray();
        int[] ch = new int[256];
        for (int i = 0; i < chars.length; i++) {
            ch[chars[i]]++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (ch[chars[i]] == 1) {
                return i;
            }
        }
        return -1;
    }
}
