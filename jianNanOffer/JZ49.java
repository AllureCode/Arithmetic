package jianNanOffer;

import com.sun.org.apache.regexp.internal.RE;

import java.util.zip.Checksum;

/**
 * @program: Arithmetic
 * @description:
 * @author: wang_sir
 * @create: 2020-08-28 11:13
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 * 输入
 * +2147483647
 * 1a33
 * 输出
 * 2147483647
 * 0
 **/
public class JZ49 {
    public static void main(String[] args) {
        int i = StrToInt("-123");
        System.out.println(i);
    }
    public static int StrToInt(String str) {
        if(str.length()==0){
            return 0;
        }
        int sum = 0;
        int i = 0;
        int flag = 1;
        if (str.charAt(0)=='-'){
            flag = -1;
            i++;
        }
        if (str.charAt(0)=='+'){
            i++;
        }
        for ( ; i < str.length() ; i++) {
            if (str.charAt(i)<'0'  || str.charAt(i)>'9'){
                return 0;
            }
            sum = sum * 10 + str.charAt(i) - '0';
            //检查是否越界
            if (((flag==1)&&(sum==Integer.MIN_VALUE)) ||
                    ((flag==-1) && (sum*flag==Integer.MAX_VALUE))){
                return 0;
            }
        }
        return sum*flag;
    }
}
