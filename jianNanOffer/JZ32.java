package jianNanOffer;


import java.util.Arrays;

/**
 * @program: Arithmetic
 * @description:
 * @author: wang_sir
 * @create: 2020-08-20 17:56
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 **/
public class JZ32 {
    public static void main(String[] args) {
        int[]arr = new int[]{3,32,321};
        String s = PrintMinNumber(arr);
        System.out.println(s);
    }
    public static String PrintMinNumber(int [] numbers) {
        String s="";
        for (int i = 0; i < numbers.length; i++) {
           s = s+numbers[i];
        }
        char[] chars = s.toCharArray();
        char temp;
        System.out.println(Arrays.toString(chars));
        for (int i = 0; i <chars.length-1 ; i++) {
            for (int j = 0; j < chars.length-1-i; j++) {
                if (Integer.parseInt(String.valueOf(chars[j]))
                        >Integer.parseInt(String.valueOf(chars[j+1]))){
                    temp = chars[j];
                    chars[j] = chars[j+1];
                    chars[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(chars));
        return String.valueOf(chars);
    }
}
