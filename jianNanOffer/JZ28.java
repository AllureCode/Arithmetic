package jianNanOffer;

import java.util.Arrays;

/**
 * @program: Arithmetic
 * @description:
 * @author: wang_sir
 * @create: 2020-08-25 10:34
 * 数组中有一个数字出现的次数超过数组长度的一半，
 * 请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 **/
public class JZ28 {
    public static void main(String[] args) {
        int[] arr = {1};
        int i = MoreThanHalfNum_Solution(arr);
        System.out.println(i);
        int i1 = MoreThanHalfNum_Solution2(arr);
        System.out.println(i1);
    }

    /**
     * 将原数组排序 如果存在这样一个数 则这个数必然是中位数
     * 遍历排序后数组 统计于中位数相同的数字个数
     * 如果大于数组长度 则返回此数
     * @param array
     * @return
     */
    public static int MoreThanHalfNum_Solution2(int[] array) {
        Arrays.sort(array);
        int count = 0;
        for (int i = 0; i < array.length ; i++) {
            if (array[i]==array[array.length/2]){
                count++;
            }
        }
        if (count>array.length/2){
            return array[array.length/2];
        }else {
            return 0;
        }
    }
    /**
     * 创建一个新数组temp 用于计数
     * array{1,2,3,2,2,2,5,4,2}
     * 例如temp[array[0]]=1 就是array数组1在temp数组对应位置上出现的次数
     * @param array
     * @return
     */
    public static int MoreThanHalfNum_Solution(int[] array) {
        int[] temp = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            temp[array[i]]++;
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > array.length / 2) {
                return i;
            }
        }
        return 0;
    }
}
