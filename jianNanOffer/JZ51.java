package jianNanOffer;

import java.util.Arrays;

/**
 * @program: Arithmetic
 * @description:
 * @author: wang_sir
 * @create: 2020-08-20 17:18
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，
 * B[n-1] = A[0] * A[1] * ... * A[n-2];）
 *
 *  //    ---------------------
 *     // B0 | 1  | A1 | A2 | A3 |
 *     //    ---------------------
 *     // B1 | A0 | 1  | A2 | A3 |
 *     //    ---------------------
 *     // B2 | A0 | A1 | 1  | A3 |
 *     //    ---------------------
 *     // B3 | A0 | A1 | A2 | 1  |
 *     //    ---------------------
 *     //以上面的4*4数组为例
 *     //B0 = A1*A2*A3,B1 = A0*A2*A3,B2 = A0*A1*A3,B3 = A0*A1*A2
 *
 * B[0] = A[1] * A[2] * A[3] * A[4] *....*A[n-1] ;（没有A[0]）
 * B[1] = A[0] * A[2] * A[3] * A[4] *....*A[n-1] ;（没有A[1]）
 * B[2] = A[0] * A[1] * A[3] * A[4] *....*A[n-1] ;（没有A[2]）
 * 对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
 **/
public class JZ51 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
        int[] multiply = multiply(arr);
        System.out.println(Arrays.toString(multiply));
    }
    public static int[] multiply(int[] A) {
        int[]B = new int[A.length];
        int j = 0;
        int temp = 0;
        for (int i = 0; i < A.length ; i++) {
            if (j == i){
                temp = A[i];
                A[i]=1;
            }
            B[j] = sum(A);
            A[i] = temp;
            j++;
        }
        return B;
    }
    public static int sum(int[]A){
        System.out.println(Arrays.toString(A));
        int result = 1;
        for (int i = 0; i < A.length; i++) {
            result = result*A[i];
        }
        return result;
    }
}
