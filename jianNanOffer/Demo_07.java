package jianNanOffer;

import javax.sound.midi.SoundbankResource;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n
 * ，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 *1、1、2、3、5、8、13、21、34....
 * n<=39
 */
public class Demo_07 {
    public static void main(String[] args) {
        System.out.println(Fibonacci(39));
    }
    public static int Fibonacci(int n){
        if (n==0){
            return 0;
        }
//        int arr[]=new int[39];
//        arr[0] = arr[1]=1;int i=2;
//        for ( i = 2; i < arr.length; i++) {
//            arr[i] = arr[i-1]+arr[i-2];
//        }
//        return arr[n-1];
        int i=1,j=1; int sum=0;
        if (n==1 || n==2){
            return 1;
        }
        for (int k = 3; k <=n ; k++) {
            sum = i+j;
            i=j;
            j=sum;
        }
        return sum;

    }
}
