package jianNanOffer;

import java.util.Arrays;

/**
 * @program: Arithmetic
 * @description:
 * @author: wang_sir
 * @create: 2020-08-26 16:09
 * 一个整型数组里除了两个数字之外，
 * 其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 **/
public class JZ40 {
    public static void main(String[] args) {
        int[]arr = {3,4,3,6,2,2,5,5};
        int[]num1 = new int[1];
        int[]num2 = new int[1];
        FindNumsAppearOnce(arr,num1, num2);
        FindNumsAppearOnce2(arr,num1, num2);


    }

    /**
     * 采用异或运算
     * @param array
     * @param num1
     * @param num2
     */
    public static void FindNumsAppearOnce2(int [] array,int num1[] , int num2[]) {
        int d = 0;
        for (int i = 0; i < array.length; i++) {
            d ^= array[i];
        }
        d &= -d;
        for (int i = 0; i < array.length; i++) {
            if ((d & array[i]) == 0) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }
    /**
     * num1,num2分别为长度为1的数组。传出参数
     * 将num1[0],num2[0]设置为返回结果
     * @param array
     * @param num1
     * @param num2
     */
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        for (int i = 0; i < array.length ; i++) {
            for (int j = i+1; j < array.length ; j++) {
                if (array[i]==array[j]){
                    array[i]= Integer.MAX_VALUE;
                    array[j] = Integer.MAX_VALUE;
                }
            }
        }
        int [] temp = new int[2];
        int j = 0 ;
        for (int i = 0; i < array.length ; i++) {
            if (array[i]!=Integer.MAX_VALUE){
                temp[j] = array[i];
                j++;
            }
        }
        num1[0]= temp[0];
        num2[0]= temp[1];
    }
}
