package jianNanOffer;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: Arithmetic
 * @description:
 * @author: wang_sir
 * @create: 2020-08-19 18:51
 * 输入n个整数，找出其中最小的K个数
 * 。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 **/
public class JZ29 {
    public static void main(String[] args) {
        int[]arr = new int[]{4,5,1,6,2,7,2,8,1};
        int[] ints = quicklySort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(ints));
        ArrayList<Integer> arrayList = GetLeastNumbers_Solution(ints, 2);
        System.out.println(arrayList);

        ArrayList list = minNumber(arr, 2);
        System.out.println(list);
    }


    public static ArrayList minNumber(int[]arr,int k){

        ArrayList<Integer> arrayList = new ArrayList<>();
        if (arr.length<k){
            return new ArrayList();
        }
        while (k>0) {
            int minNumber = arr[0];  int j = 0;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < minNumber) {
                    minNumber = arr[i];
                      j=i;
                }
            }
            arrayList.add(minNumber);
            k--;
            arr[j] = Integer.MAX_VALUE;
//            if (k==0){
//                break;
//            }
            for (int i = j; i < arr.length &&  k>0 ; i++) {
                if (minNumber == arr[i]){
                   arrayList.add(arr[i]);
                   arr[i] = Integer.MAX_VALUE;
                   k--;
                }
            }
        }
        return arrayList;
    }

    /**
     * 采用全速排序
     * @param input
     * @param k
     * @return
     */

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            arrayList.add(input[i]);
        }
        return arrayList;
    }
    public static int[] quicklySort(int[]arr,int left,int right){
        int l = left;
        int r = right;
        int temp;
        int midValue = arr[(r+l)/2];
        while (l<r){
            while (arr[l]<midValue){
                l++;
            }
            while (arr[r]>midValue){
                r--;
            }
            temp  = arr[l];
            arr[l] = arr[r];
            arr[r]  = temp;
            if (l>=r){
                break;
            }
            if (arr[l]==midValue){
                r--;
            }
            if (arr[r] == midValue){
                l++;
            }
        }
        if (l==r){
            l++;
            r--;
        }
        if (left < r) {
            quicklySort(arr, left, r);
        }
        if (right > l) {
            quicklySort(arr, l, right);
        }
        return arr;
    }
}
