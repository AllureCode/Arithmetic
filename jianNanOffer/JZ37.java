package jianNanOffer;

import java.util.ArrayList;

/**
 * @program: Arithmetic
 * @description:
 * @author: wang_sir
 * @create: 2020-08-22 09:38
 * 统计一个数字在升序数组中出现的次数。
 **/
public class JZ37 {
    public static void main(String[] args) {
        int[]arr =new int[]{1,2,3,4,5,6,7,7,7,8,9,10};
        System.out.println(GetNumberOfK(arr,7));
        System.out.println(GetNumberOfK2(arr,7));
    }

    /**
     * 二分求解
     * @param array
     * @param k
     * @return
     */
    public static int GetNumberOfK2(int [] array , int k) {
        int left = 0;
        int right = array.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if (k == array[mid]){
                ArrayList<Integer> arrayList = new ArrayList<>();
                int tempLeft = mid-1;
                while (true){
                    if (tempLeft<0||array[tempLeft]!=k){
                        break;
                    }
                    arrayList.add(array[tempLeft]);
                    tempLeft-=1;
                }
                arrayList.add(array[mid]);
                int tempRight = mid + 1;
                while (true){
                    if (tempRight>array.length-1||array[tempRight]!=k){
                        break;
                    }
                    arrayList.add(array[tempRight]);
                    tempRight+=1;
                }
                return arrayList.size();
            }else  if (k < array[mid]){
               right = mid-1;
            }else {
               left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 暴力求解
     * @param array
     * @param k
     * @return
     */
    public static int GetNumberOfK(int [] array , int k) {
        int count = 0;
        for (int i = 0; i <array.length ; i++) {
            if (array[i]==k){
                count++;
            }
        }
        return count;
    }
}
