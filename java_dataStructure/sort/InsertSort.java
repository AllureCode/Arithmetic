package java_dataStructure.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        //int[] arr = {10, 9, 5, 6, 4};
        int arr[]= new int[80000];
        for (int i=0;i<80000;i++){
            arr[i] = (int) (Math.random()*80000);
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(new Date());
        System.out.println(format);
        insertSort(arr);
        String format1 = dateFormat.format(new Date());
        System.out.println(format1);
    }
    public static void insertSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            //存储要交换的当前值
            int insertValue = arr[i];
            //要进行比较的前一位索引
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            //退出while循环时即找到插入的位置
            arr[insertIndex+1] = insertValue;
        }
        System.out.println(Arrays.toString(arr));
    }
}
