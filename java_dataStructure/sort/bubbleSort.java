package java_dataStructure.sort;


import java.util.Arrays;

/**
 * 冒泡排序
 */
public class bubbleSort {
    public static void main(String[] args) {
        int temp=0;boolean flag=false;
        int arr[]={10,8,11,5,6};
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = 0; j <arr.length-1-i ; j++) {
                if (arr[j]>arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

            }
            if (!flag){
             break;  //优化程序 如果一次都没有进入循环则证明数组本身是有序的
            }else {
                flag = false; //重置flag
            }
            System.out.println("第"+(i+1)+"趟");
            System.out.println(Arrays.toString(arr));
        }
    }
}
