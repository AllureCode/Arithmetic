package jianNanOffer;

/**
 * @program: Arithmetic
 * @description: 剑南47
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、
 * case等关键字及条件判断语句（A?B:C）。
 * @author: wang_sir
 * @create: 2020-07-19 23:20
 **/
public class JZ47 {
    public static void main(String[] args) {
        System.out.println(sum(4));
        System.out.println(sum2(4));
    }
    public static int sum(int n){
        int result = (int)(Math.pow(n, 2)+n)>>1;
        return result;
    }
    public static int sum2(int n){
        int result = n ;
        boolean flag = (n>1)&&((result+=sum2(n-1))>0);
        return result;
    }

}
